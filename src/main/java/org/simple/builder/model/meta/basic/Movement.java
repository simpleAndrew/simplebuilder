package org.simple.builder.model.meta.basic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simple.builder.model.meta.basic.types.D6Check;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class Movement {

    @Embedded
    @AttributeOverrides(
            {
                    @AttributeOverride(name = "inches", column = @Column(name = "cross_country_inches")),
                    @AttributeOverride(name = "centimeters", column = @Column(name = "cross_country_centimeters"))
            }
    )
    private Range crossCountryDash;

    @Embedded
    @AttributeOverrides(
            {
                    @AttributeOverride(name = "inches", column = @Column(name = "terrain_inches")),
                    @AttributeOverride(name = "centimeters", column = @Column(name = "terrain_centimeters"))
            }
    )
    private Range terrainDash;
    
    @Embedded
    @AttributeOverrides(
            {
                    @AttributeOverride(name = "inches", column = @Column(name = "road_inches")),
                    @AttributeOverride(name = "centimeters", column = @Column(name = "road_centimeters"))
            }
    )
    private Range roadDash;

    @Embedded
    @AttributeOverrides(
            {
                    @AttributeOverride(name = "inches", column = @Column(name = "tactical_inches")),
                    @AttributeOverride(name = "centimeters", column = @Column(name = "tactical_centimeters"))
            }
    )
    private Range tactical;

    private D6Check crossCheck;
}
