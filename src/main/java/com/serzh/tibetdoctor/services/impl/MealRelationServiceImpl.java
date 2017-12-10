package com.serzh.tibetdoctor.services.impl;

import com.serzh.tibetdoctor.domain.MealRelation;
import com.serzh.tibetdoctor.repositories.MealRelationRepository;
import com.serzh.tibetdoctor.services.MealRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author sergii.zagryvyi on 10.12.2017
 */
@Service
@RequiredArgsConstructor
public class MealRelationServiceImpl implements MealRelationService {

    private final MealRelationRepository mealRelationRepository;
    @Override
    public Iterable<MealRelation> listAll() {
        return mealRelationRepository.findAll();
    }
}
