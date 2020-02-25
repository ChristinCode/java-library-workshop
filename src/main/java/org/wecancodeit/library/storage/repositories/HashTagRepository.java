package org.wecancodeit.library.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.library.models.HashTag;

public interface HashTagRepository extends CrudRepository<HashTag, Long> {
}
