package jp.drjoy.service.notification.fcm;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static org.apache.commons.lang3.StringUtils.countMatches;

/**
 * Message represents list of targets, options, and payload for HTTP JSON messages.
 */
public class Message {

    /**
     * Priority of the message.
     */
    public enum Priority {

        /**
         * This is default priority for data messages.
         * This priority is analogous to APNs priority levels 5.
         */
        @JsonProperty("normal")Normal(),

        /**
         * This is default priority for notification messages.
         * This priority is analogous to APNs priority levels 10.
         */
        @JsonProperty("high")High(),
    }

    public static class MessageBuilder {

        public static final int TIME_TO_LIVE_MIN_VALUE = 0;
        public static final int TIME_TO_LIVE_MAX_VALUE = 2419200;
        public static final int MAX_REGISTRATION_IDS_COUNT = 1000;
        private String to;
        private List<String> registrationIds;
        private String condition;
        private String collapseKey;
        private Priority priority;
        private boolean contentAvailable;
        private boolean mutableContent;
        private int timeToLive;
        private String restrictedPackageName;
        private boolean dryRun;
        private Map<String, Object> data;
        private Notification notification;

        public MessageBuilder() {
        }

        public MessageBuilder setTo(String to) {
            this.to = to;
            return this;
        }

        public MessageBuilder setRegistrationIds(List<String> registrationIds) {
            this.registrationIds = registrationIds;
            return this;
        }

        public MessageBuilder setCondition(String condition) {
            this.condition = condition;
            return this;
        }

        public MessageBuilder setCollapseKey(String collapseKey) {
            this.collapseKey = collapseKey;
            return this;
        }

        public MessageBuilder setPriority(Priority priority) {
            this.priority = priority;
            return this;
        }

        public MessageBuilder setContentAvailable(boolean contentAvailable) {
            this.contentAvailable = contentAvailable;
            return this;
        }

        public MessageBuilder setMutableContent(boolean mutableContent) {
            this.mutableContent = mutableContent;
            return this;
        }

        public MessageBuilder setTimeToLive(int timeToLive) {
            this.timeToLive = timeToLive;
            return this;
        }

        public MessageBuilder setRestrictedPackageName(String restrictedPackageName) {
            this.restrictedPackageName = restrictedPackageName;
            return this;
        }

        public MessageBuilder setDryRun(boolean dryRun) {
            this.dryRun = dryRun;
            return this;
        }

        public MessageBuilder setData(Map<String, Object> data) {
            this.data = data;
            return this;
        }

        public MessageBuilder setNotification(Notification notification) {
            this.notification = notification;
            return this;
        }

        public Message build() {
            validate();

            return new Message(to,
                    registrationIds != null ? registrationIds : emptyList(),
                    condition,
                    collapseKey,
                    priority,
                    contentAvailable,
                    mutableContent,
                    timeToLive,
                    restrictedPackageName,
                    dryRun,
                    data != null ? data : emptyMap(),
                    notification);
        }

        private void validate() {
            int operatorCount = countMatches(condition, "&&")
                    + countMatches(condition, "||");
            if (isNullOrEmpty(to)
                    && (isNullOrEmpty(condition) || operatorCount > 2)
                    && (registrationIds == null || registrationIds.size() == 0)) {
                throw new IllegalStateException("Topic is invalid or registration ids are not set");
            }

            // The registration_ids array must contain at least 1 and at most 1000.
            if (registrationIds != null && registrationIds.size() > MAX_REGISTRATION_IDS_COUNT) {
                throw new IllegalStateException("too many registrations ids");
            }

            // time_to_live parameter must be a duration from 0 to 2419200 seconds(4 weeks).
            if (TIME_TO_LIVE_MIN_VALUE < timeToLive || timeToLive > TIME_TO_LIVE_MAX_VALUE) {
                throw new IllegalStateException("time-to-live is invalid");
            }
        }
    }

    // TODO: javadoc
    /** The value can be a device's registration token */
    @JsonProperty("to") public final String to;
    @JsonProperty("registration_ids") private List<String> registrationIds;
    @JsonProperty("condition") public final String condition;
    @JsonProperty("collapse_key") public final String collapseKey;
    @JsonProperty("priority") public final Priority priority;
    @JsonProperty("content_available") public final boolean contentAvailable;
    @JsonProperty("mutable_content") public final boolean mutableContent;
    @JsonProperty("time_to_live") public final int timeToLive;
    @JsonProperty("restricted_package_name") public final String restrictedPackageName;
    @JsonProperty("dry_run") public final boolean dryRun;
    @JsonProperty("data") public final Map<String, Object> data;
    @JsonProperty("notification") public final Notification notification;

    public Message(String to,
            List<String> registrationIds,
            String condition,
            String collapseKey,
            Priority priority,
            boolean contentAvailable,
            boolean mutableContent,
            int timeToLive,
            String restrictedPackageName,
            boolean dryRun,
            Map<String, Object> data,
            Notification notification) {

        this.to = to;
        this.registrationIds = registrationIds;
        this.condition = condition;
        this.collapseKey = collapseKey;
        this.priority = priority;
        this.contentAvailable = contentAvailable;
        this.mutableContent = mutableContent;
        this.timeToLive = timeToLive;
        this.restrictedPackageName = restrictedPackageName;
        this.dryRun = dryRun;
        this.data = data;
        this.notification = notification;
    }

    public List<String> getRegistrationIds() {
        return registrationIds;
    }

    // TODO
    public void setRegistrationIds(List<String> registrationIds) {
        this.registrationIds = registrationIds;
    }
}
