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

@Path("/lesson")
@Produces(MediaType.APPLICATION_JSON)
public class LessonRessource {
	private static Map<Integer, Lesson> lessons = new HashMap<>();
	
	static{
		Lesson newLesson = new Lesson("Le C !", 1, "TestAuthr", "0000-00-00 00:00:00", false);
		lessons.put(1, newLesson);
		
		Lesson newLesson2 = new Lesson("Le Java !", 2, "TestAuthr", "0000-00-00 00:00:00", false);
		lessons.put(2, newLesson2);
	}
	
	@POST
	public Lesson createLesson(Lesson lesson) {
		int id = lessons.size();
		lesson.setId(id+1);
		lessons.put(lesson.getId(), lesson);
		return lesson;
	}
	
	@DELETE
	@Path("{id}")
	public Response deletelesson(@PathParam("id") Integer id) {
		if (lessons.containsKey(id)) {
			return Response.accepted().status(Status.ACCEPTED).build();
		}
	    return Response.accepted().status(Status.NOT_FOUND).build();
	}
	
	protected Lesson find(String name) {
		Lesson out = null;
		for (Lesson lesson : lessons.values()) {
			if (lesson.getTitle().equals(name)) {
				return lesson;
			}
		}
		return out;
	}
	protected Lesson find(int id) {
		return lessons.get(id);
	}
	
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
	public Response updatelesson(@PathParam("id") int id, 
			Lesson lesson) {
		Lesson oldlesson = find(id);
		System.out.println("Should update lesson with id: "+id
				+" ("+oldlesson+") to " +lesson);
		if (lesson == null) {
			throw new WebApplicationException(404);
		}
		oldlesson.setTitle(lesson.getTitle());
		return Response.status(200).entity(oldlesson).build();
	}
	
	@GET
	@Path("/{id}")
	public Lesson getlesson(@PathParam("id") int id ) {
		Lesson out = find(id);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
	
	@GET
	public List<Lesson> getlessons(@DefaultValue("10") @QueryParam("limit") int limit) {
		return new ArrayList<Lesson>(lessons.values());
	}

}
