package org.wecancodeit.library.models;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    @ManyToMany
    private Collection<Author> authors;
    @ManyToOne
    private Campus campus;
    private String title;

    public Book(String title, String description, Campus campus, Author... authors) {

        this.title = title;
        this.description = description;
        this.authors = Arrays.asList(authors);
        this.campus = campus;
    }

    public Book() {
    }

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

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (getId() != null ? !getId().equals(book.getId()) : book.getId() != null) return false;
        if (getDescription() != null ? !getDescription().equals(book.getDescription()) : book.getDescription() != null)
            return false;
        if (getCampus() != null ? !getCampus().equals(book.getCampus()) : book.getCampus() != null) return false;
        return getTitle() != null ? getTitle().equals(book.getTitle()) : book.getTitle() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getCampus() != null ? getCampus().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        return result;
    }
}
