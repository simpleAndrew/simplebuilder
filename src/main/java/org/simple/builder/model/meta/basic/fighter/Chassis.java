package org.simple.builder.model.meta.basic.fighter;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Chassis {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int front;
    private int side;
    private int top;

}
