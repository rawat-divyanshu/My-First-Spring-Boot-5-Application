package com.rawatdivyanshu.MyFirstSpring5App.Repositories;

import com.rawatdivyanshu.MyFirstSpring5App.Models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
