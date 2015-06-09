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

@Path("/lessondb")
@Produces(MediaType.APPLICATION_JSON)
public class LessonDBRessource {
	private static LessonDao dao = App.dbi.open(LessonDao.class);
	public LessonDBRessource () {
		try {
			dao.createLessonsTable();
		}
		catch (Exception e) {
			System.out.println("La table existe déjà !");
		}
	}
	
	@POST
	public Lesson createLesson(Lesson lesson) {
		int id = dao.insert(lesson.getTitle(), lesson.getContent(), lesson.getAuthor().getId(), lesson.getCategory());
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
	public List<Lesson> getLessons(@DefaultValue("10") @QueryParam("limit") int limit) {
		return dao.getLessons(limit);
	}
}
