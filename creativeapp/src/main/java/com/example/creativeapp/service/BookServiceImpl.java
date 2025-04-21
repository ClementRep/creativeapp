package com.example.creativeapp.service;

import com.example.creativeapp.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BookServiceImpl implements BookServiceInterface {

  private final Map<String, Book> bookMap = new HashMap<>();

    @Override
    public Book addBook(Book book) {
        bookMap.put(book.getId(), book);
        return book;
    }

    @Override
    public Book getBookById(String id) {
        return bookMap.get(id);
    }

    @Override
    public boolean removeBook(String id) {
        return bookMap.remove(id) != null;
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookMap.values());
    }

    @Override
    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookMap.values()) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
}
