package com.xoco.noniaz.simplesprngbtapp.services;

import com.xoco.noniaz.simplesprngbtapp.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findByTitle(String title);

    Iterable<Book> findAll();

    Optional<Book> findById(Long id);

    Book save(Book book);

    void deleteById(Long id);
}
