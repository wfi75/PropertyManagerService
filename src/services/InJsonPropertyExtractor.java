package services;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import entites.Media;
import entites.Owner;
import entites.Property;

public class InJsonPropertyExtractor {

	public static Property GetProperty(JSONObject json) {
		Property property = new Property();

		try {
			// extructing Property from the json object
			// getting media data
			Media media = new Media();
			media.setIcon(json.getString("icon"));
			media.setPicture1(json.getString("picture1"));
			media.setPicture2(json.getString("picture2"));
			media.setPicture3(json.getString("picture3"));
			media.setPicture4(json.getString("picture4"));
			// getting owner data
			Owner owner = new Owner();
			//owner.setOwnerid(json.getInt("ownerid"));
			owner.setLastname(json.getString("lastname"));
			owner.setFirstname(json.getString("firstname"));
			owner.setMobile(json.getString("mobile"));
			owner.setEmail(json.getString("email"));
			// getting property data
			//Property property = new Property();
			//property = new Property();
			property.setOffertype(json.getString("offertype"));
			property.setType(json.getString("type"));
			property.setRentprice(json.getInt("rentprice"));
			property.setSealprice(json.getInt("sealprice"));
			property.setRooms(json.getInt("rooms"));
			property.setArea(json.getInt("area"));
			property.setAddress(json.getString("address"));
			property.setAlarm(json.getString("alarm"));
			property.setAvailabel(json.getString("available"));
			property.setBaths(json.getInt("baths"));
			property.setDiscreption(json.getString("discreption"));
			property.setDoor(json.getInt("door"));
			property.setFloor(json.getInt("floor"));
			property.setGarden(json.getString("garden"));
			property.setKitchen(json.getString("kitchen"));
			property.setOwner(owner);
			property.setPool(json.getString("pool"));
			property.setSecurity(json.getString("security"));
			property.setZipcode(json.getInt("zipcode"));
			// ****
			property.setOwner(owner);
			property.setMedia(media);
		} catch (JSONException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return property;
		
	}
	
}
