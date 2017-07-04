package jp.drjoy.service.grpc.starter.runner;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import jp.drjoy.service.grpc.starter.GrpcService;
import jp.drjoy.service.grpc.starter.configure.GrpcProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.util.StringUtils;

/**
 * gRPC server runner.
 *
 * Created by k.sumi on 6/13/2017.
 */
public class GrpcServerRunner implements CommandLineRunner, InitializingBean, DisposableBean {

    /* Logger */
    private static final Logger logger = LoggerFactory.getLogger(GrpcServerRunner.class);


    // Instance variables
    // ---------------------------------------------------------------------------------------------
    /* gRPC server */
    private Server server;
    /* gRPC properties */
    private final GrpcProperties grpcProperties;


    // Constractor
    // ---------------------------------------------------------------------------------------------
    public GrpcServerRunner(GrpcProperties grpcProperties) {
        this.grpcProperties = grpcProperties;
    }


    // Overrided initializingBean
    // ---------------------------------------------------------------------------------------------
    @Override public void afterPropertiesSet() throws Exception {
        // check service `base-package`
        if (StringUtils.isEmpty(grpcProperties.getServer().getService().getBasePackage())) {
            throw new NullPointerException("*** gRPC `base-package` property is null");
        }
    }


    // Overrided CommandLineRunner
    // ---------------------------------------------------------------------------------------------
    @Override public void run(String... strings) throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info("*** gRPC server starting...");
        }
        ServerBuilder builder = ServerBuilder.forPort(grpcProperties.getServer().getPort());
        Set<Class<BindableService>> services = scanGrpcService(builder);

        if (services.isEmpty()) {
            logger.warn("*** gPRC resigted service is empty");
        }

        server = builder.build().start();

        if (logger.isInfoEnabled()) {
            logger.info("*** gRPC server started, listening on {}", server.getPort());
        }
        startDaemonAwaitThread();
    }

    private Set<Class<BindableService>> scanGrpcService(ServerBuilder builder) {
        ClassPathScanningCandidateComponentProvider provider =
                new ClassPathScanningCandidateComponentProvider(false);

        provider.addIncludeFilter(new AnnotationTypeFilter(GrpcService.class));
        provider.addIncludeFilter(new AssignableTypeFilter(BindableService.class));

        String basePackage = grpcProperties.getServer().getService().getBasePackage();

        Set<Class<BindableService>> classes = provider.findCandidateComponents(basePackage)
                .stream()
                .map(BeanDefinition::getBeanClassName)
                .map(className -> {
                    @SuppressWarnings("all")
                    final Class<BindableService> cls = loadClass(className);
                    return cls;
                })
                .collect(Collectors.toSet());

        classes.forEach(cls -> {
            try {
                builder.addService(cls.newInstance());

                if (logger.isInfoEnabled()) {
                    logger.info("*** gRPC added service={}", cls.getName());
                }
            } catch (IllegalAccessException | InstantiationException ex) {
                logger.error("*** {}", ex.getMessage());
            }
        });
        return classes;
    }

    @SuppressWarnings("unchecked")
    private static <T> Class<T> loadClass(String className) {
        try {
            return (Class<T>) Class.forName(className);
        } catch (ClassNotFoundException ex) {
            logger.error("*** {}", ex.getMessage());
            // todo:k.sumi これだめ
            throw new RuntimeException(ex);
        }
    }

    private void startDaemonAwaitThread() {
        Thread awaitThread = new Thread(() -> {
            try {
                GrpcServerRunner.this.server.awaitTermination();
            } catch (InterruptedException ex) {
                logger.error("*** gRPC server stopped {}", ex);
                // todo:k.sumi これではだめ
            }
        });
        awaitThread.setDaemon(false);
        awaitThread.start();
    }


    // Overrided DisposableBean
    // ---------------------------------------------------------------------------------------------
    @Override public void destroy() throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info("*** gRPC server shutting down ...");
        }
        // server shut down
        Optional.ofNullable(server).ifPresent(Server::shutdown);

        if (logger.isInfoEnabled()) {
            logger.info("*** gRPC server shut down");
        }
    }
}
