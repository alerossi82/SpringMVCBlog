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
import beans.Area;
import beans.Articolo;
import beans.ArticoloRM;
import beans.Cucina;
import beans.Prezzo;
import beans.Voto;

public class DAOArticoloRM {
	
	//ATTRIBUTES
	
	Session session1;
	
	//SQL queries
	
	// select one ArticleRM based on ID
	// IDArea, IDCucina, IDPrezzo and IDVoto are automatically joined with related tables based on annotations in class ArticoloRM
	private String getArticolo= "FROM ArticoloRM  " //bean ArticoloRM is joined to table Articolo through annotation
								+ "WHERE id= :id";
	
	// return all ArticlesRM from DB, ordered by the most recent
	// IDArea, IDCucina, IDPrezzo and IDVoto are automatically joined with related tables based on annotations in class ArticoloRM
	private String getAllArticles = "FROM ArticoloRM " // bean ArticoloRM is joined to table Articolo through annotation
								  + "ORDER BY ID DESC";
	
	//return the tot. number of articles in DB
	private String selectCount = "SELECT COUNT(*) FROM ArticoloRM";
	
	//METHODS
	
	//constructor
	public DAOArticoloRM() {
		
	}
	
	
	
	// return tot. number of articles
	public long getTotalCount() {
		
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
	}
	
	
	//returns one single article 
	public ArticoloRM getSingleArticolo (int ID) {
		
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
	}
	
	
	
	// returns list of all articles
	public List<ArticoloRM> getAllArticles () {
		
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
		
	}
	
	
	
	
	
	
	// returns a list of articles based on skip/take params
	// skip/take define how many rows will be skipped and how many will be taken
	
	public List<ArticoloRM> selectSkipAndTake(int skip, int take) {
		
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
		
	}
	
	
}