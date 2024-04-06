package com.example.demo.model;

import java.io.Serializable;

public record QuoteDto(String quote, String author, String category) implements Serializable {
}
