package org.wecancodeit.library.storage;

import org.junit.jupiter.api.Test;
import org.wecancodeit.library.storage.repositories.BookRepository;

class BookStorageJpaImplTest {
    private BookRepository bookRepo;

    @Test
    public void shouldInstantiate() {
        BookStorage underTest = new BookStorageJpaImpl(bookRepo);
    }
}