package GET2018.EAD.EADSession5.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import GET2018.EAD.EADSession5.dao.*;
import GET2018.EAD.EADSession5.facade.*;
import GET2018.EAD.EADSession5.model.*;

/**
 * This class gets Advertisement Request from Client and Passes to Facade
 * 
 * @author Mohit Sharma
 *
 */
@Path("/AdvertisementResource")
public class AdvertisementResource {
	private AdvertisementFacade advertisementFacade = AdvertisementFacade.getInstance();

	/**
	 * Inserts Advertisement in Database
	 * 
	 * @param id
	 * @param name
	 * @return status
	 */
	@POST
	@Path("/SetFeeds")
	@Consumes(MediaType.APPLICATION_JSON)
	public Status insertIntoAdvertisement(@HeaderParam("Authorization") String authorizationString,
			Advertisement advertisement) {
		if (!"GET-2018".equals(authorizationString)) {
			return Status.ERROR;
		}
		Status status = advertisementFacade.insertAdvertisement(advertisement.getCategoryId(), advertisement.getTitle(),
				advertisement.getDescription());
		return status;
	}

	/**
	 * Gets All Advertisements
	 * 
	 * @return
	 */
	@GET
	@Path("/GetAdvertisement")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllAdvertisement(@HeaderParam("Authorization") String authorizationString) {
		if (!"GET-2018".equals(authorizationString)) {
			return "" + Status.ERROR;
		}
		List<Advertisement> advertisementList = advertisementFacade.getAll();
		Gson gson = new Gson();
		String advertismnetJson = gson.toJson(advertisementList);
		return advertismnetJson;
	}

	/**
	 * Get Advertisement Using Id
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/GetAdvertisementById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllAdvertisementById(@HeaderParam("Authorization") String authorizationString,
			@PathParam("id") String id) {
		if (!"GET-2018".equals(authorizationString)) {
			return "" + Status.ERROR;
		}
		List<Advertisement> advertisementList = advertisementFacade.getById(Integer.parseInt(id));
		Gson gson = new Gson();
		String advertisemnetJson = gson.toJson(advertisementList);
		return advertisemnetJson;
	}

	/**
	 * Updates Name of an Advertisement
	 * 
	 * @param authorizationString
	 * @param id
	 * @param title
	 * @return status
	 */
	@PUT
	@Path("/UpdateAdvertisement/{id}/{title}")
	@Produces(MediaType.APPLICATION_JSON)
	public Status updateAdvertisementName(@HeaderParam("Authorization") String authorizationString,
			@PathParam("id") String id, @PathParam("title") String title) {
		if (!"GET-2018".equals(authorizationString)) {
			return Status.ERROR;
		}
		Status status = advertisementFacade.updateName(title, Integer.parseInt(id));
		return status;
	}

	/**
	 * Deletes Advertisement
	 * 
	 * @param authorizationString
	 * @param id
	 * @return status
	 */
	@DELETE
	@Path("/DeleteAdvertisementById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Status deleteAdvertisementById(@HeaderParam("Authorization") String authorizationString,
			@PathParam("id") int id) {
		if (!"GET-2018".equals(authorizationString)) {
			return Status.ERROR;
		}
		Status status = advertisementFacade.deleteAdvertisement(id);
		return status;
	}
}
