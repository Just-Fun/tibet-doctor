package com.serzh.tibetdoctor.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author sergii.zagryvyi on 30.11.2017
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DrugsSchema {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private DayTime dayTime;
    private String timeTaken;
    //    private String dayTime;
    private String takeWith;
    private String type;

}
