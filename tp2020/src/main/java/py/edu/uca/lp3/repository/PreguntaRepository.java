package py.edu.uca.lp3.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import py.edu.uca.lp3.domain.Pregunta;

@RepositoryRestResource(collectionResourceRel = "pregunta", path = "pregunta")
public interface PreguntaRepository extends PagingAndSortingRepository<Pregunta, Long> {

	List<Pregunta> findByDescripcion(@Param("descripcion") String descripcion);
	//List<Pregunta> findByFecha(@Param("fechaEnvio") String fechaEnvio);

}