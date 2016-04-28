package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.Prezzo;

public class DAOPrezzo {
	
	private Connection conn;
	private String select = "SELECT * FROM [BLOG].[dbo].[Prezzo] ORDER BY Nome";
	
	public DAOPrezzo() {
		conn=ConnectionManager.getConnection();
	}
	
	//creates an object for each line in the SQL table Prezzo and adds it to a list
	public List<Prezzo> getPrezzo() throws SQLException{
		PreparedStatement st=conn.prepareStatement(select);
		ResultSet rs=st.executeQuery();
		List<Prezzo> listPrezzo= new ArrayList<>();
		while(rs.next()){
			Prezzo prezzo1=new Prezzo();
			prezzo1.setID(rs.getInt("ID"));
			prezzo1.setNome(rs.getString("Nome"));
			listPrezzo.add(prezzo1);
		}
		return listPrezzo;
		
	}
}
