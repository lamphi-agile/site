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
			
			Category category = new Category(0, "Informatique", "", 0);
			Category category2 = new Category(0, "Histoire", "", 0);
			createCategory(category);
			createCategory(category2);
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
