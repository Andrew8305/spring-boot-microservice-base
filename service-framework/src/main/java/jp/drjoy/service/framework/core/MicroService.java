package jp.drjoy.service.framework.core;

import lombok.Getter;

/**
 *
 * Created by k.sumi on 6/21/2017.
 */
public enum MicroService {

    /**
     * Group service.
     */
    GROUP("group"),

    /**
     * Chat service.
     */
    CHAT("chat")
    ;

    /* Micro service id */
    @Getter
    private String serviceId;

    /**
     * Constractor.
     *
     * @param serviceId Micro service id
     */
    MicroService(String serviceId) {
        this.serviceId = serviceId;
    }
}
