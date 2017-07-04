package jp.drjoy.service.notification.fcm;

public interface FcmHttpClient {

    FcmHttpResponse send(Message message);

}

