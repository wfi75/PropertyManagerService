package entites;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the property database table.
 * 
 */
@Entity
@Table(name="property")
public class Property implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=145)
	private String address;

	@Column(nullable=false, length=3)
	private String alarm;

	@Column(nullable=false)
	private int area;

	@Column(nullable=false, length=45)
	private String availabel;

	@Column(nullable=false)
	private int baths;

	@Column(nullable=false, length=145)
	private String discreption;

	@Column(nullable=false)
	private int door;

	@Column(nullable=false)
	private int floor;

	@Column(nullable=false, length=8)
	private String garden;

	@Column(nullable=false, length=45)
	private String kitchen;

	@Column(nullable=false, length=45)
	private String offertype;

	@Column(nullable=false, length=8)
	private String pool;

	@Column(nullable=false)
	private int rentprice;

	@Column(nullable=false)
	private int rooms;

	@Column(nullable=false)
	private int sealprice;

	@Column(nullable=false, length=3)
	private String security;

	@Column(nullable=false, length=45)
	private String type;

	@Column(nullable=false)
	private int zipcode;

	//bi-directional one-to-one association to Media
	@OneToOne(mappedBy="property", cascade={CascadeType.PERSIST})
	private Media media;

	//uni-directional many-to-one association to Owner
    @ManyToOne
	@JoinColumn(name="ownerid", nullable=false)
	private Owner owner;

    public Property() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAlarm() {
		return this.alarm;
	}

	public void setAlarm(String alarm) {
		this.alarm = alarm;
	}

	public int getArea() {
		return this.area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getAvailabel() {
		return this.availabel;
	}

	public void setAvailabel(String availabel) {
		this.availabel = availabel;
	}

	public int getBaths() {
		return this.baths;
	}

	public void setBaths(int baths) {
		this.baths = baths;
	}

	public String getDiscreption() {
		return this.discreption;
	}

	public void setDiscreption(String discreption) {
		this.discreption = discreption;
	}

	public int getDoor() {
		return this.door;
	}

	public void setDoor(int door) {
		this.door = door;
	}

	public int getFloor() {
		return this.floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getGarden() {
		return this.garden;
	}

	public void setGarden(String garden) {
		this.garden = garden;
	}

	public String getKitchen() {
		return this.kitchen;
	}

	public void setKitchen(String kitchen) {
		this.kitchen = kitchen;
	}

	public String getOffertype() {
		return this.offertype;
	}

	public void setOffertype(String offertype) {
		this.offertype = offertype;
	}

	public String getPool() {
		return this.pool;
	}

	public void setPool(String pool) {
		this.pool = pool;
	}

	public int getRentprice() {
		return this.rentprice;
	}

	public void setRentprice(int rentprice) {
		this.rentprice = rentprice;
	}

	public int getRooms() {
		return this.rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public int getSealprice() {
		return this.sealprice;
	}

	public void setSealprice(int sealprice) {
		this.sealprice = sealprice;
	}

	public String getSecurity() {
		return this.security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public Media getMedia() {
		return this.media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}
	
	public Owner getOwner() {
		return this.owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
}