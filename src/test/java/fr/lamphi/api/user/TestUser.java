package fr.lamphi.api.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import fr.lamphi.api.App;

public class TestUser extends JerseyTest {
	
	@Override
	protected Application configure() {
		return new App();
	}

	@Test
	public void testReadUserWithNameFooAsJsonString() {
		User newUser = createUser("foo");
		String json = target("/userdb/"+ newUser.getId()).request().get(String.class);
		assertTrue(json.contains("\"surname\":\"foo\""));
	}

	@Test
	public void testReadUserWithNameFooAsObject() {
		User newUser = createUser("foo");
		User utilisateur = target("/userdb/"+ newUser.getId()).request().get(User.class);
		assertEquals("foo", utilisateur.getSurname());
	}

	@Test
	public void testCreateUserMustReturnUserWithId() {
		User savedUser = createUser("thomas");
		assertTrue(savedUser.getId() > 0);
	}

	@Test
	public void testUpdateUserName() {
		User u = createUser("thomas");
		u.setName("yann");
		Response rep = target("/userdb/" + u.getId()).request()
				.put(Entity.entity(u, MediaType.APPLICATION_JSON));
		;
		User updatedUser = rep.readEntity(User.class);
		assertEquals("yann", updatedUser.getName());
	}

	@Test
	public void testGetingSameUserTwice() {
		User user1 = target("/userdb/foo").request().get(User.class);
		User user2 = target("/userdb/foo").request().get(User.class);
		assertEquals(user1, user2);
	}

	@Test
	public void testReadUnavailableUser() {
		int status = target("/user/bar").request().get().getStatus();
		assertEquals(404, status);
	}

	@Test
	public void tesListAllUsers() {
		createUser("toto");
		createUser("titi");
		List<User> users = target("/user/").request().get(
				new GenericType<List<User>>() {
				});
		assertTrue(users.size() >= 2);
	}

	@Test
	public void testDeleteUser() {
		User u = createUser("toto");
		int status = target("/user/" + u.getId()).request().delete()
				.getStatus();
		assertEquals(404, status);
	}

	private User createUser(String name) {
		User user= new User(1, "CHAVAL", name, "etu", "cchaval", "clement.chaval@free.fr", "proutprout", "M");
		Entity<User> userEntity = Entity.entity(user, MediaType.APPLICATION_JSON);
		User savedUser = target("/userdb").request().post(userEntity)
				.readEntity(User.class);
		return savedUser;
	}
}