package net.froelund.ionic_push_java.entities;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by froelund on 12/16/15.
 */
public class NotificationTest {
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testSimpleNotificationMapping() throws Exception{
        Notification notification = new Notification();
        notification.setAlert("Just a message to everyone!");
        String notificationJsonString = objectMapper.writeValueAsString(notification);
        Assert.assertEquals("Simple notification wasn't correct mapped", "{\"alert\":\"Just a message to everyone!\"}", notificationJsonString);
    }

    @Test
    public void testNotificationWithCustomIOS() throws Exception{
        Notification notification = new Notification();
        IosVariant iosVariant = new IosVariant();

        iosVariant.setBadge(5);
        iosVariant.setExpiry(new Date(590400000000L));
        iosVariant.setPriority(10);
        iosVariant.setContentAvailable(0);
        notification.setAlert("Just a message, with custom IOS conf.!");
        notification.setIosVariant(iosVariant);

        String notificationJsonString = objectMapper.writeValueAsString(notification);
        Assert.assertEquals("Notification with custom IOS wasn't correctly mapped", "{\"alert\":\"Just a message, with custom IOS conf.!\",\"ios\":{\"badge\":5,\"expiry\":590400000,\"priority\":10,\"contentAvailable\":0}}", notificationJsonString);
    }

    @Test
    public void testNotificationWithCustomAndroid() throws Exception {
        AndroidVariant androidVariant = new AndroidVariant();
        Notification notification = new Notification();

        androidVariant.setCollapseKey("So collaps");
        androidVariant.setTimeToLive(3000);

        notification.setAlert("Just a message, with custom Android conf.!");
        notification.setAndroidVariant(androidVariant);
        String notificationJsonString = objectMapper.writeValueAsString(notification);
        Assert.assertEquals("Notification with custom ANDROID wasn't correct mapped", "{\"alert\":\"Just a message, with custom Android conf.!\",\"android\":{\"collapseKey\":\"So collaps\",\"timeToLive\":3000}}", notificationJsonString);
    }

    @Test
    public void testNotificationWithCustomConfigurations() throws Exception{
        Notification notification = new Notification();

        IosVariant iosVariant = new IosVariant();
        AndroidVariant androidVariant = new AndroidVariant();

        iosVariant.setPriority(1);
        androidVariant.setTimeToLive(300);

        notification.setIosVariant(iosVariant);
        notification.setAndroidVariant(androidVariant);

        String notificationAsJsonString = objectMapper.writeValueAsString(notification);

        Assert.assertEquals("Advanced custom json mapping wasn't correct.", "{\"ios\":{\"priority\":1},\"android\":{\"timeToLive\":300}}", notificationAsJsonString);

    }
}