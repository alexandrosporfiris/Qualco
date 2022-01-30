package com.qualco.project.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigInteger;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryStatId implements Serializable {

    private Country country;

    private BigInteger year;
}
