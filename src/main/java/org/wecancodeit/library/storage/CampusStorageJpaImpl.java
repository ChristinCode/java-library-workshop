package org.wecancodeit.library.storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.library.models.Campus;
import org.wecancodeit.library.storage.repositories.CampusRepository;

import java.util.Collection;
@Service
public class CampusStorageJpaImpl implements CampusStorage {
    private CampusRepository campusRepository;

    public CampusStorageJpaImpl(CampusRepository campusRepository) {

        this.campusRepository = campusRepository;
    }

    @Override
    public Collection<Campus> findAllCampuses() {
        return (Collection<Campus>) campusRepository.findAll();
    }

    @Override
    public void store(Campus campus) {
        campusRepository.save(campus);
    }

    @Override
    public Campus findCampusByLocation(String campusLocation) {
        return campusRepository.findByLocation(campusLocation).get();
    }
}
