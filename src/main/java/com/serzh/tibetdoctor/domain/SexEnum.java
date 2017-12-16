package com.serzh.tibetdoctor.domain;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum SexEnum {

    MALE("м"),
    FEMALE("ж");

    private final String sex;

    SexEnum(String template) {
//        SexEnum.MALE.getSex()
        this.sex = template;
    }

    public static List<String> getSexList() {
        return Arrays.stream(SexEnum.values())
                .map(SexEnum::getSex)
                .collect(Collectors.toList());
    }

}
