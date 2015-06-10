package fr.lamphi.api.user;

import java.util.List;

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

import fr.lamphi.api.App;
import fr.lamphi.api.MD5Util;

@Path("/userdb")
@Produces(MediaType.APPLICATION_JSON)
public class UserDBResource {
	private static UserDao dao = App.dbi.open(UserDao.class);
	public UserDBResource () {
		try {
			dao.createUserTable();
			dao.insert("DOE", "John", "john.doe@gmail.com", "johndoe", MD5Util.md5Hex("johndoe"), "hom", "etu");
			dao.insert("DUPONT", "Jean", "jean.dupont@gmail.com", "jeandupont", MD5Util.md5Hex("jeandupont"), "hom", "ens");
		}
		catch (Exception e) {
		}
	}
	
	@POST
	public User createUser(User user) {
		user.setPassword(MD5Util.md5Hex(user.getPassword()));
		int id = dao.insert(user.getName(), user.getSurname(), user.getEmail(), user.getPseudo(), user.getPassword(), user.getSex(), user.getStatus());
		user.setId(id);
		return user;
	}
	
	@PUT
	public User updateUser(User user) {
		user.setPassword(MD5Util.md5Hex(user.getPassword()));
		dao.update(user.getName(), user.getSurname(), user.getEmail(), user.getPseudo(), user.getPassword(), user.getSex(), user.getStatus());
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
	@Path("/{username}/{password}")
	public User getUser(@PathParam("username") String username, @PathParam("password") String password) throws WebApplicationException {
		password = MD5Util.md5Hex(password);
		User out = dao.findByLoginPassword(username, password);
		if (out == null) {
			throw new WebApplicationException(300);
		}
		return out;
	}

	@GET
	public List<User> getUsers(@DefaultValue("10") @QueryParam("limit") int limit) {
		return dao.getUsers(limit);
	}
}
