package com.example.GProjectDemo.specification;

import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.example.GProjectDemo.model.FitnessClass;

public class FitnessClassSpecification implements Specification<FitnessClass> {

    private FitnessClass filter;

    public FitnessClassSpecification(FitnessClass filter) {
        super();
        this.filter = filter;
    }

    public Predicate toPredicate(Root<FitnessClass> root, CriteriaQuery<?> cq,
            CriteriaBuilder cb) {

        Predicate p = cb.disjunction();

        if (filter.getClassName() != null) {
            p.getExpressions()
                    .add(cb.equal(root.get("className"), filter.getClassName()));
        }

        if (filter.getClassSection() != null && filter.getInstructor() != null 
        		&& filter.getLocation() != null && filter.getMonth() != null
        			&& filter.getDay() != null && filter.getDate() != null
        			&& filter.getTime() != null ) {
            p.getExpressions().add(
                    cb.and(cb.equal(root.get("classSection"), filter.getClassSection()),
                    		cb.equal(root.get("instructor"), filter.getInstructor()),
                    		cb.equal(root.get("location"), filter.getLocation()),
                    		cb.equal(root.get("month"), filter.getMonth()),
                    		cb.equal(root.get("day"), filter.getDay()),
                    		cb.equal(root.get("date"), filter.getDate()),
                            cb.equal(root.get("time"), filter.getTime())));
        }
        
        

        return p;
    }
}