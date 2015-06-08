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
		
		String contenu = "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed in rhoncus ante. In auctor magna rutrum, vehicula mauris ac, cursus velit. Cras porta lacinia justo, euismod consectetur odio viverra laoreet. Donec erat dolor, varius ut ipsum nec, vestibulum cursus nunc. Fusce non scelerisque nibh. Integer a bibendum ipsum. Mauris vehicula felis et nibh scelerisque, blandit suscipit lacus rhoncus. In fermentum tortor elit, sit amet vestibulum urna ultrices at. Nullam in risus tincidunt sem blandit malesuada. Maecenas mattis vitae urna id venenatis. Aliquam tempor, dolor id aliquam tincidunt, sem ligula suscipit velit, nec suscipit nulla nunc sagittis ligula. Sed et dictum nibh, vel rhoncus leo. Praesent lobortis quam in lacus tincidunt, vitae consequat mauris faucibus. Pellentesque vitae dictum sem.		</p>		<p>		Sed sit amet suscipit massa. Donec non justo ultrices, gravida mi facilisis, feugiat diam. Fusce quis nulla vel metus rutrum vulputate. Cras aliquam feugiat nibh vitae aliquet. Sed suscipit ligula tincidunt interdum bibendum. Aenean lectus tortor, maximus vitae dui ut, volutpat porta velit. Morbi nec dapibus massa, ultrices vehicula lorem. Nam efficitur feugiat metus, sed tristique dolor eleifend at. In at lorem ut neque consectetur fermentum. Cras eleifend lorem eu justo tincidunt, ac tempus nisi mattis. Ut nec felis ac lorem vestibulum consectetur.		</p>		<p>		Mauris pellentesque est massa, non cursus purus ultrices nec. Etiam finibus, lectus ut aliquam malesuada, magna lacus viverra velit, sit amet suscipit nunc dui eget purus. Nullam molestie nisl diam, vel cursus dolor tincidunt a. Nulla sit amet finibus nibh, id eleifend nisi. Phasellus nec urna ex. Fusce ac suscipit sapien. Suspendisse potenti. In hac habitasse platea dictumst.		</p>		<p>		Praesent et ultricies magna. Etiam erat tortor, consectetur ut ex sit amet, tincidunt laoreet dolor. Integer eu tincidunt velit. Nam tincidunt eros nec tellus interdum tincidunt. Aliquam erat volutpat. In in orci interdum, pellentesque nibh eget, cursus enim. Nam orci risus, laoreet sed nulla sit amet, placerat finibus dolor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Suspendisse porta bibendum scelerisque. In eget nulla hendrerit, fermentum risus quis, consequat enim. Donec quis aliquam risus. Nullam at condimentum erat, eget pellentesque lorem.		</p>		<p>		In commodo odio a risus mollis, ac sagittis velit dignissim. Suspendisse potenti. Curabitur orci sapien, aliquet vitae sem finibus, ornare faucibus enim. Donec porta interdum libero, ut varius purus eleifend a. Suspendisse ornare elementum nunc id placerat. Praesent congue finibus tristique. Mauris vestibulum urna tellus, eu tempor sapien vehicula et. Vestibulum egestas dolor a lorem efficitur dictum. Vestibulum euismod leo in nisl convallis, non ultricies est ornare. Aenean id tincidunt elit. Ut imperdiet dictum risus hendrerit mollis. Morbi varius est nibh, a sodales nisl elementum eu.</p>";

		UserResource userRessource = new UserResource();			
		Lesson newLesson = new Lesson(1, "Le C !", contenu, userRessource.getUser(1), "0000-00-00 00:00:00", 1, false, 2.5);


		lessons.put(1, newLesson);

		Lesson newLesson2 = new Lesson(2, "Le Java !", contenu, userRessource.getUser(2), "0000-00-00 00:00:00", 1, false, 4.8);

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
