package com.example.demo.model;

import java.io.Serializable;

/**
 * DTO for {@link com.example.demo.entity.AuthorEntity}
 */
public record AuthorDto(Integer id, String firstName, String lastName) implements Serializable {
}