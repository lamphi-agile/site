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
		Category category= new Category(1,"Maths","",0);
		categories.put(category.getId(), category);
		Category category2 = new Category(1,"Anglais","",0);
		categories.put(category2.getId(), category2);
	}

	@POST
	public Category createCategory(Category category) {
		int id = categories.size();
		category.setId(id+1);
		categories.put(category.getId(), category);
		return category;
	}
	
	protected Category find(int id) {
		return categories.get(id);
	}

	@GET
	@Path("/{id}")
	public Category getCategory(@PathParam("id") int id ) {
		Category out = find(id);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
	
	@GET
	public List<Category> getCategories(@DefaultValue("10") @QueryParam("limit") int limit) {
		return new ArrayList<Category>(categories.values());
	}

}

