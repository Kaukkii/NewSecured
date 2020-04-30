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
	
	public CommandLineRunner demo(PopulateDB populateDb) {
		return (args) -> {
			populateDb.populate();
		};}
	

	



}
//Haetaan kaikki repositoryt
	
		
		
			
