package org.simple.builder.model.dao;

import org.simple.builder.model.meta.basic.fighter.Chassis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChassisRepo extends CrudRepository<Chassis, Long> {


    Chassis findByName(String name);
}
