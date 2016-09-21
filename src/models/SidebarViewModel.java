package models;

import java.util.List;
import DAO.DAOArticoloRM;
import beans.ArticoloRM;

public class SidebarViewModel {

	// ATTRIBUTES
	private DAOArticoloRM DAOrm;
	private List<ArticoloRM> listaAllArticoli;
	private long totArticoliinDB; 

	
	// CONSTRUCTOR
	public SidebarViewModel() {
		
		DAOrm = new DAOArticoloRM();
		
		//return tot.number of Articoli
		totArticoliinDB=DAOrm.getTotalCount();
	}

	
	// METHODS
	
	//generate list of articles for Sidebar view 
	public void generateListaAllArticoli() {
		listaAllArticoli = DAOrm.getAllArticles();
	}

	
	// ACCESSORS

	public DAOArticoloRM getDAOrm() {
		return DAOrm;
	}

	public void setDAOrm(DAOArticoloRM dAOrm) {
		DAOrm = dAOrm;
	}

	public List<ArticoloRM> getListaAllArticoli() {
		return listaAllArticoli;
	}

	public void setListaAllArticoli(List<ArticoloRM> listaAllArticoli) {
		this.listaAllArticoli = listaAllArticoli;
	}


	public long getTotArticoliinDB() {
		return totArticoliinDB;
	}


	public void setTotArticoliinDB(long totArticoliinDB) {
		this.totArticoliinDB = totArticoliinDB;
	}
	
	

}