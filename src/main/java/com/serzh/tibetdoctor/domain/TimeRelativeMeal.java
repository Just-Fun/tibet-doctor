package com.serzh.tibetdoctor.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author sergii.zagryvyi on 02.12.2017
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Deprecated
public class TimeRelativeMeal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    String value;
}
