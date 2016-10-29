package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name="Articolo")
public class Articolo {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="ID")
	@NotEmpty (message="error")
	private int id;
	
	@Column (name="Ristorante")
	@NotEmpty (message="error")
	private String ristorante;
	
	@Column (name="Data")
	@NotEmpty (message="error")
	private String data;
	
	@Column (name="Articolo")
	@NotEmpty (message="error")
	private String articolo;
	
	@Column (name="IDArea")
	@NotEmpty (message="error")
	private int IDArea;
	
	@Column (name="IDCucina")
	@NotEmpty (message="error")
	private int IDCucina;
	
	@Column (name="IDPrezzo")
	@NotEmpty (message="error")
	private int IDPrezzo;
	
	@Column (name="IDVoto")
	@NotEmpty (message="error")
	private int IDVoto;
	
	@Column (name="Foto")
	@NotEmpty (message="error")
	private String foto;

	
	//CONSTRUCTORS
	
	public Articolo(){
		
	}
	
	public Articolo(int id, 
					String ristorante, 
					String data, 
					String articolo, 
					int iDArea, 
					int iDCucina, 
					int iDPrezzo,
					int iDVoto, 
					String foto) {

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
