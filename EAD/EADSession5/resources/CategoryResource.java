package GET2018.EAD.EADSession5.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import GET2018.EAD.EADSession5.dao.Status;
import GET2018.EAD.EADSession5.facade.CategoryFacade;
import GET2018.EAD.EADSession5.model.Category;

/**
 * This class gets Category Request from Client and Passes to Facade
 * 
 * @author Mohit Sharma
 *
 */
@Path("/CategoryResource")
public class CategoryResource {

	private CategoryFacade categoryFacade = CategoryFacade.getInstance();

	/**
	 * Insert data in category table
	 * 
	 * @param authorizationString
	 * @param category
	 * @return status
	 */
	@POST
	@Path("/SetFeeds")
	@Consumes(MediaType.APPLICATION_JSON)
	public Status insertIntoCategories(@HeaderParam("Authorization") String authorizationString, Category category) {
		if (!"GET-2018".equals(authorizationString)) {
			return Status.ERROR;
		}
		Status status = categoryFacade.insertCategory(category.getName());
		return status;
	}

	/**
	 * Returns all the Categories
	 * 
	 * @param authorizationString
	 * @return
	 */
	@GET
	@Path("/GetCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllCategories(@HeaderParam("Authorization") String authorizationString) {
		if (!"GET-2018".equals(authorizationString)) {
			return "" + Status.ERROR;
		}
		List<Category> categoryList = categoryFacade.getAll();
		if (categoryList.size() != 0) {
			Gson gson = new Gson();
			String categoryJson = gson.toJson(categoryList);
			return categoryJson;
		}
		return "Data Unavailable";
	}

	/**
	 * Update the Category by Id
	 * 
	 * @param authorizationString
	 * @param category
	 * @param id
	 * @return status
	 */
	@PUT
	@Path("/UpdateCategory/{category}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Status updateCategory(@HeaderParam("Authorization") String authorizationString,
			@PathParam("category") String category, @PathParam("id") String id) {
		if (!"GET-2018".equals(authorizationString)) {
			return Status.ERROR;
		}
		Status status = categoryFacade.updateCategory(category, Integer.parseInt(id));
		return status;
	}
}
