package org.wecancodeit.library;

import java.util.Collection;

public interface CampusStorage {
    Collection<Campus> findAllCampuses();

    void store(Campus campus);
}
