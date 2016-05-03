package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import entites.Media;
import entites.Owner;
import entites.Property;

@Path("/add")
public class AddProperty {
	@POST
	@Path("/property")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject addProperty(JSONObject injson) {
		Property property = new Property();
		Owner owner = new Owner();
		Media media = new Media();
		int propertyid = -1;
		JSONObject outjson = null;
		property.setOwner(owner);
		property.setMedia(media);
		property = InJsonPropertyExtractor.GetProperty(injson);	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PropertyManager");
		// creating the Entity manager
		EntityManager em = emf.createEntityManager();
		// starting the transaction	
		
		// creating the Entity Manager Factory to access the database.
		try {
		
		em.getTransaction().begin();
		
		// checking if the owner exist then we link it to this property otherwise a new owner is created
		Query q = em.createQuery("SELECT o FROM Owner o WHERE o.mobile = '" + property.getOwner().getMobile() + " ' ");
		
		
		List<Object> exowner = (List<Object>) q.getResultList();
		
		
		//property.setOwner(null);
		//property.setMedia(media);
		property.getMedia().setProperty(property);
		
		if (exowner.size() != 0) {
			property.setOwner(null);
			em.persist(property);
			property.setOwner((Owner) exowner.get(0));
		} else {
			em.persist(property.getOwner());
			em.persist(property);
		}
		em.getTransaction().commit();
		
		//em.clear();
		
		
		// em.getTransaction().begin();
		// em.flush();
		propertyid = property.getId();
		outjson = new JSONObject(); 
		try {
			outjson.put("propertyid", propertyid);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();

		}
		
		return outjson;
		
	}

}
