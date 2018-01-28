package com.serzh.tibetdoctor.domain;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sergii.zagryvyi on 06.01.2018
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recipe_block")
@EqualsAndHashCode(exclude = "appointment")
@ToString(exclude = "appointment")
public class RecipeBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="appointment_id", nullable=false)
    private Appointment appointment;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Recipe.class, mappedBy = "recipeBlock")
    private List<Recipe> recipes = new LinkedList<>();


}
