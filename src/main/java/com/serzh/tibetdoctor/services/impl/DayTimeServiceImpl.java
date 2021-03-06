package com.serzh.tibetdoctor.services.impl;

import com.serzh.tibetdoctor.domain.DayTime;
import com.serzh.tibetdoctor.repositories.DayTimeRepository;
import com.serzh.tibetdoctor.services.DayTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author sergii.zagryvyi on 10.12.2017
 */
@Service
@RequiredArgsConstructor
public class DayTimeServiceImpl implements DayTimeService {

    private final DayTimeRepository dayTimeRepository;

    @Override
    public Iterable<DayTime> listAll() {
        return dayTimeRepository.findAll();
    }
}
