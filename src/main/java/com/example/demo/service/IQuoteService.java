package com.example.demo.service;

/**
 * Defines the actions related to quotes for the {@link com.example.demo.model.BookDto}
 *
 * @author Vasil
 * @date 2024/04/06
 */
public interface IQuoteService {

    /**
     * Generated random quote as {@link String}.
     *
     * @return String get quote
     */
    String getQuote();
}
