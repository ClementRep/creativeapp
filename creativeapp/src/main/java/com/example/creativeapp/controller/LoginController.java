package com.example.creativeapp.controller;

import com.example.creativeapp.Book;
import com.example.creativeapp.service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private BookServiceInterface bookService;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, String pass, Model model) {
        List<Book> books = bookService.getAllBooks();

        if (username.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")) {
            model.addAttribute("books", books);
            return "admin-view"; // shows full book info
        } else if (username.equalsIgnoreCase("user") && pass.equalsIgnoreCase("user")) {
            model.addAttribute("titles", books.stream().map(Book::getTitle).toList());
            return "user-view";
        } else {
            return "redirect:/";
        }
    }
}
