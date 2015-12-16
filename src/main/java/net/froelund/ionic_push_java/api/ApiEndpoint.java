package net.froelund.ionic_push_java.api;

import net.froelund.ionic_push_java.entities.PushMessage;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by froelund on 12/16/15.
 */
@Path("/api/v1")
public interface ApiEndpoint {
    @Path("/push")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response sendPush(PushMessage pushMessage, @HeaderParam("X-Ionic-Application-Id") String applicationId, @HeaderParam("Authorization") String authorization);
}
