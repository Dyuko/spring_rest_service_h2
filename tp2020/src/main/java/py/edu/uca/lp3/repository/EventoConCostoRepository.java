package py.edu.uca.lp3.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import py.edu.uca.lp3.domain.EventoConCosto;

@RepositoryRestResource(collectionResourceRel = "eventoConCosto", path = "eventoConCosto")
public interface EventoConCostoRepository extends PagingAndSortingRepository<EventoConCosto, Long> {

	List<EventoConCosto> findByDescripcion(@Param("descripcion") String descripcion);

}