package com.qualco.project.model;


import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "region_areas")
public class RegionArea {

    @Id
    @Column(name = "region_name")
    private String name;

    @NonNull
    @Column(name = "region_area")
    private BigDecimal area;
}
