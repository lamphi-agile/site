package fr.lamphi.api;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

@Path("/userdb")
@Produces(MediaType.APPLICATION_JSON)
public class UserDBResource {
	private static UserDao dao = App.dbi.open(UserDao.class);
	public UserDBResource () {
		try {
			dao.createUserTable();
		}
		catch (Exception e) {
			System.out.println("La table existe déjà !");
		}
	}
	
	@POST
	public User createUser(User user) {
		int id = dao.insert(user.getName(), user.getSurname(), user.getEmail(), user.getPseudo(), user.getPassword(), user.getSex(), user.getStatus());
		user.setId(id);
		return user;
	}

	@GET
	@Path("/{id}")
	public User getUser(@PathParam("id") int id) {
		User out = dao.findById(id);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}

	@GET
	public List<User> getUsers(@DefaultValue("10") @QueryParam("limit") int limit) {
		return dao.getUsers(limit);
	}
}
