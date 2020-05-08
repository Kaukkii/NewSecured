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
private Long kysymysid;

private String kysymys, KysymysType ,vaihtoehto, vaihtoehto1, vaihtoehto2;





@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
private List<Vastaus> vastaukset;




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

	public Kysymys(String kysymys, String kysymysType) {
		super();
		
		this.kysymys = kysymys;
		KysymysType = kysymysType;
	}

	public Kysymys(String kysymys, String kysymysType, String vaihtoehto, String vaihtoehto1, String vaihtoehto2,
			Kysely kysely) {
		super();
		this.kysymys = kysymys;
		KysymysType = kysymysType;
		this.vaihtoehto = vaihtoehto;
		this.vaihtoehto1 = vaihtoehto1;
		this.vaihtoehto2 = vaihtoehto2;
		this.kysely = kysely;
	}

	public Kysymys(String kysymys, String kysymysType, String vaihtoehto, String vaihtoehto1, Kysely kysely) {
		super();
		this.kysymys = kysymys;
		KysymysType = kysymysType;
		this.vaihtoehto = vaihtoehto;
		this.vaihtoehto1 = vaihtoehto1;
		this.kysely = kysely;
	}

	public Kysymys(String kysymys, String kysymysType, String vaihtoehto, Kysely kysely) {
		super();
		this.kysymys = kysymys;
		KysymysType = kysymysType;
		this.vaihtoehto = vaihtoehto;
		this.kysely = kysely;
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

	public String getVaihtoehto() {
		return vaihtoehto;
	}

	public void setVaihtoehto(String vaihtoehto) {
		this.vaihtoehto = vaihtoehto;
	}

	public String getVaihtoehto1() {
		return vaihtoehto1;
	}

	public void setVaihtoehto1(String vaihtoehto1) {
		this.vaihtoehto1 = vaihtoehto1;
	}

	public String getVaihtoehto2() {
		return vaihtoehto2;
	}

	public void setVaihtoehto2(String vaihtoehto2) {
		this.vaihtoehto2 = vaihtoehto2;
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
	
	
}
