package Apidemo.Ohjelmistoprojekti.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;






@Component
public class PopulateDB {
	
	@Autowired
	private KyselyRepository repository; 
	@Autowired
	private KysymysRepository krepository;
	@Autowired
	private VastausRepository vrepository;
	@Autowired
	private UserRepository urepository;
	
	public void populate() {
		repository.deleteAll();
		krepository.deleteAll();
		vrepository.deleteAll();
		
		
		//Uusi Kysely
		repository.save(new Kysely("Hyvinvointi kysely", "Kysely ihmisen hyvinvoinnista."));
		
		
		//Kysymyksiä kyselyyn
		krepository.save(new Kysymys("Nimi?", "Teksti",  repository.findByKyselyName("Hyvinvointi kysely").get(0)));
		
		krepository.save(new Kysymys("Sukupuoli?", "Monivalinta", "Nainen", "Mies", "Muu/En halua vastata", repository.findByKyselyName("Hyvinvointi kysely").get(0)));
		
		
		krepository.save(new Kysymys("Kuinka hyvin hallitset stressiä?", "Teksti",  repository.findByKyselyName("Hyvinvointi kysely").get(0)));
		
		
		
		
		vrepository.save(new Vastaus("Kiia", "Huonosti", krepository.findByKysymys("Kuinka hyvin hallitset stressiä?").get(0)));
		
		
		User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
		
		urepository.save(user1);
		urepository.save(user2);
		
		
		
	
		
		
	}
}