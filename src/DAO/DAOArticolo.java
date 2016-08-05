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
	
	// SQL query to SELECT all data from a single row in table Articoli
	private String select = "FROM Articolo WHERE ID= :id";

	//SQL query to SELECT all data from top ? rows in table Articoli
	private String selectTop = "FROM Articolo ORDER BY ID desc";
	
	//SQL query to UPDATE a row in table Articoli
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
	private String delete="DELETE FROM Articolo WHERE ID=?";
	
	
	//CONSTRUCTOR
	public DAOArticolo(){
		
	}
	
	
	//METHODS
	
	// this method returns a new Article for a given ID using the SELECT query
	// called in servlet ControllerHome
	public List<Articolo> select(int id) {

		// create session
		SessionFactory factory = new Configuration().
								configure("hibernate.cfg.xml").
								addAnnotatedClass(Articolo.class).
								buildSessionFactory();

		Session session1 = factory.getCurrentSession();
		
		//run query select
		session1.beginTransaction();
		
		List<Articolo> art = session1.createQuery(select)
							.setParameter("id", id) //positional parameter
							.getResultList();
	
		session1.getTransaction().commit();
		
		return art;
	}
	
	
	//returns a List of ? Articoli (?=fetch)
	//called in servlet ControllerHome
	public List<Articolo> selectTop (int fetch){
		
		// create session
		SessionFactory factory = new Configuration().
										configure("hibernate.cfg.xml").
										addAnnotatedClass(Articolo.class).
										buildSessionFactory();

		Session session1 = factory.getCurrentSession();
		
		//run query selectTop
		session1.beginTransaction();
		
		List<Articolo> listArticoli = session1.createQuery(selectTop)
									 .setMaxResults(fetch) //number of articles returned
									 .getResultList();
		
		session1.getTransaction().commit();
		
		return listArticoli;
	}

	
	// insert new article in DB
	//called in servlet ArticleManagerController
	public void insert (Articolo art) {
		
		// create session
		SessionFactory factory = new Configuration().
								configure("hibernate.cfg.xml").
								addAnnotatedClass(Articolo.class).
								buildSessionFactory();
		
		Session session1 = factory.getCurrentSession();
		
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
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Articolo.class)
								.buildSessionFactory();

		Session session1 = factory.getCurrentSession();
		
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
	
	public void delete (Articolo art) {
		
		// create session
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Articolo.class)
				.buildSessionFactory();
		Session session1 = factory.getCurrentSession();
		
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
