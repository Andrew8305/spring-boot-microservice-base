package jp.drjoy.service.grpc.starter.example;

import jp.drjoy.service.grpc.starter.EnableGrpcServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 *
 * Created by k.sumi on 6/14/2017.
 */
@SpringBootApplication
@EnableGrpcServer
@EnableHystrix
public class GrpcStarterExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrpcStarterExampleApplication.class, args);
    }
}
