package com.example.demo.exception;

/**
 * Exception to show that a book with the desired id does not exist.
 *
 * @author Vasil
 * @date 2024/04/06
 */
public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(int id) {
        super("Could not find book with id " + id);
    }
}
