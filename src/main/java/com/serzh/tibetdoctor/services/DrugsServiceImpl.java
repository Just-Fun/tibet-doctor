package com.serzh.tibetdoctor.services;

import com.serzh.tibetdoctor.domain.Drug;
import com.serzh.tibetdoctor.repositories.DrugsRepository;
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
    public Iterable<Drug> listAllDrugs() {
        return drugsRepository.findAll();
    }
}
