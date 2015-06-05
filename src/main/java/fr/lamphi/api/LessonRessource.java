package fr.lamphi.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import cours.*;

@Path("/lesson")
@Produces(MediaType.APPLICATION_JSON)
public class LessonRessource {
	private static Map<Integer, Cours> lessons = new HashMap<>();
	
	static {
		Cours newCours = new Cours("Le C !", lessons.size()+1, "TaMere", "17/06/2015", true);
		lessons.put(newCours.getid(), newCours);
	}
	
	@POST
	public Cours createLesson(Cours lesson) {
		Cours ret = new Cours(lesson.getTitre(), lessons.size()+1, lesson.getAuteur(), lesson.getDateCrea(), lesson.isValide());
		lessons.put(ret.getid(), ret);
		return ret;
	}
	
	@GET
	@Path("/{id}")
	public Cours getUser(@PathParam("id") int id ) {
		Cours out = lessons.get(id);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
	
	@GET
	public List<Cours> getLessons(@DefaultValue("10") @QueryParam("limit") int limit) {
		return new ArrayList<Cours>(lessons.values());
	}

}
