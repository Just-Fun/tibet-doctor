package com.serzh.tibetdoctor.repositories;

import com.serzh.tibetdoctor.domain.DrugType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugTypeRepository extends CrudRepository<DrugType, Integer> {
}
