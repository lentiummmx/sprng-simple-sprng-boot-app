package com.xoco.noniaz.simplesprngbtapp.controllers;

import com.xoco.noniaz.simplesprngbtapp.entities.Book;
import com.xoco.noniaz.simplesprngbtapp.exceptions.BookIdMismatchException;
import com.xoco.noniaz.simplesprngbtapp.exceptions.BookNotFoundException;
import com.xoco.noniaz.simplesprngbtapp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Iterable<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List<Book> findByTitle(@PathVariable String bookTitle) {
        return bookService.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id) {
        return bookService.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.findById(id).orElseThrow(BookNotFoundException::new);
        bookService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        if (book.getId() != id) {
            throw new BookIdMismatchException();
        }
        bookService.findById(id).orElseThrow(BookNotFoundException::new);
        return bookService.save(book);
    }
}
