package Apidemo.Ohjelmistoprojekti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vastaus {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long vastausID;

private String vastaaja, vastaus;

@ManyToOne
@JoinColumn(name = "kysymysid")


private Kysymys kysymys;



	public Vastaus() {
		// TODO Auto-generated constructor stub
	}


	public Vastaus(String vastaaja, String vastaus,  Kysymys kysymys) {
		super();
		this.vastaaja = vastaaja;
		this.vastaus = vastaus;
		this.kysymys = kysymys;
	}
	

	
	public Vastaus(String vastaaja, String vastaus) {
		super();
		this.vastaaja = vastaaja;
		this.vastaus = vastaus;
		
	}


	


	public Long getVastausID() {
		return vastausID;
	}


	public void setVastausID(Long vastausID) {
		this.vastausID = vastausID;
	}


	public String getVastaaja() {
		return vastaaja;
	}


	public void setVastaaja(String vastaaja) {
		this.vastaaja = vastaaja;
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
