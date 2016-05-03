package services;

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

import entites.User;


//import com.google.gson.Gson;


@Path("/login")
public class Login {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject loginService(JSONObject injson) throws JSONException {
		User user = null;
		// userid container
		String userid = null;
		// extructing username and password from incoming json object
		String username = injson.getString("username");
		String password = injson.getString("password").toString();
		// creating the Entity Manager Factory to access the database.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PropertyManager");
		// creating the Entity manager
		EntityManager em = emf.createEntityManager();
		// starting the transaction
		em.getTransaction().begin();
		// Retrieving any record with the matching username from the "auth" table in the database
		Query q = em.createQuery("SELECT DISTINCT u FROM User u WHERE u.userid = :userid");
		q.setParameter("userid", username);
		try {
			user = (User) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		emf.close();
		
		if ((user!=null) && (password.equals(user.getPassword())))  {
			userid =user.getUserid();
		
		} else {
			// if the record exist but the password do not match the username then we return a 5. 
			
			userid = null;
			
		}
		JSONObject json = new JSONObject();
		json.put("userid", userid);
		return json;
	}
}
