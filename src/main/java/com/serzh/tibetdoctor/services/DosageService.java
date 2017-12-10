package com.serzh.tibetdoctor.services;

import com.serzh.tibetdoctor.domain.Dosage;

public interface DosageService {
    Iterable<Dosage> listAll();
}
