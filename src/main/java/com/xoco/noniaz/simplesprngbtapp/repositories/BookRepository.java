package com.xoco.noniaz.simplesprngbtapp.repositories;

import com.xoco.noniaz.simplesprngbtapp.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
