package local.springframework.spring5webapplocal.repositories;

import local.springframework.spring5webapplocal.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
