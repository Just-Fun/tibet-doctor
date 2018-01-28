package com.serzh.tibetdoctor.repositories;

import com.serzh.tibetdoctor.domain.RecipeBlock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeBlockRepository extends CrudRepository<RecipeBlock, Integer> {

//    Iterable<Recipe> findByAppointmentId(int id);

}
