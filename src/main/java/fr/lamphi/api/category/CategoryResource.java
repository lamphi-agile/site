package fr.lamphi.api.category;

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
public class CategoryResource {
private static Map<Integer, Category> categories = new HashMap<>();

	static{
		Category category= new Category("Maths");
		categories.put(1, category);
		Category category2 = new Category("Anglais");
		categories.put(2, category2);
	}

	@POST
	public Category createDivisons (Category lessonDiv) {
		int id = categories.size();
		lessonDiv.setId(id+1);
		categories.put(lessonDiv.getId(), lessonDiv);
		return lessonDiv;
	}
	
	
	
	@DELETE
	@Path("{id}")
	public Response deleteLessonDivision(@PathParam("id") Integer id) {
		if (categories.containsKey(id)) {
			return Response.accepted().status(Status.ACCEPTED).build();
		}
	    return Response.accepted().status(Status.NOT_FOUND).build();
	}
	
	protected Category find(int id) {
		return categories.get(id);
	}
	
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
	public Response updateLessonDivision(@PathParam("id") int id, Category lessonDiv) {
		Category oldLessonDiv = find(id);
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
	public Category getLessonDivision(@PathParam("id") int id ) {
		Category out = find(id);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
	
	@GET
	public List<Category> getListLessonDiv(@DefaultValue("10") @QueryParam("limit") int limit) {
		return new ArrayList<Category>(categories.values());
	}

}

