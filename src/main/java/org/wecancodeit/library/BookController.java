package org.wecancodeit.library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class BookController {

    private final HashMap<Integer, Book> booksList;

    public BookController() {
        booksList = new HashMap<>();
        Book book1 = new Book("MVC is almost fun", "Ben", 1909123456,"No really, it's kinda fun.");
        Book book2 = new Book("MVC is Evil", "Spring Cohort", 1909123457,"Why?");
        Book book3 = new Book("Head First Java", "Kathy Sierra", 1909123458,"It's kinda fun.");

        Book book4 = new Book("Head First Desgin Patterns", "Kathy Sierra", 1909123468,"It's kinda fun.");
        booksList.put(book1.getIsbn(),book1);
        booksList.put(book2.getIsbn(), book2);
        booksList.put(book3.getIsbn(), book3);
        booksList.put(book4.getIsbn(), book4);
    }

    @RequestMapping("/book/{isbn}")
    public String singleBookView(@PathVariable int isbn, Model model){
        Book book = booksList.get(isbn);
        model.addAttribute("book", book);
        return "book";
    }
    @RequestMapping("/books")
    public String allTheBooks(Model model){
        model.addAttribute("booksAttribute", booksList.values());
        return "library";
    }
}
