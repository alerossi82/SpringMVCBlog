package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import beans.Area;
import beans.Articolo;
import beans.ArticoloRM;
import beans.Cucina;
import beans.Prezzo;
import beans.Voto;

public class DAOArticoloRM {
	
	//ATTRIBUTES
	
	Session session1;
	
	
	//METHODS
	
	//constructor
	public DAOArticoloRM() {
		
	}
	
	
		
	// returns one article from DB based on ID
	public ArticoloRM getSingleArticolo(int ID) {

		// create session
		session1 = SessionManager.createSession();
		session1.beginTransaction();

		// get article from ID
		ArticoloRM art = session1.get(ArticoloRM.class, ID);
		session1.getTransaction().commit();

		return art;
	}
		
		
		
		
	//return list of all articles from DB
	public List<ArticoloRM> getAllArticles() {

		// create session
		session1 = SessionManager.createSession();
		session1.beginTransaction();

		// retrieve list of all articles, sorted by ID desc
		List<ArticoloRM> list = session1
								.createCriteria(ArticoloRM.class)
								.addOrder(Order.desc("id"))
								.list();

		session1.getTransaction().commit();

		return list;

	}
	
	
	
	
	// returns list of articles based on skip/take values
	// skip/take define how many rows will be skipped and how many will be retrieved

	public List<ArticoloRM> selectSkipAndTake (int skip, int take) {

		// create session
		session1 = SessionManager.createSession();
		session1.beginTransaction();

		// return list of articles using skip/take
		List<ArticoloRM> listArticoliToDisplay = session1
												.createCriteria(ArticoloRM.class)
												.setFirstResult(skip)	//skip n rows
												.setMaxResults(take)	//take n rows
												.list();

		session1.getTransaction().commit();

		return listArticoliToDisplay;

	}
	
	
	
	// return tot. number of articles
	public long getTotalCount () {

		// create session
		session1 = SessionManager.createSession();
		session1.beginTransaction();
		
		//count all rows in table Articoli
		long totalCount = (long) session1
						.createCriteria(ArticoloRM.class)
						.setProjection(Projections.rowCount())
						.uniqueResult();

		session1.getTransaction().commit();

		return totalCount;
	}
	
	
	
	//return list of articles texts
	public List <String> getText (){
	
	//create session
	session1 = SessionManager.createSession();
	session1.beginTransaction();
	
	//get list of values from column Articolo
	List <String> texts = 	session1
							.createCriteria(ArticoloRM.class)
							.setProjection(Projections.property("articolo")) //set column Articolo
							.list();
	
	session1.getTransaction().commit();
	
	return texts;
	
	}
	
}	
	
	
