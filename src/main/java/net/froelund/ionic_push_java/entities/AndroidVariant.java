package net.froelund.ionic_push_java.entities;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Map;

/**
 * Created by froelund on 12/16/15.
 */
@JsonPropertyOrder({
        "collapseKey",
        "delayWhileIdle",
        "timeToLive",
        "payload"
})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class AndroidVariant {
    String collapseKey;
    Boolean delayWhileIdle;
    Integer timeToLive;
    Map<String, Object> payload;

    public String getCollapseKey() {
        return collapseKey;
    }

    public void setCollapseKey(String collapseKey) {
        this.collapseKey = collapseKey;
    }

    public Boolean getDelayWhileIdle() {
        return delayWhileIdle;
    }

    public void setDelayWhileIdle(Boolean delayWhileIdle) {
        this.delayWhileIdle = delayWhileIdle;
    }

    public Integer getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(Integer timeToLive) {
        this.timeToLive = timeToLive;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, Object> payload) {
        this.payload = payload;
    }
}
