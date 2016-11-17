package beans;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name="Articolo")
public class Articolo {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="ID")
	@NotNull (message="This field can not be empty")
	private int id;
	
	@Column (name="Ristorante")
	@NotEmpty (message="This field can not be empty")
	@Pattern (regexp="[^<&&[^>]]*", message="The use of characters < and > is not allowed") //exclude tags from textbox
	private String ristorante;
	
	@Column (name="Data")
	@NotNull (message="This field can not be empty")
	/*@Pattern (regexp="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)", message="Please insert date in format dd/mm/yyyy")*/
	@Temporal (TemporalType.DATE) //match the data type used in DB
	private Date data;
	
	@Column (name="Articolo")
	@NotEmpty (message="This field can not be empty")
	@Pattern (regexp="[^<&&[^>]]*", message="The use of characters < and > is not allowed") //exclude tags from textbox
	private String articolo;
	
	@Column (name="IDArea")
	@NotNull (message="This field can not be empty")
	private int IDArea;
	
	@Column (name="IDCucina")
	@NotNull (message="This field can not be empty")
	private int IDCucina;
	
	@Column (name="IDPrezzo")
	@NotNull (message="This field can not be empty")
	private int IDPrezzo;
	
	@Column (name="IDVoto")
	@NotNull (message="This field can not be empty")
	private int IDVoto;
	
	@Column (name="Foto")
	@NotNull (message="This field can not be empty")
	private String foto;

	
	//CONSTRUCTORS
	
	public Articolo(){
		
	}
	
	public Articolo(int id, 
					String ristorante, 
					Date data, 
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
