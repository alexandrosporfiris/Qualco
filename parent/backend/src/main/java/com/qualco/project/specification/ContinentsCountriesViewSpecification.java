package com.qualco.project.specification;

import com.qualco.project.model.view.ContinentsCountriesView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class ContinentsCountriesViewSpecification implements Specification<ContinentsCountriesView> {

    private String regionName;
    private BigInteger startYear;
    private BigInteger endYear;

    @Override
    public Predicate toPredicate(Root<ContinentsCountriesView> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> finalPredicate = new ArrayList<>();
        if (Objects.nonNull(regionName)) {
            Predicate regionNamePredicate = root.get("regionName").in(regionName);
            finalPredicate.add(regionNamePredicate);
        }
        if(Objects.nonNull(startYear) && Objects.nonNull(endYear)){
            Predicate yearPredicate = criteriaBuilder.between(root.get("year"), startYear, endYear);
            finalPredicate.add(yearPredicate);
        }
        return criteriaBuilder.and(finalPredicate.toArray(new Predicate[0]));
    }
}
