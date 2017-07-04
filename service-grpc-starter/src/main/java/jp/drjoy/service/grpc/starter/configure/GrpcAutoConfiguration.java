package jp.drjoy.service.grpc.starter.configure;

import jp.drjoy.service.grpc.starter.EnableGrpcServer;
import jp.drjoy.service.grpc.starter.runner.GrpcServerRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * Created by k.sumi on 6/13/2017.
 */
@Configuration
@EnableConfigurationProperties(GrpcProperties.class)
@AutoConfigureOrder
public class GrpcAutoConfiguration {

    private GrpcProperties grpcProperties;

    @Autowired
    public GrpcAutoConfiguration(GrpcProperties grpcProperties) {
        this.grpcProperties = grpcProperties;
    }

    @Bean
    @ConditionalOnBean(annotation = EnableGrpcServer.class)
    public GrpcServerRunner grpcServerRunner() {
        return new GrpcServerRunner(grpcProperties);
    }
}
