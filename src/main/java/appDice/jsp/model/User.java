package appDice.jsp.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="USER")
public class User {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="EMAIL",unique=true)
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
		
	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name = "USER_TYPE")
	private String userType;
	
	@Column(name = "IS_ACTIVE")
	private boolean isActive;
	
	@Column(name = "LAST_SESSION_START",columnDefinition="DATETIME")
	private Date lastSessionStart;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Game> pacient = new HashSet<Game>(0);
	
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getLastSessionStart() {
		return lastSessionStart;
	}

	public void setLastSessionStart(Date lastSessionStart) {
		this.lastSessionStart = lastSessionStart;
	}

	
	public Set<Game> getPacient() {
		return pacient;
	}

	public void setPacient(Set<Game> pacient) {
		this.pacient = pacient;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
