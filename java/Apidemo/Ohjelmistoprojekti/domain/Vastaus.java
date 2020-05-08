package Apidemo.Ohjelmistoprojekti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Vastaus {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long vastausID;

private String vastaus;

@ManyToOne
@JoinColumn(name = "kysymysid")

@JsonBackReference
private Kysymys kysymys;




	public Vastaus() {
		// TODO Auto-generated constructor stub
	}


	public Vastaus(Vastaaja vastaaja, String vastaus,  Kysymys kysymys) {
		super();
		
		this.vastaus = vastaus;
		this.kysymys = kysymys;
	}
	

	
	


	


	public Long getVastausID() {
		return vastausID;
	}


	public void setVastausID(Long vastausID) {
		this.vastausID = vastausID;
	}


	




	public String getVastaus() {
		return vastaus;
	}


	public void setVastaus(String vastaus) {
		this.vastaus = vastaus;
	}


	public Kysymys getKysymys() {
		return kysymys;
	}


	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}


	
	

}
