package org.wecancodeit.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
