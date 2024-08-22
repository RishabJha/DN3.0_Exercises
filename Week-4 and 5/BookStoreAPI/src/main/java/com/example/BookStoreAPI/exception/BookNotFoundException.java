package com.example.BookStoreAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Book not found")
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id) {
        super("Book not found with id: " + id);
    }
}
