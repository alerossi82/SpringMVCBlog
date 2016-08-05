package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Articolo")
public class Articolo {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="ID")
	private int id;
	
	@Column (name="Ristorante")
	private String ristorante;
	
	@Column (name="Data")
	private String data;
	
	@Column (name="Articolo")
	private String articolo;
	
	@Column (name="IDArea")
	private int IDArea;
	
	@Column (name="IDCucina")
	private int IDCucina;
	
	@Column (name="IDPrezzo")
	private int IDPrezzo;
	
	@Column (name="IDVoto")
	private int IDVoto;
	
	@Column (name="Foto")
	private String foto;

	
	//CONSTRUCTORS
	public Articolo(){
		
	}
	
	public Articolo(int id, String ristorante, String data, String articolo, int iDArea, int iDCucina, int iDPrezzo,
			int iDVoto, String foto) {
		this.id = id;
		this.ristorante = ristorante;
		this.data = data;
		this.articolo = articolo;
		IDArea = iDArea;
		IDCucina = iDCucina;
		IDPrezzo = iDPrezzo;
		IDVoto = iDVoto;
		this.foto = foto;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getArticolo() {
		return articolo;
	}

	public void setArticolo(String articolo) {
		this.articolo = articolo;
	}

	public int getIDArea() {
		return IDArea;
	}

	public void setIDArea(int iDArea) {
		IDArea = iDArea;
	}

	public int getIDCucina() {
		return IDCucina;
	}

	public void setIDCucina(int iDCucina) {
		IDCucina = iDCucina;
	}

	public int getIDPrezzo() {
		return IDPrezzo;
	}

	public void setIDPrezzo(int iDPrezzo) {
		IDPrezzo = iDPrezzo;
	}

	public int getIDVoto() {
		return IDVoto;
	}

	public void setIDVoto(int iDVoto) {
		IDVoto = iDVoto;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
