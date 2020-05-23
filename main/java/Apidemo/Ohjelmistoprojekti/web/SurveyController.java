package Apidemo.Ohjelmistoprojekti.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Apidemo.Ohjelmistoprojekti.domain.*;


@Controller
public class SurveyController {

	  
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }

    @Autowired
    private KyselyRepository kyselyRepository;
    
    @Autowired
    private VaihtoehtoRepository vaihrepository;
    
  
    //Hakee kyselylistan ja näyttää sen
    @RequestMapping(value = "/kyselylista", method = RequestMethod.GET)
    public String surveyList(Model model) {
        model.addAttribute("kyselylista", kyselyRepository.findAll());
        return "kyselylista"; 
    }

   //Lisää kyselyn
    @RequestMapping(value = "/addkysely", method = RequestMethod.GET)
    public String addKysely(Model model) {
        model.addAttribute("kysely", new Kysely());
        return "addkysely";
    }

   //Tallentaa sen
    @RequestMapping(value = "/savekysely", method = RequestMethod.POST)
    public String saveQuestion(Kysely kysely) {
        kyselyRepository.save(kysely);
        return "redirect:kyselylista"; 
    }
    
    //poistaa kyselyn
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/deletekysely/{id}", method = RequestMethod.GET)
  	public String DeleteKysely(@PathVariable("id") Long kyselyid, Model model) {
  		kyselyRepository.deleteById(kyselyid);
  		return "redirect:../kyselylista";
  	}
    
    //Muokkaa kyselyä
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/editkysely/{id}", method = RequestMethod.GET)
  	public String editKysely(@PathVariable("id") Long kyselyId, Model model) {
  		
  		model.addAttribute("kysely", kyselyRepository.findById(kyselyId));
  		
  		return "editkysely";
  	}
    
    
 
    //rest endpoint reactille haettavaksi
    @CrossOrigin
    @RequestMapping(value = "/kyselylist", method = RequestMethod.GET) 
    public @ResponseBody List<Kysely> kyselyt() {
        return (List<Kysely>) kyselyRepository.findAll();
    }
    //Id:llä maustettu endpoint reactilla haettavaksi
    @CrossOrigin
    @RequestMapping(value = "/kyselylist/{id}", method = RequestMethod.GET) 
    public @ResponseBody Optional <Kysely> kyselytById(@PathVariable Long id) {
        return kyselyRepository.findById(id);
    }
    
    
    @Autowired
    private KysymysRepository kysymysRepository;

   

    //etusivu
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index"; 
    }

   //Hakee kysymykset
    @RequestMapping(value = "/kysymyslista", method = RequestMethod.GET)
    public String kysymysList(Model model) {
        model.addAttribute("kysymysLista", kysymysRepository.findAll());
        model.addAttribute("vaihtoehdot", vaihrepository.findAll());
        return "kysymyslista"; 
    }

    //lisää kysymyksen
    @RequestMapping(value = "/addkysymys", method = RequestMethod.GET)
    public String addKysymys(Model model) {
        model.addAttribute("kysymys", new Kysymys());
        model.addAttribute("kyselyt", kyselyRepository.findAll());
        return "addkysymys"; 
    }

   //tallentaa kysymyksen
    @RequestMapping(value = "/savekysymys", method = RequestMethod.POST)
    public String saveKysymys(Kysymys kysymys, Kysely kysely) {
        kysymysRepository.save(kysymys);
        kyselyRepository.save(kysely);
        return "redirect:kysymyslista"; 
    }
    
    //poistaa kysymyksen
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String DeleteKysymys(@PathVariable("id") Long Kysymysid, Model model) {
		kysymysRepository.deleteById(Kysymysid);
		return "redirect:../kysymyslista";
	}
    //muokkaa kysymystä
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editKysymys(@PathVariable("id") Long kysymysID, Model model) {
	
		model.addAttribute("kysymys", kysymysRepository.findById(kysymysID));
		model.addAttribute("kysely", kyselyRepository.findAll());
		return "editkysymys";
	}


    
    //hakee kysymykset suojauksen ulkopuolella 
    @CrossOrigin
    @RequestMapping(value = "/kysymykset", method = RequestMethod.GET) 
    public @ResponseBody List<Kysymys> kysymykset() {
        return (List<Kysymys>) kysymysRepository.findAll();
    }
    
     //hakee kysymykset id:llä
  	@CrossOrigin
  	@RequestMapping(value = "/kysymykset/{id}", method = RequestMethod.GET)
  	public @ResponseBody Optional <Kysymys> findKysymysRest(@PathVariable Long id) { 
  		return kysymysRepository.findById(id); 
  	}
  	
  	@Autowired
    private VastausRepository vastausRepository;
  	
  //Hakee vastaukset
    @RequestMapping(value = "/vastauslista", method = RequestMethod.GET)
    public String vastausList(Model model) {
        model.addAttribute("vastausLista", vastausRepository.findAll());
        return "vastauslista"; 
    }
	
  	 @RequestMapping(value = "/vastaukset", method = RequestMethod.GET) 
     public @ResponseBody List<Vastaus> vastaus() {
         return (List<Vastaus>) vastausRepository.findAll();
     }
  
  	//Hakee Vaihtoehtoja
     @RequestMapping(value = "/vaihtoehtolista", method = RequestMethod.GET)
     public String VaihtoehtoList(Model model) {
         model.addAttribute("kysymysLista", kysymysRepository.findAll());
         model.addAttribute("vaihtoehdot", vaihrepository.findAll());
         return "vaihtoehtolista"; 
     }

   //lisää vaihtoehdon
     @RequestMapping(value = "/addvaihtoehto", method = RequestMethod.GET)
     public String addVaihtoehto(Model model) {
         model.addAttribute("vaihtoehto", new Vaihtoehto());
         model.addAttribute("kysymykset", kysymysRepository.findAll());
         return "addvaihtoehto"; 
     }

    //tallentaa vaihtoehdon
     @RequestMapping(value = "/savevaihtoehto", method = RequestMethod.POST)
     public String saveVaihtoehto(Vaihtoehto vaihtoehto,  Kysymys kysymys) {
         vaihrepository.save(vaihtoehto);
         kysymysRepository.save(kysymys);
         return "redirect:vaihtoehtolista"; 
     }
  	 
     @PreAuthorize("hasAuthority('ADMIN')")
     @RequestMapping(value = "/deletevaihtoehto/{id}", method = RequestMethod.GET)
 	public String DeleteVaihtoehto(@PathVariable("id") Long vaihtoehtoid, Model model) {
 		vaihrepository.deleteById(vaihtoehtoid);
 		return "redirect:../vaihtoehtolista";
 	}
  	 
  	 
}




