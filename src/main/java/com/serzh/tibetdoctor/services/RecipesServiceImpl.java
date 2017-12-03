package com.serzh.tibetdoctor.services;

import com.serzh.tibetdoctor.domain.Recipe;
import com.serzh.tibetdoctor.repositories.RecipesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author sergii.zagryvyi on 30.11.2017
 */
@Service
@RequiredArgsConstructor
public class RecipesServiceImpl {

    private final RecipesRepository recipesRepository;

    public Iterable<Recipe> findByPatient(int id) {
        Iterable<Recipe> all = recipesRepository.findByPatientId( id);
        return all;
    }

}
