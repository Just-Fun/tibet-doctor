package com.serzh.tibetdoctor.services;

import com.serzh.tibetdoctor.domain.TakeWith;
import com.serzh.tibetdoctor.repositories.TakeWithRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author sergii.zagryvyi on 10.12.2017
 */
@Service
@RequiredArgsConstructor
public class TakeWithServiceImpl implements TakeWithService {

    private final TakeWithRepository takeWithRepository;

    @Override
    public Iterable<TakeWith> listAll() {
        return takeWithRepository.findAll();
    }

}
