package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import beans.Users;

public class DAOUser {
	
	//ATTRIBUTES
	private String selectUser = "FROM Users WHERE Email= :email";
	private String selectAllEmails = "Select email FROM Users";
	
	private Session session1;
	
	
	// METHODS
	// constructor
	public DAOUser() {

	}
	
	

	// return all emails from table User
	public List<String> selectAllEmails()  {
		
		//create session
		session1 = SessionManager.createSession();
				
		//create session
		session1.beginTransaction();
		
		//create query
		List<String> listEmails= session1
							  .createQuery(selectAllEmails)
						      .getResultList();
		
		session1.getTransaction().commit();
		
		//return results
		return listEmails;
	}

	
	
	
	
	// insert new User in DB
	public void insertUser(String email, String password) {
		
		//create session
		session1 = SessionManager.createSession();
		session1.beginTransaction();
		
		//create new object
		Users user1= new Users (email, password);
		
		//save object
		session1.save(user1);
		
		//commit transaction
		session1.getTransaction().commit();
		
	}

	
	
	
	// return user details for a given email
	public Users returnUser(String email) {

		// create session
		session1 = SessionManager.createSession();
		session1.beginTransaction();

		// create query
		Users user1 = (Users) session1
					 .createQuery(selectUser)
					 .setParameter("email", email) //set positional parameter
					 .getSingleResult();
		
		session1.getTransaction().commit();
		
		//return results
		return user1;

	}
}