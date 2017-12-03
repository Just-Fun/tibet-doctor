package com.serzh.tibetdoctor.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author sergii.zagryvyi on 02.12.2017
 */
@Entity
@Data
public class Dosage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
