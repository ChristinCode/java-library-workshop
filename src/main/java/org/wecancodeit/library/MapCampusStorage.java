package org.wecancodeit.library;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class MapCampusStorage implements CampusStorage {
    private HashMap<String, Campus> campuses;

    public MapCampusStorage(){
        campuses = new HashMap<>();
    }
    @Override
    public Collection<Campus> findAllCampuses() {
        return campuses.values();
    }

    @Override
    public void store(Campus campus) {
        campuses.put(campus.getLocation(),campus);
    }

    @Override
    public Campus findCampusByLocation(String campusLocation) {
        return campuses.get(campusLocation);
    }
}
