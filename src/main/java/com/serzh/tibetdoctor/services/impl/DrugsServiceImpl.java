package com.serzh.tibetdoctor.services.impl;

import com.serzh.tibetdoctor.domain.Drug;
import com.serzh.tibetdoctor.repositories.DrugsRepository;
import com.serzh.tibetdoctor.services.DrugsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author sergii.zagryvyi on 01.12.2017
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DrugsServiceImpl implements DrugsService {

    private final DrugsRepository drugsRepository;

    @Override
    public Iterable<Drug> all() {
        return drugsRepository.findAll();
    }

    @Override
    public Drug get(Integer id) {
        return drugsRepository.findOne(id);
    }

    @Override
    public Drug save(Drug drug) {
        return drugsRepository.save(drug);
    }

    @Override
    public void delete(Integer id) {
        drugsRepository.delete(id);
    }
}
