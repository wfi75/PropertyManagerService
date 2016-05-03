package entites;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the media database table.
 * 
 */
@Entity
@Table(name="media")
public class Media implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idmedia;

	@Column(nullable=false, length=250)
	private String icon;

	@Column(nullable=false, length=250)
	private String picture1;

	@Column(nullable=false, length=250)
	private String picture2;

	@Column(nullable=false, length=250)
	private String picture3;

	@Column(nullable=false, length=250)
	private String picture4;

	//bi-directional one-to-one association to Property
	@OneToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="id")
	private Property property;

    public Media() {
    }

	public int getIdmedia() {
		return this.idmedia;
	}

	public void setIdmedia(int idmedia) {
		this.idmedia = idmedia;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPicture1() {
		return this.picture1;
	}

	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}

	public String getPicture2() {
		return this.picture2;
	}

	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}

	public String getPicture3() {
		return this.picture3;
	}

	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}

	public String getPicture4() {
		return this.picture4;
	}

	public void setPicture4(String picture4) {
		this.picture4 = picture4;
	}

	public Property getProperty() {
		return this.property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
	
}