package com.serzh.tibetdoctor.services;

import com.serzh.tibetdoctor.domain.Drug;

public interface DrugsService {
    Iterable<Drug> listAllDrugs();
}
