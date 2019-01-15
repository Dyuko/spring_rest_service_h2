package py.edu.uca.lp3.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import py.edu.uca.lp3.domain.ExpositorProfesor;

@RepositoryRestResource(collectionResourceRel = "expositorProfesor", path = "expositorProfesor")
public interface ExpositorProfesorRepository extends PagingAndSortingRepository<ExpositorProfesor, Long> {

	List<ExpositorProfesor> findByNombre(@Param("nombre") String nombre);
	List<ExpositorProfesor> findByApellido(@Param("apellido") String apellido);
}