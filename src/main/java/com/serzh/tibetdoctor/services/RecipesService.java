package com.serzh.tibetdoctor.services;

import com.serzh.tibetdoctor.domain.Recipe;

public interface RecipesService {

//    Iterable<Recipe> listAllRecipes();

    Recipe getRecipeById(Integer id);

    Recipe saveRecipe(Recipe recipe);

    void deleteRecipe(Integer id);

    Iterable<Recipe> getAllRecipesByPatientId(int id);
}
