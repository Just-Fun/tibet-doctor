package com.serzh.tibetdoctor.domain;

import lombok.Getter;

@Getter
public enum Sex {

    MALE("мужчина"),
    FEMALE("женщина");
    private final String template;

    Sex(String template) {
//        Sex.MALE.getTemplate()
        this.template = template;
    }
}
