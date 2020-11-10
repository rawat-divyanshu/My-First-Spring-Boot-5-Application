package com.rawatdivyanshu.MyFirstSpring5App.Bootstrap;

import com.rawatdivyanshu.MyFirstSpring5App.Models.Author;
import com.rawatdivyanshu.MyFirstSpring5App.Models.Book;
import com.rawatdivyanshu.MyFirstSpring5App.Models.Publisher;
import com.rawatdivyanshu.MyFirstSpring5App.Repositories.AuthorRepository;
import com.rawatdivyanshu.MyFirstSpring5App.Repositories.BookRepository;
import com.rawatdivyanshu.MyFirstSpring5App.Repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher bluehole = new Publisher();
        bluehole.setName("Bluehole");
        bluehole.setAddressLine1("Sector 7");
        bluehole.setCity("Jaipur");

        publisherRepository.save(bluehole);

        System.out.println("Publisher Count : " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        ddd.setPublisher(bluehole);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        bluehole.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        noEJB.setPublisher(bluehole);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        bluehole.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Books Count : " + bluehole.getBooks().size());
    }
}