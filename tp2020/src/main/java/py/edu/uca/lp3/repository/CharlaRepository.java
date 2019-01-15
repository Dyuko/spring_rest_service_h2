package py.edu.uca.lp3.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import py.edu.uca.lp3.domain.Charla;

@RepositoryRestResource(collectionResourceRel = "charla", path = "charla")
public interface CharlaRepository extends PagingAndSortingRepository<Charla, Long> {

	List<Charla> findByDescripcion(@Param("descripcion") String descripcion);

}