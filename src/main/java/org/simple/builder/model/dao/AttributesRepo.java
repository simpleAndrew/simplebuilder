package org.simple.builder.model.dao;

import org.simple.builder.model.meta.basic.specials.SpecialRule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributesRepo extends CrudRepository<SpecialRule, Long>{

    SpecialRule findByName(String name);
}
