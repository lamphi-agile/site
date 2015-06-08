package fr.lamphi.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	private static Map<Integer, User> users = new HashMap<>();
	
	@POST
	public User createUser(User user) {
		int id = users.size();
		user.setId(id+1);
		users.put(user.getId(), user);
		return user;
	}
	
	static{
		User user= new User(1, "CHAVAL", "Clément", "etu", "cchaval", "clement.chaval@free.fr", "proutprout", "M");
		User user2= new User(2, "CLAVIER", "Thomas", "prof", "tclavier", "thomas.clavier@univ-lille1.fr", "proutprout", "M");
		users.put(1, user);
		users.put(2, user2);
	}
	
	
	@DELETE
	@Path("{id}")
	public Response deleteUser(@PathParam("id") Integer id) {
		if (users.containsKey(id)) {
			return Response.accepted().status(Status.ACCEPTED).build();
		}
	    return Response.accepted().status(Status.NOT_FOUND).build();
	}
	
	protected User find(int id) {
		return users.get(id);
	}
	
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
	public Response updateUser(@PathParam("id") int id, 
			User user) {
		User oldUser = find(id);
		System.out.println("Should update user with id: "+id
				+" ("+oldUser+") to " +user);
		if (user == null) {
			throw new WebApplicationException(404);
		}
		oldUser.setName(user.getName());
		return Response.status(200).entity(oldUser).build();
	}

	@GET
	@Path("/{id}")
	public User getUser(@PathParam("id") int id ) {
		User out = find(id);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
	
	@GET
	public List<User> getUsers(@DefaultValue("10") @QueryParam("limit") int limit) {
		return new ArrayList<User>(users.values());
	}

}
