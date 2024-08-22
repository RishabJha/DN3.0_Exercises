package com.example.BookStoreAPI.mapper;

import com.example.BookStoreAPI.dto.BookDTO;
import com.example.BookStoreAPI.dto.CustomerDTO;
import com.example.BookStoreAPI.model.Book;
import com.example.BookStoreAPI.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toBookDTO(Book book);
    Book toBook(BookDTO bookDTO);
}

