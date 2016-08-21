package DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Area;

public class DAOArea {
	
	//ATTRIBUTES
	
	Session session1;
	
	// SQL query to retrive all data from table Area
	private String selectArea = "FROM Area ORDER BY ID";
	
	
	
	
	
	//METHODS
	
	//Constructor
	public DAOArea() {
		
		
	}
	
	
	

	// returns a List of all rows in the SQL table Area
	public List<Area> getArea() {
		
		//create session
		session1=SessionManager.createSession();
		session1.beginTransaction();

		List<Area> listaAree = session1.createQuery(selectArea).getResultList();

		session1.getTransaction().commit();
		
		return listaAree;
	}
}