package com.serzh.tibetdoctor.services;

import com.serzh.tibetdoctor.domain.Drug;

public interface DrugsService {
    Iterable<Drug> all();

    Drug get(Integer id);

    Drug save(Drug drug);

    void delete(Integer id);
}
