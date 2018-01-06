package com.serzh.tibetdoctor.services;

import com.serzh.tibetdoctor.domain.DrugType;

public interface DrugTypeService {

    Iterable<DrugType> all();

    DrugType get(Integer id);

    DrugType save(DrugType drugType);

    void delete(Integer id);
}
