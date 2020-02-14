package org.wecancodeit.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    CampusStorage campusStorage;

    public Populator(CampusStorage campusStorage){
        this.campusStorage = campusStorage;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("POPULATOR IS RUNNING");
        Campus columbus = new Campus("Columbus");
        campusStorage.store(columbus);
        Campus cleveland = new Campus("Cleveland");
        campusStorage.store(cleveland);
        Campus theMoon = new Campus("THE MOON");
        campusStorage.store(theMoon);

    }
}
