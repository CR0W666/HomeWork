package cz.educanet.webik;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    @Inject
    private UsersManager userManager;


    @GET
    public Response getAllUsernames() {
        return Response.ok(userManager.getAllUsernames()).build();
    }




    @GET
    @Path("{id}")
    public Response getUsername(@PathParam("id") int id) {
        return  Response.ok(userManager.getUsername(id)).build();
    }

    // @GET
    // @Path("{id}")
    // public Response getUserLevel(@PathParam("id") int id) {
    //     return  Response.ok(userManager.getUserLevel(id)).build();
    // }

    @POST
    public Response createUser(User user){
        
        if(!userManager.createUser(user))
            return Response.status(Response.Status.BAD_REQUEST).build();

        return Response.ok(user).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") int id) {
        if(userManager.removeUserName(id)){
            return Response.ok(Response.Status.GONE).build();
        } else { 
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
