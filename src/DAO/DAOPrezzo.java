package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import beans.Prezzo;

public class DAOPrezzo {
	
	//ATTRIBUTES
	
	Session session1;
	private String select = "FROM Prezzo ORDER BY Nome";
	
	
	
	//METHODS
	
	//Constructor
	public DAOPrezzo() {
		
	}
	
	
	
	//creates a list of all items from Prezzo table
	public List<Prezzo> getPrezzo() {
		
		//create session
		session1= SessionManager.createSession();
		
		//start session
		session1.beginTransaction();
		
		//create query
		List<Prezzo> list1= session1
							.createQuery(select)
							.getResultList();
							
		//execute query
		session1.getTransaction().commit();
		
		//return list
		return list1;
	}
}
