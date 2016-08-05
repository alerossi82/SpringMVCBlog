package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Prezzo")
public class Prezzo {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="ID")
	private int ID;
	
	@Column (name="Nome")
	private String nome;
	
	
	//ACCESSORS
	public int getID(){
		return ID;
	}
	
	public void setID (int iD){
		this.ID=iD;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}

}
