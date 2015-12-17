package net.froelund.ionic_push_java.entities;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * A push message entity.
 *
 * Simple example:
 *
 * Will send a message to the Ionic users user:1, user:2, user:3.
 * <pre>
 * {@code
 * PushMessage pushMessage = new PushMessage();
 * pushMessage.setUserIds(new String[]{"user:1", "user:2", "user:3"});
 * Notification notification = new Notification();
 * notification.setAlert("Just testing!");
 * pushMessage.setNotification(notification);
 * //Send the pushMessage with PushSender
 * }
 * </pre>
 *
 */
@JsonPropertyOrder({
        "user_ids",
        "tokens",
        "notification"
})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PushMessage {

    @JsonProperty("user_ids")
    String[] userIds;
    @JsonProperty("tokens")
    String[] tokens;
    @JsonProperty("notification")
    Notification notification;

    public PushMessage() {
    }

    public String[] getUserIds() {
        return userIds;
    }

    public void setUserIds(String[] userIds) {
        this.userIds = userIds;
    }

    public String[] getTokens() {
        return tokens;
    }

    public void setTokens(String[] tokens) {
        this.tokens = tokens;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}
