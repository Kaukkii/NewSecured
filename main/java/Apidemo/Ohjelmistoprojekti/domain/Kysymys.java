package Apidemo.Ohjelmistoprojekti.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Kysymys {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long kysymysid;

private String kysymys, KysymysType;





@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
private List<Vastaus> vastaukset;


@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
@JsonManagedReference
//@JsonBackReference
private List<Vaihtoehto> vaihtoehto;



@ManyToOne
//@JsonManagedReference //Critical for stopping endless looping
@JsonBackReference
@JoinColumn
private Kysely kysely;






	public Kysymys() {
		// TODO Auto-generated constructor stub
	}
	public Kysymys(String kysymys, String kysymysType, Kysely kysely) {
		super();
		this.kysymys = kysymys;
		KysymysType = kysymysType;
		this.kysely = kysely;
	}

	

public Kysymys(String kysymys, String kysymysType, Vaihtoehto vaihtoehdot) {
		super();
		this.kysymys = kysymys;
		KysymysType = kysymysType;
		
	}

public Kysymys(String kysymys, String kysymysType, List<Vaihtoehto> vaihtoehto) {
		super();
		this.kysymys = kysymys;
		KysymysType = kysymysType;
		this.vaihtoehto = vaihtoehto;
	}





	public long getKysymysID() {
		return kysymysid;
	}

	public void setKysymysID(long kysymysid) {
		this.kysymysid = kysymysid;
	}

	public String getKysymys() {
		return kysymys;
	}

	public void setKysymys(String Kysymys) {
		kysymys = Kysymys;
	}

	public String getKysymysType() {
		return KysymysType;
	}

	public void setKysymysType(String kysymysType) {
		KysymysType = kysymysType;
	}



	public Kysely getKysely() {
		return kysely;
	}

	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}


	public List<Vastaus> getVastaukset() {
		return vastaukset;
	}


	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}
	
	public List<Vaihtoehto> getVaihtoehto() {
		return vaihtoehto;
	}
	
	public void setVaihtoehto(List<Vaihtoehto> vaihtoehto) {
		this.vaihtoehto = vaihtoehto;
	}
	
	
	public void setVaihtoehto(String vaihtoehto) {
    	this.vaihtoehto.add(new Vaihtoehto(vaihtoehto));
	}

	
	
}
