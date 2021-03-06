package com.serzh.tibetdoctor.services.impl;

import com.serzh.tibetdoctor.domain.Dosage;
import com.serzh.tibetdoctor.repositories.DosageRepository;
import com.serzh.tibetdoctor.services.DosageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author sergii.zagryvyi on 10.12.2017
 */
@Service
@RequiredArgsConstructor
public class DosageServiceImpl implements DosageService {

    private final DosageRepository dosageRepository;

    @Override
    public Iterable<Dosage> listAll() {
        return dosageRepository.findAll();
    }
}
