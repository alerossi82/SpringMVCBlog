package models;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
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
	
	//ATTRIBUTES
	
	@Valid	//requested to trigger validation of bean Articolo
	private Articolo articolo;

	private List<Area> ListaArea;
	private List<Cucina> ListaCucina;
	private List<Prezzo> ListaPrezzo;
	private List<Voto> ListaVoto;
	private List<String> ListaImg;
	
	
	//METHODS
	
	//CONSTRUCTOR
	
	//create article model without ID number
	//used in controller POST method
	public NewEditArticolo () {
		
		populateLists();
	}
	
	//create Article model based on ID number
	//if ID=0 (new Article), creates empty model
	//used in controller GET method
	public NewEditArticolo(int ID) throws SQLException {

		// call DAOArticolo.select only if article already exists
		if (ID != 0) {
			DAOArticolo DAOart = new DAOArticolo();
			articolo = DAOart.select(ID);
		}

		populateLists();
		
	}
	
	public void populateLists() {
		
		// return list of all objects from table Area
		DAOArea DAOa = new DAOArea();
		ListaArea = DAOa.getArea();

		// return list of all objects from table Cucina
		DAOCucina DAOc = new DAOCucina();
		ListaCucina = DAOc.getCucina();

		// return list of all objects from table Prezzo
		DAOPrezzo DAOp = new DAOPrezzo();
		ListaPrezzo = DAOp.getPrezzo();

		// return list of all objects from table Voto
		DAOVoto DAOv = new DAOVoto();
		ListaVoto = DAOv.getVoto();

		ListaImg = new ArrayList<String>();
		// create array containing the path of all files in folder img
		File folder = new File("C:/Users/Alessandro/workspace/SpringMVCBlog/WebContent/resources/img");
		File[] arrayImg = folder.listFiles();
		// get the name of each file in the array and add it to ListaImg
		for (File f : arrayImg) {
			String fileName = f.getName();
			ListaImg.add(fileName);
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