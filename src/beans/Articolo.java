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
import javax.validation.constraints.Size;

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
	@Temporal (TemporalType.DATE) //date format used in SQL
	//@IsValidDate //check date format is dd/MM/yyyy (custom validator)
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date data;
	
	@Column (name="Articolo")
	@NotEmpty (message="Article text can not be empty")
	@Pattern (regexp="[^<&&[^>]]*", message="The use of characters < and > is not allowed") //exclude tags from textbox
	private String articolo;
	
	@Column (name="IDArea")
	@NotNull (message="This field can not be empty")
	private Integer IDArea;
	
	@Column (name="IDCucina")
	@NotNull (message="This field can not be empty")
	private Integer IDCucina;
	
	@Column (name="IDPrezzo")
	@NotNull (message="This field can not be empty")
	private Integer IDPrezzo;
	
	@Column (name="IDVoto")
	@NotNull (message="This field can not be empty")
	private Integer IDVoto;
	
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
					Integer iDArea, 
					Integer iDCucina, 
					Integer iDPrezzo,
					Integer iDVoto, 
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

	public Integer getIDArea() {
		return IDArea;
	}

	public void setIDArea(Integer iDArea) {
		IDArea = iDArea;
	}

	public Integer getIDCucina() {
		return IDCucina;
	}

	public void setIDCucina(Integer iDCucina) {
		IDCucina = iDCucina;
	}

	public Integer getIDPrezzo() {
		return IDPrezzo;
	}

	public void setIDPrezzo(Integer iDPrezzo) {
		IDPrezzo = iDPrezzo;
	}

	public Integer getIDVoto() {
		return IDVoto;
	}

	public void setIDVoto(Integer iDVoto) {
		IDVoto = iDVoto;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
