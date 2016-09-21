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
	
	
	
	
	

}
