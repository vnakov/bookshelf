package com.example.demo.repository;

import com.example.demo.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The book repository
 *
 * @author Vasil
 * @date 2024/04/06
 */
public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    /**
     * Loads all books containing the received title
     *
     * @param title the title
     * @return List<Book> find by title
     */
    List<BookEntity> findByTitleContaining(String title);
}