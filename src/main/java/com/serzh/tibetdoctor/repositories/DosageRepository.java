package com.serzh.tibetdoctor.repositories;

import com.serzh.tibetdoctor.domain.Dosage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DosageRepository extends CrudRepository<Dosage, Integer> {
}
