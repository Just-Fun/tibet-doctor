package com.serzh.tibetdoctor.repositories;

import com.serzh.tibetdoctor.domain.TakeWith;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TakeWithRepository extends CrudRepository<TakeWith, Integer> {
}
