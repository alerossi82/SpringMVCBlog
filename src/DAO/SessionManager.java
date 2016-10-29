package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import beans.Area;
import beans.Articolo;
import beans.ArticoloRM;
import beans.Cucina;
import beans.Prezzo;
import beans.Users;
import beans.Voto;


public class SessionManager {
	
	private static Session session1;
	
	//create session
	public static Session createSession() {
	
	//create factory
	SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Articolo.class)
							.addAnnotatedClass(ArticoloRM.class)
							.addAnnotatedClass(Cucina.class)
							.addAnnotatedClass(Area.class)
							.addAnnotatedClass(Prezzo.class)
							.addAnnotatedClass(Voto.class)
							.addAnnotatedClass(Users.class)
							.buildSessionFactory();
	
	//get current session
	session1 = factory.getCurrentSession();
	
	return session1;
	
	}
}
