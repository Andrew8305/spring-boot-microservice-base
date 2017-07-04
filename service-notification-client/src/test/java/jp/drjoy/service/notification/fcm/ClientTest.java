package jp.drjoy.service.notification.fcm;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static jp.drjoy.service.notification.fcm.Stubs.*;
import static jp.drjoy.service.notification.fcm.Stubs.EXPECTED_RESPONSE_BODY;
import static jp.drjoy.service.notification.fcm.Stubs.MULTICAST_REPLY;
import static jp.drjoy.service.notification.fcm.Stubs.MULTICAST_TOS;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClientTest {

    @Test
    public void testSend() throws Exception {
        // create the expect response
        ObjectMapper mapper = new ObjectMapper();
        FcmHttpResponse expectedResponse =
                mapper.readValue(EXPECTED_RESPONSE_BODY, FcmHttpResponse.class);

        // create a request message
        Message message = new Message.MessageBuilder()
                .setRegistrationIds(newArrayList(MULTICAST_TOS))
                .build();

        // invoke the test target with stub
        Client client = new Client(new StubHttpClient(),
                new Stubs.StubBackoffProvider());
        FcmHttpResponse response = client.send(message);

        // check test results
        assertThat(response, is(expectedResponse));
    }

    @Test
    public void testCheckResults() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        FcmHttpResponse fcmResponse =
                mapper.readValue(MULTICAST_REPLY.get(0), FcmHttpResponse.class);

        Map<String, Result> resultsState = newHashMap();

        Client client = new Client();
        List<String> retryIds =
                client.checkResults(fcmResponse.getResults(), MULTICAST_TOS,
                        resultsState);

        Map<String, Result> expectedResultState = newHashMap();
        expectedResultState.put("4", Result.ofMessageId("1:0408"));
        expectedResultState.put("8", Result.ofError("Unavailable"));
        expectedResultState.put("15", Result.ofError("InternalServerError"));
        expectedResultState.put("16", Result.ofMessageId("1:1517"));
        expectedResultState.put("23", new Result("1:2342", "32", null));
        expectedResultState.put("42", Result.ofError("NotRegistered"));

        assertThat(expectedResultState, is(resultsState));
        assertThat(retryIds.size(), is(2));
        assertThat(retryIds.get(0), is("8"));
        assertThat(retryIds.get(1), is("15"));
    }

    @Test
    public void testBuildResponseForMulticast() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        FcmHttpResponse expect =
                mapper.readValue(MULTICAST_REPLY.get(0), FcmHttpResponse.class);

        Map<String, Result> resultState = newHashMap();
        resultState.put("4", Result.ofMessageId("1:0408"));
        resultState.put("8", Result.ofError("Unavailable"));
        resultState.put("15", Result.ofError("InternalServerError"));
        resultState.put("16", Result.ofMessageId("1:1517"));
        resultState.put("23", new Result("1:2342", "32", null));
        resultState.put("42", Result.ofError("NotRegistered"));

        Client client = new Client();
        FcmHttpResponse actual = client.buildResponseForMulticast(
                MULTICAST_TOS,
                resultState,
                216);
        assertThat(expect, is(actual));
    }

    @Test
    public void testTargetAsStringsList() throws Exception {
        Message message = new Message.MessageBuilder()
                .setTo("recipient")
                .build();
        Client client = new Client();
        List<String> targets = client.targetAsStringsList(message);
        assertThat(targets, is(newArrayList("recipient")));

        message = new Message.MessageBuilder()
                .setRegistrationIds(MULTICAST_TOS)
                .build();
        targets = client.targetAsStringsList(message);
        assertThat(targets, is(MULTICAST_TOS));
    }

}