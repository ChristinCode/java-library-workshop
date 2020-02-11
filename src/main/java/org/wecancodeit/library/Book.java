package org.wecancodeit.library;

public class Book {
    private String title;
    private String author;
    private int isbn;
    private String description;

    public Book(String title, String author, int isbn, String description) {

        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getDescription() {
        return description;
    }
}
