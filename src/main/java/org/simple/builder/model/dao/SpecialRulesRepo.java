package org.simple.builder.model.dao;

import org.simple.builder.model.meta.basic.specials.SpecialRule;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface SpecialRulesRepo extends CrudRepository<SpecialRule, Long> {

    Set<SpecialRule> findByName(String name);

}
