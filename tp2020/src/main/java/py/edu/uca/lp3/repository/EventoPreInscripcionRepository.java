package py.edu.uca.lp3.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import py.edu.uca.lp3.domain.EventoPreInscripcion;

@RepositoryRestResource(collectionResourceRel = "eventoPreInscripcion", path = "eventoPreInscripcion")
public interface EventoPreInscripcionRepository extends PagingAndSortingRepository<EventoPreInscripcion, Long> {

	List<EventoPreInscripcion> findByDescripcion(@Param("descripcion") String descripcion);

}