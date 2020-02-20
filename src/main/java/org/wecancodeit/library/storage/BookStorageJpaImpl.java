package org.wecancodeit.library.storage;

import org.wecancodeit.library.models.Book;
import org.wecancodeit.library.storage.repositories.BookRepository;

public class BookStorageJpaImpl implements BookStorage {
    private BookRepository bookRepository;

    public BookStorageJpaImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findBookById(long id) {
        return null;
    }
}
