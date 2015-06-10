package fr.lamphi.api.lesson;

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
import fr.lamphi.api.user.User;

@Path("/lessondb")
@Produces(MediaType.APPLICATION_JSON)
public class LessonDBRessource {
	private static LessonDao dao = App.dbi.open(LessonDao.class);

	public LessonDBRessource () {
		try {
			dao.createLessonsTable();
			dao.createNotesTable();
			
			String contenu = "# Simul fletu misce vidisse supposita quamvis\n\n## Genua modo fuit non si liliaque\n\nLorem markdownum usque et luminibus **tamen mollibus** huius Cocalus multo\nseductaque eligit petis? Attonitas lacrimis, nox per tamen pro cortice: illud.\nAgi umquam temporis miliaque, o meliora Sigea Nise sequens mensae exstinctique.\n\n## Falsaque confusura munus Iovem non proposita vidit\n\nInsequitur pressit, cui facienda more tertius modo credens,\n[una](http://twitter.com/search?q=haskell) Melas. Et fides aliquid? Cum et Liber\ninmemor, mox, cum **mater turpius Hic** Iasone servat; iam semper furit! Sibi\ncum ponitque curam et primus Tyrrhenus volat tuas tulit.\n\n    queue(5, design_portal(-4, 5, gate - modem),\n            readme.menu_handle_mouse.wddmPciFloating(5));\n    if (adapter_print) {\n        drag += view_networking(bounce) / pop_virtual;\n        fddiDigital.pitch = ethics(backsideRamBoot);\n    } else {\n        shiftParity = seo_browser_permalink;\n    }\n    if (ultra(recursion_output) + word == iteration) {\n        usbPerlScalable = imageDigitalParse;\n        rom_opacity = protocolMaskIeee;\n        netmask(device, dialog.hyperlink(39, associationGnuRecursive),\n                desktopIscsi);\n    }\n    var kilobyte_newbie = -5 + postscript.code.shortcut(e_fragmentation_isdn);\n\n## Teretes clipeoque duxit quoque et bracchia iactatis\n\nFleverunt venit, e, velle cum altrici dicens comitum templa meos aethera avis.\nDigitis parvos aequos Cupidinis membra Semiramis vetustos inminet equidem?\n\n> Suas seque iuratus nomen. Est humo, suum murra, remi mors urbis stamina terga\n> fine munus Syringa nurus. Adspicit quam, sis [sacrorum aera\n> prodere](http://landyachtz.com/) genitore laeter noxque obitum dominaeque\n> marmore? A nimium et et flebam carnibus sibi ut nurus Cererem: nec **en nisi\n> virgo**, deusve.\n\n## Aut servas auxiliaria visus distabat undas fulvo\n\nTertius mensis, magnumque quid? Fassus ortu tempora locuta pariter recepta.\nNatus terra nostro, sibi torta Naryciusque vacuam spatium referam ferendam, in\nadeo?\n\nLoco flamina decertare in **opem** dumque narratibus altas, aetas regna. Senior\net iubet horrent profuso largoque *proxima et tollit* ad. Enixa Quirini e inpia\nsilvani serta sua medium est nec: occupat una erat effectum si securim diversas\nfontis.";
			
			Lesson newLesson = new Lesson(1, "Le C !", contenu, 1, "0000-00-00 00:00:00", 1, false, 2.5, 0);
			Lesson newLesson2 = new Lesson(2, "Le Java !", contenu, 2, "0000-00-00 00:00:00", 1, false, 4.8, 0);
			Lesson newLesson3 = new Lesson(2, "La révolution française", contenu, 2, "0000-00-00 00:00:00", 2, false, 4.8, 0);
			
			createLesson(newLesson);
			createLesson(newLesson2);
			createLesson(newLesson3);
			
		}
		catch (Exception e) {
		}
	}

	@POST
	public Lesson createLesson(Lesson lesson) {
		int id = dao.insert(lesson.getTitle(), lesson.getContent(),
				lesson.getIdAuthor(), lesson.getCategory());
		lesson.setId(id);
		return lesson;
	}
	
	public Lesson incrementViews(Lesson lesson) {
		dao.incrementViews(lesson.getId());
		lesson.setViews(lesson.getViews()+1);
		return lesson;
	}
	
	public int insertNote(Lesson lesson, User user, double note) {
		int out = dao.insertNote(lesson.getId(), user.getId(), note);
		return out;
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
	@Path("/search/{keyword}")
	public List<Lesson> search(@PathParam("keyword") String keyword) {
		List<Lesson> out = dao.search(keyword);
		return out;
	}
	
	@GET
	@Path("/note/{id}")
	public double getNoteAverage(@PathParam("id") int id) {
		double out = dao.getNoteAverage(id);
		return out;
	}
	
	@GET
	@Path("/note/perweek/{id}")
	public double getNoteWeekAverage(@PathParam("id") int id) {
		double out = dao.getNoteWeekAverage(id);
		return out;
	}

	@GET
	public List<Lesson> getLessons(
			@DefaultValue("10") @QueryParam("limit") int limit) {
		return dao.getLessons(limit);
	}
	
	@GET
	@Path("/category/{categoryId}")
	public List<Lesson> getLessonsByCategory(@PathParam("categoryId") int categoryId) {
		return dao.getLessonsByCategory(categoryId);
	}
}
