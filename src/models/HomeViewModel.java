package models;

import java.sql.SQLException;
import java.util.List;
import DAO.DAOArticoloRM;
import beans.ArticoloRM;

public class HomeViewModel {
	
	//ATTRIBUTES
	
	private DAOArticoloRM DAOrm;
	private int skip; // number of articles to skip table Articoli
	private int take; //number of articles to retrieve from table Articoli
	private List<ArticoloRM> ListaArticoliRM; //list of articles to display in Homepage
	private long totArticoliinDB; 
	private long totPages; 
	private int currentPage; //current page number from Home page
	
	
	
	//METHODS
	
	//Constructor
	public HomeViewModel() {
		
		//articles to display in each page
		take=2;
		
		DAOrm = new DAOArticoloRM();
		
		//return tot.number of Articoli
		totArticoliinDB=DAOrm.getTotalCount();
		
		//returns number of tot.pages, rounding up if the result is a decimal
		totPages= (totArticoliinDB + take -1)/take;
		
	}
	
	
	//generate list of articles to display in homepage based on page number
	public void generateListaArticoliRM (int page) {
		currentPage = page;
		
		//skip articles displayed in previous pages
		skip = take*(currentPage-1); 
		ListaArticoliRM = DAOrm.selectSkipAndTake(skip, take);
		
		
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


}