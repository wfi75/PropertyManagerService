package entites;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the owner database table.
 * 
 */
@Entity
@Table(name="owner")
public class Owner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int ownerid;

	@Column(nullable=false, length=80)
	private String email;

	@Column(nullable=false, length=45)
	private String firstname;

	@Column(nullable=false, length=45)
	private String lastname;

	@Column(nullable=false, length=17)
	private String mobile;

    public Owner() {
    }

	public int getOwnerid() {
		return this.ownerid;
	}

	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}