package Apidemo.Ohjelmistoprojekti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Apidemo.Ohjelmistoprojekti.domain.*;



@Controller
@ResponseBody 
public class KyselyController {
	@Autowired
	public KyselyRepository repository;

	@Autowired
	public KysymysRepository krepository;
	
	@Autowired
	public VastausRepository vrepository;
	
	
	
	@Autowired
	private PopulateDB populateDb;
	
	    
 
 
	@PostMapping("reset")
	public ResponseEntity<String>  reset() {
		populateDb.populate();
		return ResponseEntity.ok("DB reset done");
	}	
}
