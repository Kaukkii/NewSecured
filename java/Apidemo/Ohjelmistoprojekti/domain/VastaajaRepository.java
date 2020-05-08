package Apidemo.Ohjelmistoprojekti.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface VastaajaRepository extends CrudRepository<Vastaaja, Long> {
	
	 List<Vastaaja> findByVastaajaName(String vastaajaName);
	}

