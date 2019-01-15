package py.edu.uca.lp3.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import py.edu.uca.lp3.domain.ExpositorInvestigador;

@RepositoryRestResource(collectionResourceRel = "expositorInvestigador", path = "expositorInvestigador")
public interface ExpositorInvestigadorRepository extends PagingAndSortingRepository<ExpositorInvestigador, Long> {

	List<ExpositorInvestigador> findByNombre(@Param("nombre") String nombre);
	List<ExpositorInvestigador> findByApellido(@Param("apellido") String apellido);
}