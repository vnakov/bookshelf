package com.example.demo.controller.advice;

import com.example.demo.exception.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controller advice handling the error possible to occur while working with the {@link com.example.demo.controller.BookController}
 *
 * @author Vasil
 * @date 2024/04/06
 */
@ControllerAdvice
public class BookControllerAdvice {

    @ResponseBody
    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(BookNotFoundException ex) {
        return ex.getMessage();
    }
}
