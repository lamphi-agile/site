package fr.lamphi.api.user;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;
import org.skife.jdbi.v2.DBI;

import fr.lamphi.api.App;
import fr.lamphi.api.RestClient;

public class RestClientTest extends JerseyTest {
	private static UserDao dao;

	@Override
	protected Application configure() {
		App app = new App();
		DBI dbi = app.dbi;
		dao = dbi.open(UserDao.class);
		return new App();
	}

	@Before
	public void cleanupDb() {
		dao.dropUserTable();
		dao.createUserTable();
	}

	@Test
	public void getUsers() {
		int port = this.getPort();
		String baseUrl = "http://localhost:" + port + "/user/";
		RestClient client = new RestClient();
		client.addUser(new User(1, "CHAVAL", "Clément", "etu", "cchaval", "clement.chaval@free.fr", "proutprout", "M"), baseUrl);
		client.addUser(new User(2, "CLAVIER", "Thomas", "prof", "tclavier", "thomas.clavier@univ-lille1.fr", "proutprout", "M"), baseUrl);
		List<User> users = client.getUrlAsUser(baseUrl);
		assertEquals(4, users.size());
	}
}