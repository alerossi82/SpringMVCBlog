package models;

import java.util.List;

import DAO.DAOArticoloRM;
import beans.ArticoloRM;

public class AdminViewModel {

	
	// ATTRIBUTES
	private ArticoloRM articolo;
	private DAOArticoloRM DAOrm;
	private List<ArticoloRM> listaAllArticoli;

	
	// CONSTRUCTOR
	public AdminViewModel() {
		DAOrm = new DAOArticoloRM();
	}

	
	// METHODS
	public void generateListaAllArticoli() {
		listaAllArticoli = DAOrm.getAllArticles();
	}
	
	
	// ACCESSORS

	public ArticoloRM getArticolo() {
		return articolo;
	}

	public void setArticolo(ArticoloRM articolo) {
		this.articolo = articolo;
	}

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
}
