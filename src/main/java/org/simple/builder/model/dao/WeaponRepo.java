package org.simple.builder.model.dao;

import org.simple.builder.model.meta.basic.fighter.Weapon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeaponRepo extends CrudRepository<Weapon, Long>{

    List<Weapon> findByName(String name);
}
