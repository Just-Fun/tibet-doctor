package com.serzh.tibetdoctor.services.impl;

import com.serzh.tibetdoctor.domain.Recipe;
import com.serzh.tibetdoctor.repositories.RecipeRepository;
import com.serzh.tibetdoctor.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author sergii.zagryvyi on 06.01.2018
 */
@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Override
    public Recipe getById(Integer id) {
        return recipeRepository.findOne(id);
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void delete(Integer id) {
        recipeRepository.delete(id);
    }

    @Override
    public Iterable<Recipe> getAllRecipesByAppointmentId(int id) {
        return recipeRepository.findByAppointmentId(id);
    }
}
