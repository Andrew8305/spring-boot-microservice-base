package jp.drjoy.service.notification.fcm;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Stubs {

    static final List<String> MULTICAST_TOS =
            newArrayList("4", "8", "15", "16", "23", "42");

    static final List<String> MULTICAST_REPLY = newArrayList(
            "{ "
                    + "\"multicast_id\": 216,"
                    + "\"success\": 3,"
                    + "\"failure\": 3,"
                    + "\"canonical_ids\": 1,"
                    + "\"results\": ["
                    + "{ \"message_id\": \"1:0408\" },"
                    + "{ \"error\": \"Unavailable\" },"
                    + "{ \"error\": \"InternalServerError\" },"
                    + "{ \"message_id\": \"1:1517\" },"
                    + "{ \"message_id\": \"1:2342\", \"registration_id\": \"32\" },"
                    + "{ \"error\": \"NotRegistered\"}"
                    + "]}",
            "{ \"multicast_id\": 217,"
                    + "\"success\": 2,"
                    + "\"failure\": 0,"
                    + "\"canonical_ids\": 0,"
                    + "\"results\": ["
                    + "{ \"message_id\": \"1:0409\" },"
                    + "{ \"message_id\": \"1:1516\" }"
                    + "]}");

    static final String EXPECTED_RESPONSE_BODY = "{"
            + "\"multicast_id\": 217,"
            + "\"success\": 5,"
            + "\"failure\": 1,"
            + "\"canonical_ids\": 1,"
            + "\"results\": ["
            + "{ \"message_id\": \"1:0408\" },"
            + "{ \"message_id\": \"1:0409\" },"
            + "{ \"message_id\": \"1:1516\" },"
            + "{ \"message_id\": \"1:1517\" },"
            + "{ \"message_id\": \"1:2342\", \"registration_id\": \"32\" },"
            + "{ \"error\": \"NotRegistered\"} "
            + "]}";

    static class StubHttpClient implements FcmHttpClient {

        private int invocationNum;

        @Override public FcmHttpResponse send(Message message) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                FcmHttpResponse fcmHttpResponse =
                        mapper.readValue(MULTICAST_REPLY.get(invocationNum),
                                FcmHttpResponse.class);
                invocationNum++;
                return fcmHttpResponse;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class StubBackoffProvider implements BackoffProvider {

        @Override public boolean sendAnother() {
            return true;
        }

        @Override public void setMin(Duration min) {
        }

        @Override public void sleep() throws InterruptedException {
        }
    }


}
