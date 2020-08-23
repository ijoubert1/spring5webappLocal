package local.springframework.spring5webapplocal.repositories;

import local.springframework.spring5webapplocal.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository  extends CrudRepository<Author, Long> {
}
