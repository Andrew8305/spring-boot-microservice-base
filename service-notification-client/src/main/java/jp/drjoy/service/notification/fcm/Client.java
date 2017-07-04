package jp.drjoy.service.notification.fcm;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;

public class Client {

    private static final Map<String, Boolean> RETRYABLE_ERRORS;

    static {
        RETRYABLE_ERRORS = new HashMap<>();
        RETRYABLE_ERRORS.put("Unavailable", true);
        RETRYABLE_ERRORS.put("InternalServerError", true);
    }

    private final FcmHttpClient fcmHttpClient;
    private final BackoffProvider provider;

    public Client() {
        this(new DefaultFcmHttpClient(), new ExponentialBackoffProvider());
    }

    public Client(FcmHttpClient fcmHttpClient,
            BackoffProvider provider) {
        this.fcmHttpClient = checkNotNull(fcmHttpClient);
        this.provider = checkNotNull(provider);
    }

    public FcmHttpResponse send(final Message message) {
        FcmHttpResponse fcmResponse = null;

        List<String> targets = targetAsStringsList(message);

        // make a copy of the targets to keep track of results during retries
        List<String> localTo = new ArrayList<>(targets);

        // Used to compute results for multicast messages with retries
        Map<String, Result> resultState = new HashMap<>();
        int multicastId = 0;
        while (provider.sendAnother()) {
            fcmResponse = fcmHttpClient.send(message);

            if (fcmResponse.getResults().size() > 0) {
                List<String> toRetry = checkResults(fcmResponse.getResults(), localTo, resultState);
                boolean doRetry = !toRetry.isEmpty();
                multicastId = fcmResponse.getMulticastId();

                if (doRetry) {
                    localTo = new ArrayList<>(toRetry);

                    Duration retryAfter = fcmResponse.durationOfRetryAfter();
                    if (retryAfter.compareTo(Duration.ZERO) > 0) {
                        provider.setMin(retryAfter);
                    }
                    if (message.getRegistrationIds().size() > 0) {
                        message.setRegistrationIds(toRetry);
                    }
                    try {
                        provider.sleep();
                    } catch (InterruptedException e) {
                        // ignore
                    }
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        if (!targets.isEmpty()) {
            fcmResponse = buildResponseForMulticast(targets, resultState,
                    multicastId);
        }
        return fcmResponse;
    }

    List<String> targetAsStringsList(Message message) {
        if (!message.getRegistrationIds().isEmpty()) {
            return message.getRegistrationIds();
        } else if (!message.to.isEmpty()) {
            return Collections.singletonList(message.to);
        }
        throw new IllegalStateException("can't find any valid target field in message.");
    }

    List<String> checkResults(List<Result> results, List<String> recipients,
            Map<String, Result> resultsState) {

        List<String> toRetry = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            Result result = results.get(i);
            String registrationId = recipients.get(i);
            resultsState.put(registrationId, result);
            if (!isNullOrEmpty(result.getError())) {
                if (RETRYABLE_ERRORS.containsKey(result.getError())) {
                    toRetry.add(registrationId);
                }
            }
        }
        return toRetry;
    }

    FcmHttpResponse buildResponseForMulticast(List<String> to, Map<String, Result> state,
            int multicastId) {
        FcmHttpResponse fcmHttpResponse = new FcmHttpResponse();
        fcmHttpResponse.setMulticastId(multicastId);

        List<Result> results = new ArrayList<>(to.size());
        fcmHttpResponse.setResults(results);

        for (String regId : to) {
            if (!state.containsKey(regId)) {
                continue;
            }
            Result result = state.get(regId);
            results.add(result);
            if (!isNullOrEmpty(result.getMessageId())) {
                fcmHttpResponse.incrementSuccess();
            } else if (!isNullOrEmpty(result.getError())) {
                fcmHttpResponse.incrementFailure();
            }
            if (!isNullOrEmpty(result.getRegistrationId())) {
                fcmHttpResponse.incrementCanonicalIds();
            }
        }
        return fcmHttpResponse;
    }
}
