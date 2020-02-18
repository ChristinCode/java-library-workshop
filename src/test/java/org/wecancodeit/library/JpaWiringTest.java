package org.wecancodeit.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaWiringTest {
    @Autowired
    private CampusRepository campusRepo;
    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void campusShouldHaveAListOfBooks() {
        Campus testCampus = new Campus("Testville");
        Book testBook = new Book("Title", "Author", testCampus);
        campusRepo.save(testCampus);
        bookRepo.save(testBook);

        entityManager.flush();
        entityManager.clear();

        Optional<Campus> retrievedCampusOptional = campusRepo.findById(testCampus.getId());
        Campus retrievedCampus = retrievedCampusOptional.get();
        Book retrievedBook = bookRepo.findById(testBook.getId()).get();

        assertThat(retrievedCampus.getBooks()).contains(testBook);

    }
}
