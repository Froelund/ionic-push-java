package net.froelund.ionic_push_java.entities;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created by froelund on 12/16/15.
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
