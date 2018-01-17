package com.serzh.tibetdoctor.repositories;

import com.serzh.tibetdoctor.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    Iterable<Recipe> findByAppointmentId(int id);

}
