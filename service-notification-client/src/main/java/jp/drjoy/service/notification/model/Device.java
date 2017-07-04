package jp.drjoy.service.notification.model;

import java.util.Objects;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "device")
public class Device {

    @Id private String id;

    @Field("app_id") private String appId;
    @Field("account_id") private String accountId;
    @JsonProperty("token") @Field("token") private String token;
    @Field("platform") private Platform platform;
    @Field("version") private String version;
    @Field("model") private String model;
    @Field("app_version") private String appVersion;

    public Device() {
    }

    public Device(String appId,
            String accountId,
            String token,
            Platform platform,
            String version,
            String model,
            String appVersion
    ) {
        this.appId = appId;
        this.accountId = accountId;
        this.token = token;
        this.platform = platform;
        this.version = version;
        this.model = model;
        this.appVersion = appVersion;
    }

    public String getAppId() {
        return appId;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getToken() {
        return token;
    }

    public Platform getPlatform() {
        return platform;
    }

    public String getVersion() {
        return version;
    }

    public String getModel() {
        return model;
    }

    public String getAppVersion() {
        return appVersion;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(appId, device.appId) &&
                Objects.equals(accountId, device.accountId) &&
                Objects.equals(token, device.token) &&
                platform == device.platform &&
                Objects.equals(version, device.version) &&
                Objects.equals(model, device.model) &&
                Objects.equals(appVersion, device.appVersion);
    }

    @Override public int hashCode() {
        return Objects.hash(appId, accountId, token, platform, version, model,
                appVersion);
    }

    @Override public String toString() {
        return "Device{" +
                "id='" + id + '\'' +
                ", appId='" + appId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", token='" + token + '\'' +
                ", platform=" + platform +
                ", version='" + version + '\'' +
                ", model='" + model + '\'' +
                ", appVersion='" + appVersion + '\'' +
                '}';
    }
}
