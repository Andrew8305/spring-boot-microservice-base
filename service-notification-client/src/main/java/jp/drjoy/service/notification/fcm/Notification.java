package jp.drjoy.service.notification.fcm;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Notification specifies the predefined, user-visible key-value pairs of the notification payload.
 */
public class Notification {

    /** The notification's title. */
    @JsonProperty("title") public final String title;

    /** The notification"s body text. */
    @JsonProperty("body") public final String body;

    /** The notification's icon. */
    @JsonProperty("icon") public final String icon;

    /** The sound to play when the device receives the notification. */
    @JsonProperty("sound") public final String sound;

    /** The value of the badge on the home screen app icon. If set to 0, the badge is removed. */
    @JsonProperty("badge") public final String badge;

    /** Identifier used to replace existing notifications in the notification drawer. */
    @JsonProperty("tag") public final String tag;

    /** The notification's icon color, expressed in #rrggbb format. */
    @JsonProperty("color") public final String color;

    /** The action associated with a user click on the notification. */
    @JsonProperty("click_action") public final String clickAction;

    /** */
    @JsonProperty("body_loc_key") public final String bodyLocKey;

    /** */
    @JsonProperty("body_loc_args") public final List<String> bodyLocArgs;

    /** */
    @JsonProperty("title_loc_key") public final String titleLocKdy;

    /** */
    @JsonProperty("title_loc_args") public final List<String> titleLocArgs;

    public static class NotificationBuilder {

        private String title;
        private String body;
        private String icon;
        private String sound;
        private String badge;
        private String tag;
        private String color;
        private String clickAction;
        private String bodyLocKey;
        private List<String> bodyLocArgs;
        private String titleLocKdy;
        private List<String> titleLocArgs;

        public NotificationBuilder() {
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void setSound(String sound) {
            this.sound = sound;
        }

        public void setBadge(String badge) {
            this.badge = badge;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setClickAction(String clickAction) {
            this.clickAction = clickAction;
        }

        public void setBodyLocKey(String bodyLocKey) {
            this.bodyLocKey = bodyLocKey;
        }

        public void setBodyLocArgs(List<String> bodyLocArgs) {
            this.bodyLocArgs = bodyLocArgs;
        }

        public void setTitleLocKdy(String titleLocKdy) {
            this.titleLocKdy = titleLocKdy;
        }

        public void setTitleLocArgs(List<String> titleLocArgs) {
            this.titleLocArgs = titleLocArgs;
        }

        public Notification build() {
            return new Notification(title,
                    body,
                    icon,
                    sound,
                    badge,
                    tag,
                    color,
                    clickAction,
                    bodyLocKey,
                    bodyLocArgs,
                    titleLocKdy,
                    titleLocArgs);
        }
    }

    private Notification(
            String title,
            String body,
            String icon,
            String sound,
            String badge,
            String tag,
            String color,
            String clickAction,
            String bodyLocKey,
            List<String> bodyLocArgs,
            String titleLocKdy,
            List<String> titleLocArgs) {
        this.title = title;
        this.body = body;
        this.icon = icon;
        this.sound = sound;
        this.badge = badge;
        this.tag = tag;
        this.color = color;
        this.clickAction = clickAction;
        this.bodyLocKey = bodyLocKey;
        this.bodyLocArgs = bodyLocArgs;
        this.titleLocKdy = titleLocKdy;

        this.titleLocArgs = titleLocArgs;
    }

}
