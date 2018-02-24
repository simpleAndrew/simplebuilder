package org.simple.builder.model.meta.basic.specials;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "special_rules")
public abstract class SpecialRule {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

    public SpecialRule(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
