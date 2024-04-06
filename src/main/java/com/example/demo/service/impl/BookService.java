package com.example.demo.service.impl;

import com.example.demo.entity.BookEntity;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.mapper.AuthorMapper;
import com.example.demo.mapper.BookMapper;
import com.example.demo.model.BookDto;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.IBookService;
import com.example.demo.service.IQuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The implementation of the defined operations with the {@link BookEntity} object
 *
 * @author Vasil
 * @date 2024/04/06
 */
@Service
@RequiredArgsConstructor
public class BookService implements IBookService {

    private final BookMapper bookMapper;
    private final AuthorMapper authorMapper;
    private final BookRepository bookRepository;
    private final IQuoteService quoteService;

    @Override
    public List<BookDto> getAllBooks() {
        return bookMapper.toDtoList(bookRepository.findAll());
    }

    @Override
    public BookDto getBookById(int id) {
        BookDto bookDto = bookMapper.toDto(bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id)));
        bookDto.setQuote(quoteService.getQuote());
        return bookDto;
    }

    @Override
    public BookDto saveBook(BookDto book) {
        return bookMapper.toDto(bookRepository.saveAndFlush(bookMapper.toEntity(book)));
    }

    @Override
    public List<BookDto> getBooksByTitle(String title) {
        List<BookDto> bookDtos = bookMapper.toDtoList(bookRepository.findByTitleContaining(title));
        bookDtos.forEach(bookDto -> bookDto.setQuote(quoteService.getQuote()));
        return bookDtos;
    }

    @Override
    public BookDto updateBook(BookDto book, int id) {
        return bookMapper.toDto(bookRepository.findById(id)
                .map(dbBook -> {
                    dbBook.setDescription(book.getDescription());
                    dbBook.setTitle(book.getTitle());
                    dbBook.setAuthors(authorMapper.toEntityList(book.getAuthors()));
                    return bookRepository.save(dbBook);
                }).orElseThrow(() -> new BookNotFoundException(id)));
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

}
