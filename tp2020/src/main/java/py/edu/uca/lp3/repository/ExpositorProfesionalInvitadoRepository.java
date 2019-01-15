package py.edu.uca.lp3.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import py.edu.uca.lp3.domain.ExpositorProfesionalInvitado;

@RepositoryRestResource(collectionResourceRel = "expositorProfesionalInvitado", path = "expositorProfesionalInvitado")
public interface ExpositorProfesionalInvitadoRepository extends PagingAndSortingRepository<ExpositorProfesionalInvitado, Long> {

	List<ExpositorProfesionalInvitado> findByNombre(@Param("nombre") String nombre);
	List<ExpositorProfesionalInvitado> findByApellido(@Param("apellido") String apellido);
}