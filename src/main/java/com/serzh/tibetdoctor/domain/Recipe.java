package com.serzh.tibetdoctor.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author sergii.zagryvyi on 06.01.2018
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recipe")
@EqualsAndHashCode(exclude = "recipeBlock")
@ToString(exclude = "recipeBlock")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="recipe_block_id", nullable=false)
    private RecipeBlock recipeBlock;

    @ManyToOne
    private Drug drug;
    @ManyToOne
    private Dosage dosage;
    @ManyToOne
    private DayTime dayTime;
    @ManyToOne
    private MealRelation mealRelation;
    private int durationTakingMedicines;
    private LocalDate beginningTakingMedicines;
    @ManyToOne
    private TakeWith takeWith;

}
