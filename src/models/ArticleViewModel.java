package models;

import DAO.DAOArticoloRM;
import beans.ArticoloRM;

public class ArticleViewModel {
	
	//ATTRIBUTES
	private DAOArticoloRM DAOrm;
	private ArticoloRM articolo;
	
	
	
	
	//CONSTRUCTOR
	public ArticleViewModel () {
		DAOrm = new DAOArticoloRM();
	}
	
	
	
	
	//METHODS
	//generate Article model based on ID
	public void generateArticolo(int ID) {
		articolo = DAOrm.getSingleArticolo(ID);
	}

	

	//ACCESSORS
	
	public DAOArticoloRM getDAOrm() {
		return DAOrm;
	}

	public void setDAOrm(DAOArticoloRM dAOrm) {
		DAOrm = dAOrm;
	}

	public ArticoloRM getArticolo() {
		return articolo;
	}

	public void setArticolo(ArticoloRM articolo) {
		this.articolo = articolo;
	}
	

}
