package models;

import java.sql.SQLException;
import java.util.List;
import javax.validation.constraints.Size;
import DAO.DAOArea;
import DAO.DAOArticolo;
import DAO.DAOArticoloRM;
import DAO.DAOCucina;
import DAO.DAOPrezzo;
import DAO.DAOVoto;
import beans.Area;
import beans.Articolo;
import beans.ArticoloRM;
import beans.Cucina;
import beans.Prezzo;
import beans.Voto;

public class HomeViewModel {
	
	//ATTRIBUTES
	
	private DAOArticoloRM DAOrm;
	private ArticoloRM articolo; 
	private int skip; // number of articles to skip table Articoli
	private int take; //number of articles to retrieve from table Articoli
	private List<ArticoloRM> ListaArticoliRM; //list of articles to display in Homepage
	private List<ArticoloRM> listaAllArticoli; //list of ID and restaurant name for all articles
	private long totArticoliinDB; 
	private long totPages; 
	private int currentPage; // page number from Home page
	private boolean showListOfAllArticles; //if true, displays list of all articles in sidebar
	
	
	
	
	//METHODS
	
	//Constructor
	public HomeViewModel() throws SQLException {
		
		//articles to display in each page
		take=2;
		
		DAOrm = new DAOArticoloRM();
		
		//return tot.number of rows in table Articoli
		totArticoliinDB=DAOrm.getTotalCount();
		
		//returns number of tot.pages for Home page, rounding up if the result is a decimal
		totPages= (totArticoliinDB + take -1)/take;
	}
	
	
	
	public void generateArticolo (int ID) throws SQLException{
		articolo=DAOrm.getSingleArticolo(ID);
	}
	
	
	
	//generate list of articles to display based on the page number
	public void generateListaArticoliRM (int page) throws SQLException{
		currentPage = page;
		
		//skip articles displayed in previous pages
		skip = take*(currentPage-1); 
		ListaArticoliRM = DAOrm.selectSkipAndTake(skip, take);
	}
	
	
	
	public void generateListaAllArticoli() throws SQLException{
		listaAllArticoli=DAOrm.getAllArticles();
	}
	
	
	
	
	//ACCESSORS
	
	public List<ArticoloRM> getListaArticoliRM() {
		return ListaArticoliRM;
	}

	public void setListaArticoliRM(List<ArticoloRM> listaArticoliRM) {
		ListaArticoliRM = listaArticoliRM;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	public long getTotArticoliinDB() {
		return totArticoliinDB;
	}

	public void setTotArticoliinDB(int totArticoliinDB) {
		this.totArticoliinDB = totArticoliinDB;
	}

	public int getTake() {
		return take;
	}

	public void setTake(int take) {
		this.take = take;
	}

	public long getTotPages() {
		return totPages;
	}

	public void setTotPages(int totPages) {
		this.totPages = totPages;
	}

	public List<ArticoloRM> getListaAllArticoli() {
		return listaAllArticoli;
	}

	public void setListaAllArticoli(List<ArticoloRM> listaAllArticoli) {
		this.listaAllArticoli = listaAllArticoli;
	}

	public ArticoloRM getArticolo() {
		return articolo;
	}

	public void setArticolo(ArticoloRM articolo) {
		this.articolo = articolo;
	}

	public boolean isShowListOfAllArticles() {
		return showListOfAllArticles;
	}

	public void setShowListOfAllArticles(boolean showListOfAllArticles) {
		this.showListOfAllArticles = showListOfAllArticles;
	}
	
}