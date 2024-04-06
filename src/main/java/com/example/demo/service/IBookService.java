package com.example.demo.service;

import com.example.demo.model.BookDto;

import java.util.List;

/**
 * Interface defining the possible operations with the {@link BookDto} object
 *
 * @author Vasil
 * @date 2024/04/06
 */
public interface IBookService {

    /**
     * Loads all available books
     *
     * @return List<Book> get all books
     */
    List<BookDto> getAllBooks();

    /**
     * get book by id
     *
     * @param id the id
     * @return Book get book by id
     */
    BookDto getBookById(int id);

    /**
     * get books by title
     *
     * @param title the title
     * @return List<Book> get books by title
     */
    List<BookDto> getBooksByTitle(String title);

    /**
     * add book
     *
     * @param book the book
     * @return Book add book
     */
    BookDto saveBook(BookDto book);

    /**
     * update book
     *
     * @param book the book
     * @param id   the id
     * @return Book update book
     */
    BookDto updateBook(BookDto book, int id);

    /**
     * delete book
     *
     * @param id the id
     */
    void deleteBook(int id);
}
