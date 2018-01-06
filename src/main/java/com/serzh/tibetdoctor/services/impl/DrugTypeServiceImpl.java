package com.serzh.tibetdoctor.services.impl;

import com.serzh.tibetdoctor.domain.DrugType;
import com.serzh.tibetdoctor.repositories.DrugTypeRepository;
import com.serzh.tibetdoctor.services.DrugTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author sergii.zagryvyi on 06.01.2018
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DrugTypeServiceImpl implements DrugTypeService {

    private final DrugTypeRepository drugTypeRepository;

    @Override
    public Iterable<DrugType> all() {
        return drugTypeRepository.findAll();
    }

    @Override
    public DrugType get(Integer id) {
        return drugTypeRepository.findOne(id);
    }

    @Override
    public DrugType save(DrugType drugType) {
        return drugTypeRepository.save(drugType);
    }

    @Override
    public void delete(Integer id) {
        drugTypeRepository.delete(id);
    }
}
