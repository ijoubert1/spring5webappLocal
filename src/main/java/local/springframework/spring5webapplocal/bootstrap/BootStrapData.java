package local.springframework.spring5webapplocal.bootstrap;

import local.springframework.spring5webapplocal.domain.Author;
import local.springframework.spring5webapplocal.domain.Book;
import local.springframework.spring5webapplocal.domain.Publisher;
import local.springframework.spring5webapplocal.repositories.AuthorRepository;
import local.springframework.spring5webapplocal.repositories.BookRepository;
import local.springframework.spring5webapplocal.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started Bootstrap");

        Publisher pub = new Publisher("Main Editorial", "Belgrano", "CABA", "DF", 1428);
        publisherRepository.save(pub);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "12345");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(pub);
        pub.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(pub);


        Author rod = new Author("Rod", "Jhonson");
        Book noEJB = new Book("J2EE Development without EJB", "98765");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(pub);
        pub.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(pub);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Publisher Number of Books: " + pub.getBooks().size());
    }
}
