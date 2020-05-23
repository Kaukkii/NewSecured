package Apidemo.Ohjelmistoprojekti.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;




@RestResource
public interface VastausRepository extends CrudRepository<Vastaus, Long> {
	List<Vastaus> findByVastaus(String vastaaja);
	
	List<Vastaus> findByvastaus(@Param("vastaus") String Vastaus);
	
}