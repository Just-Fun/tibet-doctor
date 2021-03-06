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
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String code;
    private String name;
    @ManyToOne
    private DrugType type;
    private int available;

}
