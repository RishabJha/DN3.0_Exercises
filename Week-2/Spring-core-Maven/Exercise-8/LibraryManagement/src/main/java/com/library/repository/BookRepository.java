package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void printRepository() {
        System.out.println("Printing class BookRepository...");
    }
}
