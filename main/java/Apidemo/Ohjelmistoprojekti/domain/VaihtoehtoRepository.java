package Apidemo.Ohjelmistoprojekti.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VaihtoehtoRepository extends CrudRepository<Vaihtoehto, Long> {
	List<Vaihtoehto> findByVaihtoehto(String vaihtoehto);
}