package org.wecancodeit.library.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wecancodeit.library.models.Author;
import org.wecancodeit.library.models.Book;
import org.wecancodeit.library.models.Campus;
import org.wecancodeit.library.storage.repositories.BookRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BookStorageJpaImplTest {
    private BookRepository bookRepo;
    private BookStorage underTest;
    private Campus testCampus;
    private Author testAuthor;
    private Book testBook;

    @BeforeEach
    void setUp() {
        bookRepo = mock(BookRepository.class);
        underTest = new BookStorageJpaImpl(bookRepo);
        testCampus = new Campus("Test Town");
        testAuthor = new Author("Testy", "Tester");
        testBook = new Book("Test Book", testCampus, testAuthor);

    }


    @Test
    public void shouldFindBookById() {
        when(bookRepo.findById(1L)).thenReturn(Optional.of(testBook));
        Book retrievedBook = underTest.findBookById(1L);
        assertThat(retrievedBook).isEqualTo(testBook);
    }
    @Test
    public void shouldStoreBook(){
        underTest.store(testBook);
        verify(bookRepo).save(testBook);
    }
}