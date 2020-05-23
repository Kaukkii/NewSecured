package Apidemo.Ohjelmistoprojekti.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;



@RestResource
public interface KysymysRepository extends CrudRepository<Kysymys, Long> {
	 List<Kysymys> findByKysymys(String kysymys);
}