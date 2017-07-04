package jp.drjoy.service.notification.fcm;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Test;

import static jp.drjoy.service.notification.fcm.Stubs.EXPECTED_RESPONSE_BODY;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DefaultFcmHttpClientTest {

    @Test
    public void send() throws Exception {
        try (final MockWebServer mockWebServer = new MockWebServer()) {
            // create a MockWebServer.
            String expectedRetryAfter = "10";
            MockResponse mockResponse = new MockResponse()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Retry-After", expectedRetryAfter)
                    .setResponseCode(200)
                    .setBody(EXPECTED_RESPONSE_BODY);
            mockWebServer.enqueue(mockResponse);
            mockWebServer.start();

            // create an expected response
            ObjectMapper mapper = new ObjectMapper();
            FcmHttpResponse expectResponse = mapper.readValue(EXPECTED_RESPONSE_BODY, FcmHttpResponse.class);
            expectResponse.setRetryAfter(expectedRetryAfter);

            // create a request message
            Message message = new Message.MessageBuilder()
                    .setTo("recipient").build();

            // invoke the test target on mock server
            String url = mockWebServer.url("/").toString();
            FcmHttpClient client = new DefaultFcmHttpClient(url, "apiKey");
            FcmHttpResponse response = client.send(message);

            // check the results
            assertThat(response, is(expectResponse));
            RecordedRequest request = mockWebServer.takeRequest();
            String expectAuthHeader = "key=apiKey";
            assertThat(request.getHeader("Authorization"), is(expectAuthHeader));
        }
    }
}