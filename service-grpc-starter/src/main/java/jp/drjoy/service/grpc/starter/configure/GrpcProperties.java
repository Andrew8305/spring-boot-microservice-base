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

    public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	@Data
    public static class Server {

        /* server listen port */
        private int port = 50051;

        /* gPRC service */
        private Service service = new Service();

        public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}

		public Service getService() {
			return service;
		}

		public void setService(Service service) {
			this.service = service;
		}

		@Data
        public static class Service {

            /* service base package */
            private String basePackage;

			public String getBasePackage() {
				return basePackage;
			}

			public void setBasePackage(String basePackage) {
				this.basePackage = basePackage;
			}
            
        }
    }
}
