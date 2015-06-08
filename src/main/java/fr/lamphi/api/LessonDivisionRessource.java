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

@Path("/lessondivision")
@Produces(MediaType.APPLICATION_JSON)
public class LessonDivisionRessource {
private static Map<Integer, LessonDivision> lessonsDiv = new HashMap<>();

	static{
		LessonDivision lessonDiv= new LessonDivision("Maths");
		lessonsDiv.put(1, lessonDiv);
		LessonDivision lessonDiv2 = new LessonDivision("Anglais");
		lessonsDiv.put(2, lessonDiv2);
	}

	@POST
	public LessonDivision createDivisons (LessonDivision lessonDiv) {
		int id = lessonsDiv.size();
		lessonDiv.setId(id+1);
		lessonsDiv.put(lessonDiv.getId(), lessonDiv);
		return lessonDiv;
	}
	
	
	
	@DELETE
	@Path("{id}")
	public Response deleteLessonDivision(@PathParam("id") Integer id) {
		if (lessonsDiv.containsKey(id)) {
			return Response.accepted().status(Status.ACCEPTED).build();
		}
	    return Response.accepted().status(Status.NOT_FOUND).build();
	}
	
	protected LessonDivision find(int id) {
		return lessonsDiv.get(id);
	}
	
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
	public Response updateLessonDivision(@PathParam("id") int id, LessonDivision lessonDiv) {
		LessonDivision oldLessonDiv = find(id);
		System.out.println("Should update user with id: "+id
				+" ("+oldLessonDiv+") to " +lessonDiv);
		if (lessonDiv == null) {
			throw new WebApplicationException(404);
		}
		oldLessonDiv.setCategory(lessonDiv.getCategory());
		return Response.status(200).entity(oldLessonDiv).build();
	}

	@GET
	@Path("/{id}")
	public LessonDivision getLessonDivision(@PathParam("id") int id ) {
		LessonDivision out = find(id);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
	
	@GET
	public List<LessonDivision> getListLessonDiv(@DefaultValue("10") @QueryParam("limit") int limit) {
		return new ArrayList<LessonDivision>(lessonsDiv.values());
	}

}

