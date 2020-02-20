package org.wecancodeit.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.library.models.Book;
import org.wecancodeit.library.storage.BookStorage;

@Controller
public class BookController {
    private final BookStorage bookStorage;

    public BookController(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

    @RequestMapping("/books/{id}")
    public String displayBook(@PathVariable Long id, Model model) {
        Book retrievedBook = bookStorage.findBookById(id);
        model.addAttribute("book", retrievedBook);
        return "book-view";
    }
}
