package com.serzh.tibetdoctor.repositories;

import com.serzh.tibetdoctor.domain.Drug;
import org.springframework.data.repository.CrudRepository;

public interface DrugsRepository extends CrudRepository<Drug, Integer> {
}
