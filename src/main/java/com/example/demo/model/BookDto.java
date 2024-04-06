package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.example.demo.entity.BookEntity}
 */
@Data
public class BookDto implements Serializable {
    String title;
    String description;
    String quote;
    List<AuthorDto> authors;
}