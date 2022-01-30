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
@Table(name = "vips")
public class Vip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vip_id")
    private BigInteger id;

    @NonNull
    @Column(name = "name")
    private String name;
}
