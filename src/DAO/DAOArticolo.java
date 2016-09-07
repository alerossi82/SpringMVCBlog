package DAO;

import java.beans.Statement;
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

public class DAOArticolo {
	
	//ATTRIBUTES
	
	Session session1;
	
	//DEPRECATED
	// SQL query to SELECT all data from a single row in table Articoli
	//private String select = "FROM Articolo WHERE ID= :id";
	
	
	/*//SQL query to UPDATE a row in table Articoli
	private String update = " UPDATE Articolo "
							+ "SET Ristorante= :ristorante,"
							+ " IDArea= :idArea,"
							+ " IDCucina= :idCucina,"
							+ " IDPrezzo= :prezzo,"
							+ " Data= :data,"
							+ " Articolo= :articolo,"
							+ " IDVoto= :idVoto,"
							+ " Foto= :foto "
							+ "WHERE ID= :id";
	
	//SQL query to DELETE a row in table Articoli
	private String delete="DELETE FROM Articolo WHERE ID=?";*/
	
	
	//SQL query to SELECT all data from top ? rows in table Articoli
	//private String selectTop = "FROM Articolo ORDER BY ID desc";
	
	
	//METHODS
	
	// CONSTRUCTOR
	public DAOArticolo() {

		
	}
	
	
	
	
	//returns an Article for the given id
	public Articolo select (int id) {
		
		// create session
		session1 = SessionManager.createSession();
		session1.beginTransaction();
		
		//get article from id
		Articolo art=session1.get(Articolo.class, id);
		
		//execute query
		session1.getTransaction().commit();
		return art;
	}

	
	
	// insert new article in DB
	//called in servlet ArticleManagerController
	public void insert (Articolo art) {
		
		// create session
		session1 = SessionManager.createSession();
		
		//create new Article and set params
		Articolo newArt=new Articolo();
		
		newArt.setRistorante(art.getRistorante());
		newArt.setIDArea(art.getIDArea());
		newArt.setIDCucina(art.getIDCucina());
		newArt.setIDPrezzo(art.getIDPrezzo());
		newArt.setData(art.getData());
		newArt.setArticolo(art.getArticolo());
		newArt.setIDVoto(art.getIDVoto());
		newArt.setFoto(art.getFoto());
		
		//save in DB
		session1.beginTransaction();
		session1.save(newArt);
		session1.getTransaction().commit();
	}

	
	//update a specific article in DB
	public void update(Articolo art) {
		
		// create session
		session1 = SessionManager.createSession();

		session1.beginTransaction();
		
		//get Articolo ID
		int id=art.getId();
		
		//select Article
		Articolo artToUpdate=session1.get(Articolo.class, id);
		
		//set new Article attribues
		artToUpdate.setArticolo(art.getArticolo());
		artToUpdate.setData(art.getData());
		artToUpdate.setFoto(art.getFoto());
		artToUpdate.setIDArea(art.getIDArea());
		artToUpdate.setIDCucina(art.getIDCucina());
		artToUpdate.setIDPrezzo(art.getIDPrezzo());
		artToUpdate.setIDVoto(art.getIDVoto());
		artToUpdate.setRistorante(art.getRistorante());
		
		//execute update
		session1.getTransaction().commit();
		
	}
	
	
	//delete article
	public void delete (Articolo art) {
		
		// create session
		session1 = SessionManager.createSession();
		session1.beginTransaction();
		
		//get article ID
		int id=art.getId();
		
		//get article
		Articolo artToDelete= session1.get(Articolo.class, id);
		
		//delete article
		session1.delete(artToDelete);
		session1.getTransaction().commit();
	}
	
	
	
	
	
		//DEPRECATED
		//returns a List of ? Articoli (?=fetch)
	/*	public List<Articolo> selectTop (int fetch){
			
			// create session
			session1 = SessionManager.createSession();
			
			//run query selectTop
			session1.beginTransaction();
			
			List<Articolo> listArticoli = session1.createQuery(selectTop)
										 .setMaxResults(fetch) //number of articles returned
										 .getResultList();
			
			session1.getTransaction().commit();
			
			return listArticoli;
		}*/
	
	// this method returns an Article for a given ID using the SELECT query
/*	public Articolo select(int id) {
		
		// create session
		session1 = SessionManager.createSession();
		
		//run query select
		session1.beginTransaction();
		
		Articolo art =  (Articolo) session1
						.createQuery(select)
						.setParameter("id", id) //positional parameter
						.getSingleResult();
	
		session1.getTransaction().commit();
		
		return art;
	}*/

}
