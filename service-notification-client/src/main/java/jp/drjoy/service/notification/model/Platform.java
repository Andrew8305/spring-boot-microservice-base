package jp.drjoy.service.notification.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import java.util.Objects;

public enum Platform {

    iOS("ios"), Android("android"), Web("web");

    private final String identifier;

    Platform(String identifier) {
        this.identifier = identifier;
    }

    @JsonCreator
    public static Platform of(String s) {
        return Arrays.stream(values())
                .filter(v -> Objects.equals(v.identifier, s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Specified value is not supported. value [" + s + "]"));
    }

    @JsonValue()
    public String getIdentifier() {
        return identifier;
    }

}

