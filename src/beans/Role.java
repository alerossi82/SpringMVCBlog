package beans;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {
	
	//ATTRIBUTES
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int id;
	
	private String roleName;
	
	//map the association table UsersAndRoles to users
	@ManyToMany (mappedBy = "roles") //mappedBy property indicates the parent side of the relationship
	private List<Users> users;
	
	
	
	//CONSTRUCTOR
	public Role(int id, String roleName, List<Users> users) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.users = users;
	}

	
	
	
	//ACCESSORS
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getRoleName() {
		return roleName;
	}



	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}



	public List<Users> getUsers() {
		return users;
	}



	public void setUsers(List<Users> users) {
		this.users = users;
	}
	

}
