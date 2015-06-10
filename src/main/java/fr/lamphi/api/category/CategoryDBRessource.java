package fr.lamphi.api.category;

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
@Path("/categorydb")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryDBRessource {
	private static CategoryDao dao = App.dbi.open(CategoryDao.class);

	public CategoryDBRessource () {
		try {
			dao.createCategoriesTable();
			
			createCategory(new Category(0,"Informatique","http://www.univers-bureautique.fr/wp-content/uploads/2014/02/1260125-informatique-de-gestion-quels-metiers-pour-quels-profils1.jpg",0));
			createCategory(new Category(0,"Histoire","http://i.huffpost.com/gen/2580642/images/a-HISTOIRE-COULEURS-640x468.jpg",0));
			createCategory(new Category(0,"Mathématiques","http://www.les-calculatrices.com/images/histoire-mathematiques.jpg",0));
			createCategory(new Category(0,"Littérature","http://www.bonjourdefrance.com/image/le-passe-simple-et-litterature-grammaire-bdf-19.jpg",0));
			createCategory(new Category(0,"Médecine","http://images.atelier.net/sites/default/files/imagecache/scale_crop_587_310/articles/423819/atelier-medecine-holographique.jpg",0));
			createCategory(new Category(0,"Science Physique","http://3.bp.blogspot.com/-a-NfnUSq9fI/U2KbmCRxPMI/AAAAAAAAQnQ/iLsWA7FMZ-E/s1600/physique-quantique.png",0));
			createCategory(new Category(0,"Sport","http://orthodz.com/wp-content/uploads/2014/09/sport.jpg",0));
		}
		catch (Exception e) {
		}
	}

	@POST
	public Category createCategory(Category category) {
		int id = dao.insert(category.getName(),
				category.getImage(), category.getParentId());
		category.setId(id);
		return category;
	}

	@GET
	@Path("/{id}")
	public Category getCategory(@PathParam("id") int id) {
		Category out = dao.findById(id);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}

	@GET
	public List<Category> getCategories(
			@DefaultValue("10") @QueryParam("limit") int limit) {
		return dao.getCategories(limit);
	}
}
