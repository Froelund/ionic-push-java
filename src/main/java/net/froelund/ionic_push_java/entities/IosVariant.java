package net.froelund.ionic_push_java.entities;

import net.froelund.ionic_push_java.utils.EpochDateFormat;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonFilter;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.util.StdDateFormat;

import java.util.Date;
import java.util.Map;

/**
 * Created by froelund on 12/16/15.
 */
@JsonPropertyOrder({
        "badge",
        "sound",
        "expiry",
        "priority",
        "contentAvailable",
        "payload"
        })
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class IosVariant {

    Integer badge;
    String sound;
    @JsonSerialize(using = EpochDateFormat.class, include = JsonSerialize.Inclusion.NON_NULL)
    Date expiry;
    Integer priority;
    Integer contentAvailable;
    Map<String, Object> payload;

    public Integer getBadge() {
        return badge;
    }

    public void setBadge(Integer badge) {
        this.badge = badge;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getContentAvailable() {
        return contentAvailable;
    }

    public void setContentAvailable(Integer contentAvailable) {
        this.contentAvailable = contentAvailable;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, Object> payload) {
        this.payload = payload;
    }
}
