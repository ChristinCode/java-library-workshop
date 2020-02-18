package org.wecancodeit.library;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CampusRepository extends CrudRepository<Campus, Long> {

    Optional<Campus> findByLocation(String campusLocation);
}
