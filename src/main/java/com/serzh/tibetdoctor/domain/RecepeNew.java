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
 * @author sergii.zagryvyi on 06.01.2018
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecepeNew {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


}
