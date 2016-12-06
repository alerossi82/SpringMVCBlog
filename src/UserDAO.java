

import java.util.List;
import beans.Users;

//list of methods to access table Users
public interface UserDAO {
	
	void addUser (Users user);
	void editUser (Users user);
	void deleteUser (Users user);
	Users findUser (int userId);
	Users findUserByName (String username);
	List <Users> getAllUsers ();

}
