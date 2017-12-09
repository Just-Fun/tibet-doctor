package com.serzh.tibetdoctor.repositories;

import com.serzh.tibetdoctor.domain.Dosage;
import org.springframework.data.repository.CrudRepository;

public interface DosageRepository extends CrudRepository<Dosage, Integer> {
}
