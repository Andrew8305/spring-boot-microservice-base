package jp.drjoy.service.notification.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class RegistrationRequest implements Serializable {

    private String appId;
    private String accountId;
    private Platform platform;
    private String token;

    public RegistrationRequest() {
    }

    public RegistrationRequest(
            final String appId,
            final String accountId,
            final Platform platform,
            final String token) {
        this.appId = appId;
        this.accountId = accountId;
        this.platform = platform;
        this.token = token;
    }

    @JsonProperty("app_id") public String getAppId() {
        return appId;
    }

    @JsonProperty("account_id") public String getAccountId() {
        return accountId;
    }

    @JsonProperty("platform") public Platform getPlatform() {
        return platform;
    }

    @JsonProperty("token") public String getToken() {
        return token;
    }


    @Override public String toString() {
        return "RegistrationRequest{" +
                "appId='" + appId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", platform=" + platform +
                ", token='" + token + '\'' +
                '}';
    }
}
