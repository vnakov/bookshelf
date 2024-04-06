package com.example.demo.init;

import com.example.demo.entity.AuthorEntity;
import com.example.demo.entity.BookEntity;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class LoadDatabaseData {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabaseData.class);

    @Bean
    CommandLineRunner initDatabase(BookRepository bookRepository, AuthorRepository authorRepository) {

        return args -> {
            if (authorRepository.findAll().isEmpty() && bookRepository.findAll().isEmpty()) {
                AuthorEntity author = AuthorEntity.builder().firstName("Bilbo").lastName("Baggins").dateOfBirth(new Date()).build();
                log.info("Preloading author " + authorRepository.save(author));
                log.info("Preloading " + bookRepository.save(
                        BookEntity.builder().title("Lord of the rings 1").description("burglar").authors(List.of(author))
                                .build()));
            }
        };
    }

}
