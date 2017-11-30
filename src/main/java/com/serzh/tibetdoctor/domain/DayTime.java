package com.serzh.tibetdoctor.domain;

import lombok.Getter;

@Getter
public enum DayTime {
    MORNING("утро"),
    DAY("день"),
    EVENING("вечер");

    private final String template;

    DayTime(String template) {
//        DayTime.EVENING.getTemplate()
        this.template = template;
    }
}
