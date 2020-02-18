package org.wecancodeit.library;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String author;
    @ManyToOne
    private Campus campus;
    private String title;

    public Book(String title, String author, Campus campus) {

        this.title = title;
        this.author = author;
        this.campus =campus;
    }
    public Book(){}
    public String getAuthor() {
        return author;
    }

    public Campus getCampus() {
        return campus;
    }

    public String getTitle() {
        return title;
    }
}
