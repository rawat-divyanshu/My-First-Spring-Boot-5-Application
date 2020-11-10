package com.rawatdivyanshu.MyFirstSpring5App.Repositories;

import com.rawatdivyanshu.MyFirstSpring5App.Models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
