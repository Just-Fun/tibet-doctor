package com.serzh.tibetdoctor.repositories;

import com.serzh.tibetdoctor.domain.TimeRelativeMeal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRelativeMealRepository extends CrudRepository<TimeRelativeMeal, Integer> {
}
