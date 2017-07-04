package jp.drjoy.service.notification.fcm;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Result represents the status of a processed message.
 */
public class Result {

    @JsonProperty("message_id") private String messageId;
    @JsonProperty("registration_id") private String registrationId;
    @JsonProperty("error") private String error;

    /**
     * Constructs a new fcm result.
     */
    public Result() {
    }

    public Result(String messageId, String registrationId, String error) {
        this.messageId = messageId;
        this.registrationId = registrationId;
        this.error = error;
    }

    /**
     * Returns the message id.
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets the message id.
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * Returns the registration id.
     */
    public String getRegistrationId() {
        return registrationId;
    }

    /**
     * Sets the registration id.
     */
    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    /**
     * Returns the error.
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the error.
     */
    public void setError(String error) {
        this.error = error;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return java.util.Objects.equals(messageId, result.messageId)
                &&
                java.util.Objects.equals(registrationId, result.registrationId)
                &&
                java.util.Objects.equals(error, result.error);
    }

    @Override public int hashCode() {
        return java.util.Objects.hash(messageId, registrationId, error);
    }

    @Override public String toString() {
        return "Result{" +
                "messageId='" + messageId + '\'' +
                ", registrationId='" + registrationId + '\'' +
                ", error='" + error + '\'' +
                '}';
    }


    static Result ofMessageId(String messageId) {
        return new Result(messageId, null, null);
    }

    static Result ofRegistractionId(String registrationId) {
        return new Result(null, registrationId, null);
    }

    static Result ofError(String error) {
        return new Result(null, null, error);
    }

}
