package com.example.creativeapp.service;

import com.example.creativeapp.Book;

import java.util.List;

public interface BookServiceInterface {
    Book addBook(Book book);
    Book getBookById(String id);
    boolean removeBook(String id);
    List<Book> getAllBooks();
    List<Book> searchByTitle(String title);
}
