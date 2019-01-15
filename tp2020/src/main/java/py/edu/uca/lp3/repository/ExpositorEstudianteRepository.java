package py.edu.uca.lp3.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import py.edu.uca.lp3.domain.ExpositorEstudiante;

@RepositoryRestResource(collectionResourceRel = "expositorEstudiante", path = "expositorEstudiante")
public interface ExpositorEstudianteRepository extends PagingAndSortingRepository<ExpositorEstudiante, Long> {

	List<ExpositorEstudiante> findByNombre(@Param("nombre") String nombre);
	List<ExpositorEstudiante> findByApellido(@Param("apellido") String apellido);
}