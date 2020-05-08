package Apidemo.Ohjelmistoprojekti.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Kysely {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long KyselyID;
	private String kyselyName, KyselyDesc;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysely")
	@JsonIgnore
	@JsonManagedReference
	private List<Kysymys> kysymykset;
	
	public Kysely() {
	}


	public Kysely(String kyselyName, String kyselyDesc) {
		super();
		this.kyselyName = kyselyName;
		KyselyDesc = kyselyDesc;
	}
	
	public Kysely(String kyselyName) {
		this.kyselyName = kyselyName;
	}

	public long getKyselyID() {
		return KyselyID;
	}


	public void setKyselyID(long kyselyID) {
		KyselyID = kyselyID;
	}


	public String getKyselyName() {
		return kyselyName;
	}


	public void setKyselyName(String kyselyName) {
		this.kyselyName = kyselyName;
	}


	public String getKyselyDesc() {
		return KyselyDesc;
	}


	public void setKyselyDesc(String kyselyDesc) {
		KyselyDesc = kyselyDesc;
	}


	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}


	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}
	
	@Override
	public String toString() {
		return kyselyName;
	}
	
	
	
}