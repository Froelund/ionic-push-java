package net.froelund.ionic_push_java;

import net.froelund.ionic_push_java.api.ApiEndpoint;
import net.froelund.ionic_push_java.entities.PushMessage;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.core.Response;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for sending messages to Ionic Push.
 *
 */
public class PushSender {

    Logger logger = Logger.getLogger(PushSender.class.getName());

    final ResteasyClient client = new ResteasyClientBuilder().build();

    String ionicApplicationId;
    String privateApiKey;
    String ionicPushApiUrl;


    /**
     *
     * Basic constructor for initiating the PushSender.
     *
     * @param ionicApplicationId Can be found by navigating to: https://apps.ionic.io/apps
     * @param privateApiKey Can be found by navigating to: https://apps.ionic.io/app/<ionicApplicationId></>/config/keys
     */
    public PushSender(String ionicApplicationId, String privateApiKey) {
        this(ionicApplicationId, privateApiKey, "https://push.ionic.io/");
    }

    public PushSender(String ionicApplicationId, String privateApiKey, String ionicPushApiUrl) {
        this.ionicApplicationId = ionicApplicationId;
        this.privateApiKey = privateApiKey;
        this.ionicPushApiUrl = ionicPushApiUrl;
    }

    /**
     *
     * Sends a push message.
     *
     * @param pushMessage
     * @return The Http response returned by the Ionic Push.
     */
    public Response sendPush(PushMessage pushMessage){
        ResteasyWebTarget ionicPushApiTarget = client.target(ionicPushApiUrl);

        ApiEndpoint ionicApiEndpointProxy = ionicPushApiTarget.proxy(ApiEndpoint.class);
        return ionicApiEndpointProxy.sendPush(pushMessage, ionicApplicationId, generateAuthorizationHeader(privateApiKey));
    }

    private String generateAuthorizationHeader(String privateApiKey) {
        String authorizationHeader = "Basic: " + Base64.getEncoder().encodeToString(privateApiKey.getBytes());
        return authorizationHeader;
    }

}

