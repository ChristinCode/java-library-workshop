package org.wecancodeit.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class JpaWiringTest {
    @Autowired
    private CampusRepository campusRepo;
    @Autowired
    private BookRepository bookRepo;

    @Test
    public void campusSHouldHaveAListOfBooks(){
        Campus testCampus = new Campus("Testville");
        Book testBook = new Book("Title", "Author", testCampus);

        campusRepo.save(testCampus);
        bookRepo.save(testBook);
    }
}
