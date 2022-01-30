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
@Table(name = "guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "guest_id")
    private BigInteger id;

    @NonNull
    @Column(name = "name")
    private String name;
}
