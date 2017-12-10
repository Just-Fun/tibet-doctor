package com.serzh.tibetdoctor.services;

import com.serzh.tibetdoctor.domain.TakeWith;

public interface TakeWithService {
    Iterable<TakeWith> listAll();
}
