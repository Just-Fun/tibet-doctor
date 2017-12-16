package com.serzh.tibetdoctor.repositories;

import com.serzh.tibetdoctor.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipesRepository extends CrudRepository<Recipe, Integer> {
    Iterable<Recipe> findByPatientIdOrderByDateDesc(int id);
}
