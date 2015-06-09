package fr.lamphi.api.lesson;

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

import fr.lamphi.api.user.UserResource;

@Path("/lesson")
@Produces(MediaType.APPLICATION_JSON)
public class LessonRessource {
	private static Map<Integer, Lesson> lessons = new HashMap<>();
	
	static{
		
		String contenu = "# Posita dignas## Solutis prensos dumLorem markdownum pulvere: tanta dum turbantur, Colophonius, campis Tantale, iteripso, quo, ab! Ire ducar dixit impetus viderat, deosque nunc ossa quoniam haustipraesagia ex.## Ignes ut luna erat virtus tutusNunc quisquis sororum. Avitis de ignotos nunc poste, foret. Est annos velatusIovis ullis, vino hostis vestigia feroxque oraque, adnuimusque [antesit](http://omfgdogs.com/). Intexere in dumque facinus alte, veri Peleus orbaamico dat adveniens.Vera faciesque saxum in satis et undas profugi iacent in capillos **tenet**; et.Suo [non siquidem foret](http://eelslap.com/) lunae adspicit indigno, est membrainter iacent cui inmiti sua domos mirantur, date iuro. Imbribus partu satistibique regibus en includere, et inde, sed fare Rhodopeius licet mons aquarumgenitore. Ulla fugat, pater mali inania; mira caelo gestae.## Clangore silvaMea arbore cavas ab sedibus gentis quo *urit Aeacides* noctis quaerensque ante;ista aura furtim aeque semesarumque, quamvis. Ceu accessit trahendo **vesana**inferior iter quamquam iter hoc sed illo nemorosam, tuetur positosque. Arborepolypus non, iter non carinas, et unus displicet torquetur confine.## Menti hominemque genitor minae et longis servasIllic frequentes poma licet fessam, nec spatiosum pendens indicio tamen etlumina iamdudum simul; est. Hunc flammas bella ponitur compescuit gravatumtribus mortale, in tot? Vel ab novato imagine, peperi sub omnia vincta; suoquefulgura, exspectatoque.## Quin tibi et milesEo quae mea, fuerat *sagitta*, spes est ea et parens crista. Temptasse utinam,aera naturae tuaque; crura deos aequi saxoque. Sternebat et fore; nisi munusquotiensque tempore oculorum quisquis tenui. Astringi disque nulla mulcendastyranni pectore, sed in coirent.memoryBigCamera(whitelistDriveBoot);bloatwareMinimizeShortcut = framework;dvdPrompt += bankruptcy.direct_gateway(diskRaster, windows_denial) +serp.third(integerRecursion, fileUsWins) - gateDhcp;Urbes quae ille quod colla nate volandi, quoniam caedis, Nycteliusque utilis.Abas admonita: ambo celeremque arces Nesso sanctasque radice prospicit Laconideo proxima rapta! Testantia puer torvamque cum cum, sub Aside dabant, trabesquereddat. Sit horum violentam decus, nec sua nomine in nitebant, temeraria?*Iamque* ire petuntur neve dixisse ferro, nunc fudi: domitis flammae.";
		
		UserResource userRessource = new UserResource();			
		Lesson newLesson = new Lesson(1, "Le C !", contenu, userRessource.getUser(1).getId(), "0000-00-00 00:00:00", 1, false, 2.5, 0);

		lessons.put(1, newLesson);
		
		Lesson newLesson2 = new Lesson(2, "Le Java !", contenu, userRessource.getUser(2).getId(), "0000-00-00 00:00:00", 1, false, 4.8, 0);

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
