package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import entites.Property;

@Path("/delete")
public class Delete {

	@POST
	@Path("/property")
	@Consumes(MediaType.APPLICATION_JSON)
	public void DeleteProperty(JSONObject injson) {
		
		int propertyid = -1;
		try {
			propertyid = injson.getInt("propertyid");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PropertyManager");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Property tobedeleted = em.find(Property.class, propertyid);
		em.remove(tobedeleted.getMedia());
		em.remove(tobedeleted);
		em.getTransaction().commit();
		//em.flush();
		em.close();
		emf.close();
	}
}
