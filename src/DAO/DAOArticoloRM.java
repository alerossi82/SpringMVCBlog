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
	
	//DEPRECATED
	/*//SQL queries
	
	// select one ArticleRM based on ID
	// IDArea, IDCucina, IDPrezzo and IDVoto are automatically joined with related tables based on annotations in class ArticoloRM
	private String getArticolo= "FROM ArticoloRM  " //bean ArticoloRM is joined to table Articolo through annotation
								+ "WHERE id= :id";
	
	// return all ArticlesRM from DB, ordered by the most recent
	// IDArea, IDCucina, IDPrezzo and IDVoto are automatically joined with related tables based on annotations in class ArticoloRM
	private String getAllArticles = "FROM ArticoloRM " // bean ArticoloRM is joined to table Articolo through annotation
								  + "ORDER BY ID DESC";
	
	//return the tot. number of articles in DB
	private String selectCount = "SELECT COUNT(*)"
							   + "FROM ArticoloRM";*/
	
	
	
	
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
	
}	
	
	// return tot. number of articles
		/*public long getTotalCount() {
			
			//create session
			session1=SessionManager.createSession();
			session1.beginTransaction();
			
			//create query
			long totalCount= (long) session1
							.createQuery(selectCount)
							.getSingleResult();
			
			//execute query
			session1.getTransaction().commit();
			
			//return tot. articoli
			return totalCount;
		}*/
		
		//DEPRECATED
		
		//returns one single article 
		/*public ArticoloRM getSingleArticolo (int ID) {
			
			//create session
			session1=SessionManager.createSession();
			session1.beginTransaction();
			
			//create get article query
			ArticoloRM art= (ArticoloRM) session1
							.createQuery(getArticolo)
							.setParameter("id", ID)
							.getSingleResult();
			
			session1.getTransaction().commit();
			
			return art;
		}*/
		
		
		
		// returns list of all articles, order by ID desc
		/*public List<ArticoloRM> getAllArticles () {
			
			//create session
			session1=SessionManager.createSession();
			session1.beginTransaction();
			
			//create query
			List<ArticoloRM> RestaurantsList =  session1
									 			.createQuery(getAllArticles)
									 			.getResultList();
			
			session1.getTransaction().commit();
			
			//return list
			return RestaurantsList;
			
		}*/
		
		
		
		
		
		
		// returns a list of articles based on skip/take params
		// skip/take define how many rows will be skipped and how many will be taken
		
		/*public List<ArticoloRM> selectSkipAndTake(int skip, int take) {
			
			//create session
			session1=SessionManager.createSession();
			session1.beginTransaction();
			
			//create and execute query
			List<ArticoloRM> listArticoliToDisplay=  session1
													.createQuery(getAllArticles)
													.setFirstResult(skip)//nr of results to skip
													.setMaxResults(take)//nr of results to fetch
													.getResultList();
			
			session1.getTransaction().commit();
			
			//return results
			return listArticoliToDisplay;
			
		}*/
	
