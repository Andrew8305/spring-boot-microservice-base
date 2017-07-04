package jp.drjoy.service.notification.fcm;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * FcmHttpResponse represents the FCM server's response body(JSON).
 */
public class FcmHttpResponse {

    @JsonProperty("multicast_id") private int multicastId;
    @JsonProperty("success") private int success;
    @JsonProperty("failure") private int failure;
    @JsonProperty("canonical_ids") private int canonicalIds;
    @JsonProperty("results") private List<Result> results;

    // Topic message response properties
    @JsonProperty("message_id") private String messageId;
    @JsonProperty("error") private String error;

    private String retryAfter;

    /**
     * Constructs a new resopnse.
     */
    public FcmHttpResponse() {
    }

    /**
     * Returns the multicast id.
     */
    public int getMulticastId() {
        return multicastId;
    }

    /**
     * Sets the multicast id.
     */
    public void setMulticastId(int multicastId) {
        this.multicastId = multicastId;
    }

    /**
     * Returns the number of messages that were processed without an error.
     */
    public int getSuccess() {
        return success;
    }

    /**
     * Sets the number of messages that were processed without an error.
     */
    public void setSuccess(int success) {
        this.success = success;
    }

    /**
     * Returns the number of messages that could ot processed.
     */
    public int getFailure() {
        return failure;
    }

    /**
     * Sets the number of messages that could ot processed.
     */
    public void setFailure(int failure) {
        this.failure = failure;
    }

    /**
     * Returns the number of results that contain a canonical registration token.
     */
    public int getCanonicalIds() {
        return canonicalIds;
    }

    /**
     * Sets the number of results that contain a canonical registration token.
     */
    public void setCanonicalIds(int canonicalIds) {
        this.canonicalIds = canonicalIds;
    }

    /**
     * Returns the list of objects representing the status of the message processed.
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * Sets the list of objects representing the status of the message processed.
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

    /**
     * Returns the topic message id.
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets the topic message id.
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * Returns the error that occurred when processing the message.
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the error that occurred when processing the message.
     */
    public void setError(String error) {
        this.error = error;
    }

    String getRetryAfter() {
        return retryAfter;
    }

    void setRetryAfter(String retryAfter) {
        this.retryAfter = retryAfter;
    }

    public void incrementSuccess() {
        success++;
    }

    public void incrementFailure() {
        failure++;
    }

    public void incrementCanonicalIds() {
        canonicalIds++;
    }

    Duration durationOfRetryAfter() {
        Duration duration = Duration.ZERO;
        if (isNullOrEmpty(retryAfter)) {
            return duration;
        }
        try {
            duration = Duration.parse(retryAfter);
        } catch (DateTimeParseException e) {
            // does not throw exception,
            // catch DateTimeParseException to return default value
        }
        return duration;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FcmHttpResponse that = (FcmHttpResponse) o;
        return multicastId == that.multicastId &&
                success == that.success &&
                failure == that.failure &&
                canonicalIds == that.canonicalIds &&
                Objects.equals(results, that.results) &&
                Objects.equals(messageId, that.messageId) &&
                Objects.equals(error, that.error) &&
                Objects.equals(retryAfter, that.retryAfter);
    }

    @Override public int hashCode() {
        return Objects.hash(multicastId, success, failure, canonicalIds,
                results,
                messageId, error, retryAfter);
    }

    @Override public String toString() {
        return "FcmHttpResponse{" +
                "multicastId=" + multicastId +
                ", success=" + success +
                ", failure=" + failure +
                ", canonicalIds=" + canonicalIds +
                ", results=" + results +
                ", messageId='" + messageId + '\'' +
                ", error='" + error + '\'' +
                ", retryAfter='" + retryAfter + '\'' +
                '}';
    }
}


