package models;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DAOArea;
import DAO.DAOArticolo;
import DAO.DAOCucina;
import DAO.DAOPrezzo;
import DAO.DAOVoto;
import beans.Area;
import beans.Articolo;
import beans.Cucina;
import beans.Prezzo;
import beans.Voto;

public class NewEditArticolo {
	
	private Articolo articolo;
	private List<Area> ListaArea;
	private List<Cucina> ListaCucina;
	private List<Prezzo> ListaPrezzo;
	private List<Voto> ListaVoto;
	private List<String> ListaImg;

	// constructor
	public NewEditArticolo() throws SQLException {

		DAOArea DAOa = new DAOArea();
		ListaArea = DAOa.getArea();

		DAOCucina DAOc = new DAOCucina();
		ListaCucina = DAOc.getCucina();

		DAOPrezzo DAOp = new DAOPrezzo();
		ListaPrezzo = DAOp.getPrezzo();

		DAOVoto DAOv = new DAOVoto();
		ListaVoto = DAOv.getVoto();

		ListaImg = new ArrayList<String>();
		
		// create array containing the path of all files in folder img
		File folder = new File("C:/Users/Alessandro/workspace/BLOG/WebContent/img");
		File[] arrayImg = folder.listFiles();
		
		// get the name of each file in the array and add it to ListaImg
		for (File f : arrayImg) {
			String fileName=f.getName();
			ListaImg.add(fileName);
		}

	}
	
	//get all attributes for a specific article from the DB
	public void getArticolo(int IDarticolo) {

		DAOArticolo DAOart = new DAOArticolo();

		try {
			articolo = DAOart.select(IDarticolo);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("unable to generate DAO for this article");
		}
	}
	
	
	//ACCESSORS
	
	public Articolo getArticolo() {
		return articolo;
	}

	public void setArticolo(Articolo articolo) {
		this.articolo = articolo;
	}

	public List<Area> getListaArea() {
		return ListaArea;
	}

	public void setListaArea(List<Area> listaArea) {
		ListaArea = listaArea;
	}

	public List<Cucina> getListaCucina() {
		return ListaCucina;
	}

	public void setListaCucina(List<Cucina> listaCucina) {
		ListaCucina = listaCucina;
	}

	public List<Prezzo> getListaPrezzo() {
		return ListaPrezzo;
	}

	public void setListaPrezzo(List<Prezzo> listaPrezzo) {
		ListaPrezzo = listaPrezzo;
	}

	public List<Voto> getListaVoto() {
		return ListaVoto;
	}

	public void setListaVoto(List<Voto> listaVoto) {
		ListaVoto = listaVoto;
	}

	public List<String> getListaImg() {
		return ListaImg;
	}

	public void setListaImg(List<String> listaImg) {
		ListaImg = listaImg;
	}
	
}