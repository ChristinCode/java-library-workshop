package org.wecancodeit.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.library.models.Campus;
import org.wecancodeit.library.storage.CampusStorage;

@Component
public class Populator implements CommandLineRunner {

    CampusStorage campusStorage;

    public Populator(CampusStorage campusStorage){
        this.campusStorage = campusStorage;
    }
    @Override
    public void run(String... args) throws Exception {
        campusStorage.store(new Campus("Columbus"));
        campusStorage.store(new Campus("Cleveland"));
        campusStorage.store(new Campus("THE MOON"));
    }
}
