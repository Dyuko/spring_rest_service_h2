package py.edu.uca.lp3.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import py.edu.uca.lp3.domain.Factura;

@RepositoryRestResource(collectionResourceRel = "factura", path = "factura")
public interface FacturaRepository extends PagingAndSortingRepository<Factura, Long> {

	List<Factura> findByidEvento(@Param("idEvento") long idEvento);
}