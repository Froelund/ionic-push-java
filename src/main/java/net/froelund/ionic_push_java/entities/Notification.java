package net.froelund.ionic_push_java.entities;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created by froelund on 12/16/15.
 */
@JsonPropertyOrder({
        "alert",
        "ios",
        "android"
})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Notification {
    @JsonProperty("alert")
    String alert;
    @JsonProperty("ios")
    IosVariant iosVariant;
    @JsonProperty("android")
    AndroidVariant androidVariant;

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public IosVariant getIosVariant() {
        return iosVariant;
    }

    public void setIosVariant(IosVariant iosVariant) {
        this.iosVariant = iosVariant;
    }

    public AndroidVariant getAndroidVariant() {
        return androidVariant;
    }

    public void setAndroidVariant(AndroidVariant androidVariant) {
        this.androidVariant = androidVariant;
    }
}

