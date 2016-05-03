package services;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import entites.Property;

public class JsonArrayCreator {
	
	public JsonArrayCreator(){
	}

	
	public static JSONArray PropertyToJsonArray(List<Property> resultlist) throws JSONException{
		
		Property p;
		JSONArray jsonarray = new JSONArray();
		JSONObject[] jsonobject = new JSONObject[resultlist.size()];  
		
		for (int i = 0; i< resultlist.size(); i++) {
			p = (Property) resultlist.get(i);
			jsonobject[i] = new JSONObject();
			jsonobject[i].put("address", p.getAddress());
			jsonobject[i].put("alarm", p.getAlarm());
			jsonobject[i].put("area", p.getArea());
			jsonobject[i].put("available", p.getAvailabel());
			jsonobject[i].put("baths", p.getBaths());
			jsonobject[i].put("discreption", p.getDiscreption());
			jsonobject[i].put("door", p.getDoor());
			jsonobject[i].put("floor", p.getFloor());
			jsonobject[i].put("garden", p.getGarden());
			jsonobject[i].put("id", p.getId());
			jsonobject[i].put("kitchen", p.getKitchen());
			jsonobject[i].put("offertype", p.getOffertype());
			jsonobject[i].put("pool", p.getPool());
			jsonobject[i].put("rentprice", p.getRentprice());
			jsonobject[i].put("rooms", p.getRooms());
			jsonobject[i].put("sealprice", p.getSealprice());
			jsonobject[i].put("security", p.getSecurity());
			jsonobject[i].put("type", p.getType());
			jsonobject[i].put("zipcode", p.getZipcode());
			// *********  adding media data
			jsonobject[i].put("icon", p.getMedia().getIcon());
			jsonobject[i].put("picture1", p.getMedia().getPicture1());
			jsonobject[i].put("picture2", p.getMedia().getPicture2());
			jsonobject[i].put("picture3", p.getMedia().getPicture3());
			jsonobject[i].put("picture4", p.getMedia().getPicture4());
			// ********** adding owner data
			jsonobject[i].put("ownerid", p.getOwner().getOwnerid());
			jsonobject[i].put("firstname",p.getOwner().getFirstname());
			jsonobject[i].put("lastname",p.getOwner().getLastname());
			jsonobject[i].put("email", p.getOwner().getEmail());
			jsonobject[i].put("mobile", p.getOwner().getMobile());
			jsonarray.put(jsonobject[i]);
			
		}
		
		return jsonarray;
	}
}
