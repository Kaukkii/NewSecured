package Apidemo.Ohjelmistoprojekti.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vastaaja {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vastaajaID;
    private String vastaajaName;

    //@OneToMany
    //@JsonBackReference
    //@JsonManagedReference
    //private List<Answer> answerList;

    public Vastaaja(List<Vastaus> vastaukset) {
        //this.answerList = answers;
    }

    public Vastaaja() {}
    
    

	public Vastaaja(String vastaajaName) {
		super();
		this.vastaajaName = vastaajaName;
	}

	public Long getVastaajaID() {
		return vastaajaID;
	}

	public void setVastaajaID(Long vastaajaID) {
		this.vastaajaID = vastaajaID;
	}

	public String getVastaajaName() {
		return vastaajaName;
	}

	public void setVastaajaName(String vastaajaName) {
		this.vastaajaName = vastaajaName;
	}
	

/*	public List<Answer> getAnswerList() {
		return answerList;
	} 
	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
    
*/    

}