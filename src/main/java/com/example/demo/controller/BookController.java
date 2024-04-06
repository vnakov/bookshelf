package com.example.demo.controller;

import com.example.demo.model.BookDto;
import com.example.demo.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API Controller handling the CRUD operations for books
 *
 * @author Vasil
 * @date 2024/04/06
 */
@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class BookController {

    private final IBookService bookService;

    /**
     * get all books
     *
     * @return List<Book> get all books
     */
    @GetMapping("/books")
    @ResponseBody
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    /**
     * get book by id
     *
     * @param id the id
     * @return Book get book by id
     */
    @GetMapping("/books/id/{id}")
    @ResponseBody
    public BookDto getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    /**
     * get books by title
     *
     * @param title the title
     * @return List<Book> get books by title
     */
    @GetMapping("/books/title/{title}")
    @ResponseBody
    public List<BookDto> getBooksByTitle(@PathVariable String title) {
        return bookService.getBooksByTitle(title);
    }

    /**
     * create book
     *
     * @param book the book
     * @return Book create book
     */
    @PostMapping("/books")
    public BookDto createBook(@RequestBody BookDto book) {
        return bookService.saveBook(book);
    }

    /**
     * update book by id
     *
     * @param book the book
     * @param id   the id
     * @return Book update book
     */
    @PutMapping("/books/{id}")
    public BookDto updateBook(@RequestBody BookDto book, @PathVariable int id) {
        return bookService.updateBook(book, id);
    }

    /**
     * delete  by id
     *
     * @param id the id
     */
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }

}
