package org.simple.builder.model.dao;

import org.simple.builder.model.meta.core.Tank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TankRepo extends CrudRepository<Tank, Long> {

    Tank findByName(String name);
}
