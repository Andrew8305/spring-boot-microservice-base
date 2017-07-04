package jp.drjoy.service.grpc.starter.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.MetricsEndpoint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * Created by k.sumi on 6/14/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class GrpcStarterExampleApplicationTest {

    @Autowired
    private MetricsEndpoint metricsEndpoint;

    @Test
    public void existEndpoint() throws Exception {
        assertThat(metricsEndpoint).isNotNull();
    }
}
