package com.serzh.tibetdoctor.services;

import com.serzh.tibetdoctor.domain.DayTime;

public interface DayTimeService {
    Iterable<DayTime> listAll();
}
