package org.wecancodeit.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {
    @Test
    public void shouldInstantiateBook() {
        Book underTest = new Book("Title", "Author", 1234567890, "Description");
        assertEquals("Author",underTest.getAuthor());
    }
}
