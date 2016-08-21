package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import beans.Cucina;

public class DAOCucina {
	
	//ATTRIBUTES
	Session session1;
	
	private String select = "FROM Cucina ORDER BY Nome";
	
	
	
	//METHODS
	
	// constructor
	public DAOCucina() {

	}
	
	
	
	//create list from table Cucina
	public List<Cucina> getCucina() {
		
		// create session
		session1 = SessionManager.createSession();
		session1.beginTransaction();
		
		//create query
		List<Cucina> list= session1
					  	   .createQuery(select)
					  	   .getResultList();
		
		session1.getTransaction().commit();
		
		//return list
		return list;
		
	}

}
