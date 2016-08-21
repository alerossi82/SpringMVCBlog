package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import beans.Voto;

public class DAOVoto {
	
	//ATTRIBUTES
	
	Session session1;
	private String select = "FROM Voto ORDER BY Nome";
	
	
	
	//METHODS
	
	//constructor
	public DAOVoto() {
		
	}
	
	
	
	
	
	//generates a list containing an object for each line in the Voto table
	public List<Voto> getVoto() {
		
		//create session
		session1=SessionManager.createSession();
		session1.beginTransaction();
		
		//create query
		List<Voto> listVoti= session1
							.createQuery(select)
							.getResultList();
		
		session1.getTransaction().commit();
		
		//return results
		return listVoti;
		
	}
	
}
