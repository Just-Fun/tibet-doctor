package com.serzh.tibetdoctor.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DayTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

}
/*@Getter
public enum DayTime {
    MORNING("утро"),
    DAY("день"),
    EVENING("вечер");

    private final String template;

    DayTime(String template) {
//        DayTime.EVENING.getTemplate()
        this.template = template;
    }*/

