package com.serzh.tibetdoctor.services;

import com.serzh.tibetdoctor.domain.Recipe;

public interface RecipeService {

    Recipe getById(Integer id);

    Recipe save(Recipe recipe);

    void delete(Integer id);

//    Iterable<Recipe> getAllRecipesByAppointmentId(int id);
}
