package com.qualco.project.model;

import lombok.*;
import org.springframework.lang.NonNull;
import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "region_id")
    private BigInteger id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "continent_id")
    private Continent continent;

}
