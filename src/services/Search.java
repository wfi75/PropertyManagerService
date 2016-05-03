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

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import entites.Property;

@Path("/search")
public class Search {
	
	@POST
	@Path("/property")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray PropertySearch(JSONObject injson) {
		List<Property> propertylist = null;
		JSONArray jsonarray = null;
		String offertype = "Rent or Sale ";
		String proptype = "Any type of property";
		String pricerange = "Any price range";
		String rooms = "Any number of rooms";
		String location = "In all distrects";
		String roomsfilter = "";
		String locationfilter = "";
		String pricefilter = "";
		String offertypefilter = "";
		String propertytypefilter = "";
		
		try {
			rooms = injson.getString("rooms");
			location = injson.getString("zip");
			offertype = injson.getString("offer");
			proptype = injson.getString("type");
			pricerange = injson.getString("price");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// creating the offer type filter
		offertypefilter = " WHERE p.offertype = '" + offertype + "'";
		
		// creating the proper type filter
		if (!proptype.equals("Any type of property"))
		propertytypefilter = " AND p.type = '" + proptype +"'"; 
		
		// creating price range filter
		if (offertype.equals("Sale")){
			if (!pricerange.equals("Any price range")) {
				if (pricerange.equalsIgnoreCase("1000 or less")) {
				pricefilter = " AND p.sealprice < 1000";
				} else 
				if (pricerange.equals("1000 to 3000")) {
					pricefilter = " AND p.sealprice > 999 AND p.sealprice < 2999";
				} else 
				if (pricerange.equals("3000 to 4000")) {
					pricefilter = " AND p.sealprice > 3000 AND p.sealprice < 4000";
				} else
				if (pricerange.equals("4000 to 5000")) {
					pricefilter = " AND p.sealprice > 4000 AND p.sealprice < 5000";
				} else
				if (pricerange.equals("5000 to 10000")) {
					pricefilter = " AND p.sealprice > 5000 AND p.sealprice < 10000";
				} else
				if (pricerange.equals("10000 to 50000")) {
					pricefilter = " AND p.sealprice > 10000 AND p.sealprice < 50000";
				} else
				if (pricerange.equals("50000 to 100000")) {
					pricefilter = " AND p.sealprice > 50000 AND p.sealprice < 100000";
				} else
				if (pricerange.equals("100000 to 300000")) {
					pricefilter = " AND p.sealprice > 100000 AND p.sealprice < 300000";
				} else
				if (pricerange.equals("300000 to 500000")) {
					pricefilter = " AND p.sealprice > 300000 AND p.sealprice < 500000";
				} else
				if (pricerange.equals("500000 to 1000000")) {
					pricefilter = " AND p.sealprice > 500000 AND p.sealprice < 1000000";
				} else
				if (pricerange.equals("1000000 or more")) {
					pricefilter = " AND p.sealprice > 1000000";
				}
			}
		} else 
		if (offertype.equals("Rent")){
			if (!pricerange.equals("Any price range")) {
				if (pricerange.equalsIgnoreCase("1000 or less")) {
				pricefilter = " AND p.rentprice < 1000";
				} else 
				if (pricerange.equals("1000 to 3000")) {
					pricefilter = " AND p.rentprice > 1000 AND p.rentprice < 3000";
				} else 
				if (pricerange.equals("3000 to 4000")) {
					pricefilter = " AND p.rentprice > 3000 AND p.rentprice < 4000";
				} else
				if (pricerange.equals("4000 to 5000")) {
					pricefilter = " AND p.rentprice > 4000 AND p.rentprice < 5000";
				} else
				if (pricerange.equals("5000 to 10000")) {
					pricefilter = " AND p.rentprice > 5000 AND p.rentprice < 10000";
				} else
				if (pricerange.equals("10000 to 50000")) {
					pricefilter = " AND p.rentprice > 10000 AND p.rentprice < 50000";
				} else
				if (pricerange.equals("50000 to 100000")) {
					pricefilter = " AND p.rentprice > 50000 AND p.rentprice < 100000";
				} else
				if (pricerange.equals("100000 to 300000")) {
					pricefilter = " AND p.rentprice > 100000 AND p.rentprice < 300000";
				} else
				if (pricerange.equals("300000 to 500000")) {
					pricefilter = " AND p.rentprice > 300000 AND p.rentprice < 500000";
				} else
				if (pricerange.equals("500000 to 1000000")) {
					pricefilter = " AND p.rentprice > 500000 AND p.rentprice < 1000000";
				} else
				if (pricerange.equals("1000000 or more")) {
					pricefilter = " AND p.rentprice > 1000000";
				}
			}
		}
		
		
		// creating the number of rooms filter if available
		if (!rooms.equals("Any number of rooms"))
			roomsfilter = " AND p.rooms = " + rooms;
		
		// creating the area code filter if available
		if (!location.equals("In all distrects")){
			int x = Integer.valueOf(location);
			switch (x) {
			case 1: 
				locationfilter = " AND p.zipcode > 1009 AND p.zipcode < 1020 ";
				break;
			case 2:
				locationfilter = " AND p.zipcode > 1019 AND p.zipcode < 1030 ";
				break;
			case 3:
				locationfilter = " AND p.zipcode > 1029 AND p.zipcode < 1040 ";
				break;
			case 4:
				locationfilter = " AND p.zipcode > 1039 AND p.zipcode < 1050 ";
				break;
			case 5:
				locationfilter = " AND p.zipcode > 1049 AND p.zipcode < 1060 ";
				break;
			case 6:
				locationfilter = " AND p.zipcode > 1059 AND p.zipcode < 1070 ";
				break;
			case 7:
				locationfilter = " AND p.zipcode > 1069 AND p.zipcode < 1080 ";
				break;
			case 8:
				locationfilter = " AND p.zipcode > 1079 AND p.zipcode < 1090 ";
				break;
			case 9:
				locationfilter = " AND p.zipcode > 1089 AND p.zipcode < 1100 ";
				break;
			case 10:
				locationfilter = " AND p.zipcode > 1099 AND p.zipcode < 1110 ";
				break;
			case 11:
				locationfilter = " AND p.zipcode > 1109 AND p.zipcode < 1120 ";
				break;
			case 12:
				locationfilter = " AND p.zipcode > 1119 AND p.zipcode < 1130 ";
				break;
			case 13:
				locationfilter = " AND p.zipcode > 1129 AND p.zipcode < 1140 ";
				break;
			case 14:
				locationfilter = " AND p.zipcode > 1139 AND p.zipcode < 1150 ";
				break;
			case 15:
				locationfilter = " AND p.zipcode > 1149 AND p.zipcode < 1160 ";
				break;
			case 16:
				locationfilter = " AND p.zipcode > 1159 AND p.zipcode < 1170 ";
				break;
			case 17:
				locationfilter = " AND p.zipcode > 1169 AND p.zipcode < 1180 ";
				break;
			case 18:
				locationfilter = " AND p.zipcode > 1179 AND p.zipcode < 1190 ";
				break;
			case 19:
				locationfilter = " AND p.zipcode > 1189 AND p.zipcode < 1200 ";
				break;
			case 20:
				locationfilter = " AND p.zipcode > 1199 AND p.zipcode < 1210 ";
				break;
			case 21:
				locationfilter = " AND p.zipcode > 1209 AND p.zipcode < 1220 ";
				break;
			case 22:
				locationfilter = " AND p.zipcode > 1219 AND p.zipcode < 1230 ";
				break;
			}
		}
			
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PropertyManager");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT p FROM Property p" + offertypefilter + propertytypefilter + pricefilter + roomsfilter + locationfilter); 
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
