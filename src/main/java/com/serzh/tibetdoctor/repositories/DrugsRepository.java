package com.serzh.tibetdoctor.repositories;

import com.serzh.tibetdoctor.domain.Drug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugsRepository extends CrudRepository<Drug, Integer> {
}
