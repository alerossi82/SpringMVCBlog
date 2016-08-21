package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Users")
public class Users {
	
	//ATTRIBUTES
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="ID")
	private int ID;
	
	@Column (name="Email")
	private String email;
	
	@Column (name="Password")
	private String password;
	
	
	//CONSTRUCTORS
	
	public Users(){
		
	}
	
	public Users(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	
	//ACCESSORS
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

}
