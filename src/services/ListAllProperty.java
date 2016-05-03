package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import entites.Property;

@Path("/list")
public class ListAllProperty {
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/all")
	public JSONArray ListAll() {
		JSONArray jsonarray = null;
		List<Property> propertylist = null;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PropertyManager");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT p FROM Property p"); 
		try {
			propertylist =q.getResultList();
			em.flush();
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		em.close();
		emf.close();
		if (propertylist!=null) 
			try {
				jsonarray = JsonArrayCreator.PropertyToJsonArray(propertylist);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return jsonarray;
		
	}
	

}
