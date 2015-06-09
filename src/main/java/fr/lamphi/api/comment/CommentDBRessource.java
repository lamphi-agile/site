package fr.lamphi.api.comment;

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

/** TODO **/
@Path("/lessondb")
@Produces(MediaType.APPLICATION_JSON)
public class CommentDBRessource {
	private static CommentDao dao = App.dbi.open(CommentDao.class);

	public CommentDBRessource () {
		try {
			dao.createLessonsTable();
			
			
		}
		catch (Exception e) {
			System.out.println("La table LESSONS existe déjà !");
		}
	}

	@POST
	public Lesson createLesson(Lesson lesson) {
		int id = dao.insert(lesson.getTitle(), lesson.getContent(),
				lesson.getIdAuthor(), lesson.getCategory());
		lesson.setId(id);
		return lesson;
	}

	@GET
	@Path("/{id}")
	public Lesson getLesson(@PathParam("id") int id) {
		Lesson out = dao.findById(id);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}

	@GET
	public List<Lesson> getLessons(
			@DefaultValue("10") @QueryParam("limit") int limit) {
		return dao.getLessons(limit);
	}
}
