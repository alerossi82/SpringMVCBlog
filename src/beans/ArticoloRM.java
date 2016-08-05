package beans;

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
@Table (name="Articolo")
public class ArticoloRM {
	
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
	
	//column IDArea is joined with entity Area
	@ManyToOne
	@JoinColumn (name="IDArea")
	private Area area;
	
	//column IDCucina is joined with entity Cucina
	@ManyToOne
	@JoinColumn (name="IDCucina")
	private Cucina cucina;
	
	//column IDPrezzo is joined with entity Prezzo
	@ManyToOne
	@JoinColumn (name="IDPrezzo")
	private Prezzo prezzo;
	
	//column IDVoto is joined with entity Voto
	@ManyToOne
	@JoinColumn (name="IDVoto")
	private Voto voto;
	
	@Column (name="Foto")
	private String foto;
	
	
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
	
	/*public String getArticoloSummary() {
		return articolo.left(200) + "...";
	}*/
	
	public void setArticolo(String articolo) {
		this.articolo = articolo;
	}
	
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Cucina getCucina() {
		return cucina;
	}

	public void setCucina(Cucina cucina) {
		this.cucina = cucina;
	}

	public Prezzo getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Prezzo prezzo) {
		this.prezzo = prezzo;
	}

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
}
