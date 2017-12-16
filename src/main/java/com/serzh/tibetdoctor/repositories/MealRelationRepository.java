package com.serzh.tibetdoctor.repositories;

import com.serzh.tibetdoctor.domain.MealRelation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRelationRepository extends CrudRepository<MealRelation, Integer> {
}
