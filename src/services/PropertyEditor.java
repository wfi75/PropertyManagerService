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

@Path("/editproperty")
public class PropertyEditor {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/avai")
	public void ChangeAvailability(JSONObject injson) {
		int propertyid = -1;
		try {
			propertyid = injson.getInt("propertyid");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Property property = InJsonPropertyExtractor.GetProperty(injson);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PropertyManager");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Property oldproperty = em.find(Property.class, propertyid);
		if (oldproperty.getAvailabel().equalsIgnoreCase("yes"))
			oldproperty.setAvailabel("no");
		else oldproperty.setAvailabel("yes");
		em.getTransaction().commit();
		//em.flush();
		em.close();
		emf.close();
	
	}
	
}
