package com.serzh.tibetdoctor.repositories;

import com.serzh.tibetdoctor.domain.DayTime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayTimeRepository extends CrudRepository<DayTime, Integer> {
}
