package py.edu.uca.lp3.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import py.edu.uca.lp3.domain.EventoLibreAcceso;

@RepositoryRestResource(collectionResourceRel = "eventoLibreAcceso", path = "eventoLibreAcceso")
public interface EventoLibreAccesoRepository extends PagingAndSortingRepository<EventoLibreAcceso, Long> {

	List<EventoLibreAcceso> findByDescripcion(@Param("descripcion") String descripcion);

}