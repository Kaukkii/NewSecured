package Apidemo.Ohjelmistoprojekti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import Apidemo.Ohjelmistoprojekti.domain.*;



@SpringBootApplication
public class OhjelmistoprojektiApplication {

	private static final Logger log = LoggerFactory.getLogger(OhjelmistoprojektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OhjelmistoprojektiApplication.class, args);
	}
	@Bean
	
	public CommandLineRunner demo(UserRepository urepository, KyselyRepository repository, KysymysRepository krepository, VastausRepository vrepository) {
		return (args) -> {
			
			repository.deleteAll();
			krepository.deleteAll();
			vrepository.deleteAll();
			
			
			//Uusi Kysely
			repository.save(new Kysely("Hyvinvointi kysely", "Kysely ihmisen hyvinvoinnista."));
			
			
			
			
			for (Kysely survey : repository.findAll()) {
				log.info(survey.toString());
			}
			
			//Kysymyksiä kyselyyn
			krepository.save(new Kysymys("Nimi?", "Teksti",  repository.findByKyselyName("Hyvinvointi kysely").get(0)));
			
			krepository.save(new Kysymys("Sukupuoli?", "Monivalinta", "Nainen", "Mies", "Muu/En halua vastata", repository.findByKyselyName("Hyvinvointi kysely").get(0)));
			
			
			krepository.save(new Kysymys("Kuinka hyvin hallitset stressiä?", "Teksti",  repository.findByKyselyName("Hyvinvointi kysely").get(0)));
			
			for (Kysymys k : krepository.findAll()) {
				log.info(k.toString());
			}
			
			Vastaaja vastaaja = new Vastaaja();
			
			vrepository.save(new Vastaus(vastaaja, "Huonosti", krepository.findByKysymys("Kuinka hyvin hallitset stressiä?").get(0)));
			
			for (Vastaus v : vrepository.findAll()) {
				log.info(v.toString());
			}
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			
			urepository.save(user1);
			urepository.save(user2);
			
			
			
			
		};}
	

	



}
//Haetaan kaikki repositoryt
	
		
		
			
