package py.edu.uca.lp3.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import py.edu.uca.lp3.domain.ComentarioPregunta;

@RepositoryRestResource(collectionResourceRel = "comentarioPregunta", path = "comentarioPregunta")
public interface ComentarioPreguntaRepository extends PagingAndSortingRepository<ComentarioPregunta, Long> {

	List<ComentarioPregunta> findByDescripcion(@Param("descripcion") String descripcion);

}