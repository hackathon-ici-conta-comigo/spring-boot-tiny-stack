package com.codegik.tinystack.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.codegik.tinystack.domain.Period;
import com.codegik.tinystack.domain.Profile;
import com.codegik.tinystack.domain.User;

public class ProfilesByFiltersSpecification implements Specification<Profile> {

    private String name;
    private Period period;
    private String city;

    public ProfilesByFiltersSpecification(String name, Period period, String city) {
        this.name = name;
        this.period = period;
        this.city = city;
    }

    @Override
    public Predicate toPredicate(Root<Profile> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate predicate = cb.disjunction();
        if (name != null && !name.trim().isEmpty()) {
            predicate.getExpressions().add(cb.equal(root.<User>get("user").get("firstName"), name));
        }
        if (null != period && null != period.getInitialDate() && null != period.getEndDate()) {
            predicate.getExpressions()
                    .add(cb.and(cb.greaterThanOrEqualTo(root.get("birthday"), period.getInitialDate()),
                            cb.lessThanOrEqualTo(root.get("birthday"), period.getEndDate())));
        }
        if (city != null && !city.trim().isEmpty()) {
            for (final String string : city.split(" ")) {
                final String statement = "%" + string + "%";
                predicate.getExpressions()
                        .add(cb.or(cb.like(root.get("address").get("city"), statement),
                                cb.like(root.get("address").get("street"), statement),
                                cb.like(root.get("address").get("country"), statement)));
            }
        }
        return predicate;
    }

}
