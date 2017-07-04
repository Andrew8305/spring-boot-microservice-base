package jp.drjoy.service.grpc.starter.configure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * Created by k.sumi on 6/13/2017.
 */
@Component
@ConfigurationProperties(prefix = "grpc")
@Data
public class GrpcProperties {

    /* server properties */
    private Server server = new Server();

    @Data
    public static class Server {

        /* server listen port */
        private int port = 50051;

        /* gPRC service */
        private Service service = new Service();

        @Data
        public static class Service {

            /* service base package */
            private String basePackage;
        }
    }
}
