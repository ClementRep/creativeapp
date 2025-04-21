package com.example.creativeapp.controller;

import com.example.creativeapp.Book;
import com.example.creativeapp.service.BookServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookServiceInterface bookService;

    public BookController(BookServiceInterface bookService){
        this.bookService=bookService;
    }

    @GetMapping
    public List<Book> getAll(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getByid(@PathVariable String id){
        return bookService.getBookById(id);
    }

    @RequestMapping("/Addbook")
    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public String removeBook(@PathVariable String id){
        boolean removed = bookService.removeBook(id);
        return removed ? " Book removed successfully":
                "Book not found" ;
    }

    @GetMapping("/search")
        public List<Book> search (@RequestParam String title){
            return bookService.searchByTitle(title);
        }
    }

