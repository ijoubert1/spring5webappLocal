package local.springframework.spring5webapplocal.repositories;

import local.springframework.spring5webapplocal.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
