package org.wecancodeit.library.models;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany
    private Collection<Author> authors;
    @ManyToOne
    private Campus campus;
    private String title;

    public Book(String title, Campus campus, Author... authors) {

        this.title = title;
        this.authors = Arrays.asList(authors);
        this.campus =campus;
    }
    public Book(){}
    public Collection<Author> getAuthors() {
        return authors;
    }

    public Campus getCampus() {
        return campus;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + authors + '\'' +
                ", campus=" + campus +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(campus, book.campus) &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, campus, title);
    }
}
