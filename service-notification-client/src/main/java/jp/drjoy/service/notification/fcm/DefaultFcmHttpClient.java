package jp.drjoy.service.notification.fcm;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;

public class DefaultFcmHttpClient implements FcmHttpClient {

    private static final MediaType MEDIA_TYPE_JSON =
            MediaType.parse("application/json; charset=utf-8");

    private static final String DEFAULT_ENDPOINT =
            "https://fcm.googleapis.com/fcm/send";

    private static final String DEFAULT_API_KEY =
            "AAAAe9GmvdI:APA91bF81ezcDCsY458S0KfrHvBwnlVYSAhg99eNwRp8Gf3yz_9-P4jaJHJ9Uev4qLSkMLfv_JzBvV9mdbBojx6g-mhtnrR7YMGzN8Jcb1eJ3-BtxNHERPO0nk3JZ9QYm8BAA2BJ46_o";

    private final String endpoint;
    private final String apiKey;

    DefaultFcmHttpClient() {
        this(DEFAULT_ENDPOINT, DEFAULT_API_KEY);
    }

    DefaultFcmHttpClient(String endpoint, String apiKey) {
        checkArgument(!isNullOrEmpty(endpoint));
        checkArgument(!isNullOrEmpty(apiKey));

        this.endpoint = endpoint;
        this.apiKey = apiKey;
    }

    @Override public FcmHttpResponse send(Message message) {
        checkNotNull(message);
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(message);

            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, json);
            Request request = new Request.Builder()
                    .addHeader("Authorization", String.format("key=%s", apiKey))
                    .url(endpoint)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();

            FcmHttpResponse fcmResponse = null;
            if (responseBody != null) {
                fcmResponse = mapper.readValue(responseBody.string(),
                        FcmHttpResponse.class);
                fcmResponse.setRetryAfter(response.header("Retry-After"));
            }
            return fcmResponse;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
