package jp.drjoy.service.framework.grpc;

import io.grpc.ManagedChannel;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Service;

/**
 *
 * Created by k.sumi on 6/21/2017.
 */
@Service
public abstract class GrpcClientService implements DisposableBean {

    /* Channel */
    private ManagedChannel channel;

    /* host or ip address */
    private String hostOrIpAddr;

    /* port */
    private int port;

    /**
     * Constractor.
     *
     * @param hostOrIpAddr host or ip address
     * @param port port
     */
    public GrpcClientService(String hostOrIpAddr, int port) {
        this.hostOrIpAddr = hostOrIpAddr;
        this.port = port;
        // open channel
        newChannel();
    }

    /**
     * Return specified gRPC server channel.
     *
     * @return gRPC channel
     */
    protected ManagedChannel getChannel() {
        if (channel == null || channel.isShutdown() || channel.isTerminated()) {
            newChannel();
        }
        return channel;
    }

    /**
     * {@inheritDoc}
     */
    // Overrided Disposable Bean
    @Override public void destroy() throws Exception {
        // todo:k.sumi shut down channel
    }

    /**
     * Creating specified gRPC server channel.
     */
    private void newChannel() {
    }
}
