package com.serzh.tibetdoctor.services;

import com.serzh.tibetdoctor.domain.MealRelation;

public interface MealRelationService {
    Iterable<MealRelation> listAll();
}
