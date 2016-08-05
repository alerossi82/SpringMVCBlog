package DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Area;

public class DAOArea {

	// SQL query to retrive all data from table Area
	private String selectArea = "FROM Area ORDER BY ID";

	public DAOArea() {
		
	}

	// returns a List of all rows in the SQL table Area
	public List<Area> getArea() {
		
		// create session factory
		SessionFactory factory = new Configuration().
								 configure("hibernate.cfg.xml").addAnnotatedClass(Area.class).
								 buildSessionFactory();

		// create session
		Session session1 = factory.getCurrentSession();
		
		session1.beginTransaction();

		List<Area> listaAree = session1.createQuery(selectArea).getResultList();

		session1.getTransaction().commit();
		
		return listaAree;
	}
}