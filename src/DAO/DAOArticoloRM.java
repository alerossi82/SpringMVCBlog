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
	//SQL queries
	
	// select Article based on ID
	// IDArea, IDCucina, IDPrezzo and IDVoto are automatically joined with
	// related tables based on annotations in class ArticoloRM
	private String getArticolo= "FROM ArticoloRM  "
								+ "WHERE id= :id";

	//return the tot. number of articles in DB
	private String selectCount = "SELECT COUNT(*) "
							   + "FROM Articolo";
	
	private String selectIDandRistorante = "SELECT ID,Ristorante "
										 + "FROM Articolo "
									     + "ORDER BY ID DESC";
	
	// take all fields from ? rows in Articoli, skipping (offset) previous ? rows
	// table Articoli is joined with tables Cucina, Area, Prezzo and Voto
	private String selectWithJoin = "SELECT Articolo.ID, Articolo.Ristorante, Area.Nome AS Area, Cucina.Nome AS Cucina, Prezzo.Nome AS Prezzo, Articolo.Data, Articolo.Articolo, Voto.Nome AS Voto, Articolo.Foto "
			+ "FROM Articolo INNER JOIN Cucina "
			+ "ON Articolo.IDCucina=Cucina.ID INNER JOIN Area "
			+ "ON Articolo.IDArea=Area.ID INNER JOIN Prezzo "
			+ "ON Articolo.IDPrezzo=Prezzo.ID INNER JOIN Voto " 
			+ "ON Articolo.IDVoto=Voto.ID "
			+ "ORDER BY Articolo.ID DESC " 
			+ "OFFSET=:skip ROWS FETCH NEXT=:take ROWS ONLY";
	
	
	//METHODS
	
	//return a specific article 
	public ArticoloRM getSingleArticolo (int ID) {
		
		// create session
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(ArticoloRM.class)
								.addAnnotatedClass(Cucina.class)
								.addAnnotatedClass(Area.class)
								.addAnnotatedClass(Prezzo.class)
								.addAnnotatedClass(Voto.class)
								.buildSessionFactory();
		Session session1 = factory.getCurrentSession();
				
		session1.beginTransaction();
		
		//create get article query
		ArticoloRM art= (ArticoloRM) session1
						.createQuery(getArticolo)
						.setParameter("id", ID)
						.getSingleResult();
		
		session1.getTransaction().commit();
		
		return art;
	}

	// return number of all items in table Articolo
	public int getTotalCount() throws SQLException {
		int totalCount = 0;
		PreparedStatement stmt = conn.prepareStatement(selectCount);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			totalCount = rs.getInt(1);
		}
		return totalCount;
	}

	// return list of all fields ID and Ristorante from table Articoli
	public List<ArticoloRM> getAllIDandRistorante() throws SQLException {
		PreparedStatement statement = conn.prepareStatement(selectIDandRistorante);
		ResultSet rs = statement.executeQuery();
		List<ArticoloRM> list = new ArrayList<ArticoloRM>();
		while (rs.next()) {
			ArticoloRM art = new ArticoloRM();
			art.setId(rs.getInt("ID"));
			art.setRistorante(rs.getString("Ristorante"));
			list.add(art);
		}
		return list;
	}

	// returns a list of ArticoloRM objects using the selectWithJoin query
	// skip/take define how many rows will be skipped and how many will be taken
	public List<ArticoloRM> selectWithJoin(int skip, int take) throws SQLException {
		// set and execute query
		PreparedStatement statement = conn.prepareStatement(selectWithJoin);
		statement.setInt(1, skip);
		statement.setInt(2, take);
		ResultSet rs = statement.executeQuery();
		// create an ArticoloRM object for each selected row, set the attributes
		// and add it to List<ArticoloRM>
		List<ArticoloRM> listaArticoliRM = new ArrayList<ArticoloRM>();
		while (rs.next()) {
			ArticoloRM art = new ArticoloRM();
			art.setId(rs.getInt("ID"));
			art.setData(rs.getString("Data"));
			art.setArticolo(rs.getString("Articolo"));
			art.setRistorante(rs.getString("Ristorante"));
			art.setArea(rs.getString("Area"));
			art.setCucina(rs.getString("Cucina"));
			art.setPrezzo(rs.getString("Prezzo"));
			art.setVoto(rs.getInt("Voto"));
			art.setFoto(rs.getString("Foto"));
			listaArticoliRM.add(art);
		}
		return listaArticoliRM;
	}
}
