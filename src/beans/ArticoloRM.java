package beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table (name="vArticles")
public class ArticoloRM {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="ID")
	private int id;
	
	@Column (name="Ristorante")
	private String ristorante;
	
	@Column (name="Area")
	private String area;
	
	@Column (name="Cucina")
	private String cucina;
	
	@Column (name="Voto")
	private int voto;
	
	@Column (name="Prezzo")
	private String prezzo;
	
	@Column (name="Data")
	private Date data;
	
	@Column (name="Articolo")
	private String articolo;
	
	@Column (name="Foto")
	private String foto;
	
	@Column (name="Summary")
	private String summary;
	
	
	//CONSTRUCTOR
	
	public ArticoloRM(){
		
	}
	
	


	//ACCESSORS
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRistorante() {
		return ristorante;
	}

	public void setRistorante(String ristorante) {
		this.ristorante = ristorante;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCucina() {
		return cucina;
	}

	public void setCucina(String cucina) {
		this.cucina = cucina;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public String getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getArticolo() {
		return articolo;
	}

	public void setArticolo(String articolo) {
		this.articolo = articolo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	
}
