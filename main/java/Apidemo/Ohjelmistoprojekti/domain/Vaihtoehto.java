package Apidemo.Ohjelmistoprojekti.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Vaihtoehto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vaihtoehtoId;

    private String vaihtoehto;
    
    @ManyToOne
    //@JsonIgnore
    //@JsonManagedReference
    @JsonBackReference
    @JoinColumn
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vaihtoehto")
    private Kysymys kysymys;

    

    public Vaihtoehto() {

    }



	public Vaihtoehto(String vaihtoehto, Kysymys kysymys) {
		super();
		this.vaihtoehto = vaihtoehto;
		this.kysymys = kysymys;
	}



	public Vaihtoehto(String vaihtoehto) {
		super();
		this.vaihtoehto = vaihtoehto;
	}



	public Long getVaihtoehtoId() {
		return vaihtoehtoId;
	}



	public void setVaihtoehtoId(Long vaihtoehtoId) {
		this.vaihtoehtoId = vaihtoehtoId;
	}



	public String getVaihtoehto() {
		return vaihtoehto;
	}



	public void setVaihtoehto(String vaihtoehto) {
		this.vaihtoehto = vaihtoehto;
	}



	public Kysymys getKysymys() {
		return kysymys;
	}



	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}
    
  
    

}