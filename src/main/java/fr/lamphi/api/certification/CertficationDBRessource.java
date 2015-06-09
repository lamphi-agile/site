package fr.lamphi.api.certification;

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

import fr.lamphi.api.App;
import fr.lamphi.api.lesson.Lesson;
import fr.lamphi.api.user.User;

@Path("/certificationdb")
@Produces(MediaType.APPLICATION_JSON)
public class CertficationDBRessource {
	private static CertficationDao dao = App.dbi.open(CertficationDao.class);

	public CertficationDBRessource () {
		try {
			dao.createCertficationsTable();
			
			dao.certifiate(1, 1);
			dao.certifiate(2, 1);
			
		}
		catch (Exception e) {
			System.out.println("La table CERTIFICATIONS existe déjà !");
		}
	}

	@POST
	public int certifiate(User user, Lesson lesson) {
		return dao.certifiate(user.getId(), lesson.getId());
	}

	@GET
	@Path("/{lessonid}")
	public int getNbCertfications(@PathParam("lessonid") int lessonid) {
		return dao.getNbCertifications(lessonid);
	}
}
