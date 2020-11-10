package com.rawatdivyanshu.MyFirstSpring5App.Repositories;

import com.rawatdivyanshu.MyFirstSpring5App.Models.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
