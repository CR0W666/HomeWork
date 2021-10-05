package cz.educanet.webik;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;

@Path("auth")
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    private AuthManager authManager;

    @GET
    public Response getLoggedUser() {

        if (authManager.userState())
            return Response.ok(authManager.getLoggedUser()).build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();

    }

    @DELETE
    public Response logout() {
        authManager.logout();

        if (!authManager.userState())
            return Response.ok("logged out").build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();

    }

    @POST
    public Response login(User user) {
        authManager.login(user);

        if (authManager.userState())
            return Response.ok(authManager.getLoggedUser()).build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }



}