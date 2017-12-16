package com.serzh.tibetdoctor.services.impl;

import com.serzh.tibetdoctor.domain.Recipe;
import com.serzh.tibetdoctor.repositories.RecipesRepository;
import com.serzh.tibetdoctor.services.RecipesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @author sergii.zagryvyi on 30.11.2017
 */
@Service
@RequiredArgsConstructor
public class RecipesServiceImpl implements RecipesService {

    private final RecipesRepository recipesRepository;

//    @Override
//    public Iterable<Recipe> listAllRecipes() {
//        return null;
//    }

    @Override
    public Recipe getRecipeById(Integer id) {
        return null;
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        recipe.setDate(LocalDate.now());
        recipesRepository.save(recipe);
        return recipe;
    }

    @Override
    public void deleteRecipe(Integer id) {
        recipesRepository.delete(id);

    }

    public Iterable<Recipe> getAllRecipesByPatientId(int id) {
        Iterable<Recipe> all = recipesRepository.findByPatientIdOrderByDateDesc( id);
        return all;
    }

}
