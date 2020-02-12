package org.wecancodeit.library;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MapCampusStorageTest {
    @Test
    public void shouldStoreCampusInMap(){
        Campus testCampus = new Campus("Test Town");
        CampusStorage underTest = new MapCampusStorage();
        underTest.store(testCampus);
        assertThat(underTest.findAllCampuses()).contains(testCampus);
    }
}
