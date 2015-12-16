package net.froelund.ionic_push_java.entities;

import net.froelund.ionic_push_java.entities.Notification;
import net.froelund.ionic_push_java.entities.PushMessage;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by froelund on 12/16/15.
 */
public class PushMessageTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testSimplePushMessageWithUserIdsMapping() throws Exception {
        PushMessage pushMessage = new PushMessage();
        Notification notification = new Notification();

        notification.setAlert("Just testing!");

        pushMessage.setUserIds(new String[]{"TestUserOne"});
        pushMessage.setNotification(notification);

        String pushMessageJson = objectMapper.writeValueAsString(pushMessage);
        Assert.assertEquals("Mapping push message with user_ids wasn't correct", "{\"user_ids\":[\"TestUserOne\"],\"notification\":{\"alert\":\"Just testing!\"}}", pushMessageJson);
    }

    @Test
    public void testSimplePushMessageWithTokensMapping() throws Exception{
        PushMessage pushMessage = new PushMessage();
        Notification notification = new Notification();
        notification.setAlert("Just testing!");

        pushMessage.setNotification(notification);
        pushMessage.setTokens(new String[]{"WHAT-TOKEN-HUH?"});

        String pushMessageJson = objectMapper.writeValueAsString(pushMessage);
        Assert.assertEquals("Mapping push message with tokens wasn't correct", "{\"tokens\":[\"WHAT-TOKEN-HUH?\"],\"notification\":{\"alert\":\"Just testing!\"}}", pushMessageJson);
    }
}