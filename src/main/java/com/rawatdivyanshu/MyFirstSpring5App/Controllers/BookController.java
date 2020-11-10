package com.rawatdivyanshu.MyFirstSpring5App.Controllers;

import com.rawatdivyanshu.MyFirstSpring5App.Repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getBooks(Model model) {

        model.addAttribute("books",bookRepository.findAll());

        return "books/list";
    }
}
