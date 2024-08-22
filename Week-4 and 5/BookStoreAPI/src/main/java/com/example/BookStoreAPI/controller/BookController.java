package com.example.BookStoreAPI.controller;

import com.example.BookStoreAPI.dto.BookDTO;
import com.example.BookStoreAPI.exception.BookNotFoundException;
import com.example.BookStoreAPI.mapper.BookMapper;
import com.example.BookStoreAPI.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {
    private List<Book> bookList = new ArrayList<>();
    @Autowired
    private BookMapper bookMapper;

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookList.stream()
                .map(bookMapper::toBookDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updateBook) {
        Book book = bookList.stream().filter(b -> b.getId() == id).findFirst().orElseThrow(() -> new BookNotFoundException(id));
        if (book != null) {
            book.setTitle(updateBook.getTitle());
            book.setAuthor(updateBook.getAuthor());
            book.setPrice(updateBook.getPrice());
            book.setIsbn(updateBook.getIsbn());
        }
        return book;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Book book = bookList.stream()
                .filter(b -> b.getId() == (id))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException(id));
        bookList.remove(book);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book-Deleted-Successfully");

        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book =  bookList.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException(id));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book-Fetched-Successfully");

        return new ResponseEntity<>(book, headers, HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) String author) {
        return bookList.stream()
                .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                        (author == null || book.getAuthor().equalsIgnoreCase(author)))
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)  // Return 201 Created when a new book is created
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        Book book = bookMapper.toBook(bookDTO);
        bookList.add(book);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book-Created-Successfully");

        return new ResponseEntity<>(bookMapper.toBookDTO(book), headers, HttpStatus.CREATED);
    }
}
