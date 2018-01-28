package com.serzh.tibetdoctor.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sergii.zagryvyi on 30.11.2017
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointment")
@EqualsAndHashCode(exclude = "patient")
@ToString(exclude = "patient")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;
    private LocalDate date;

    @Transient
    public boolean isNew() {
        return (this.id == null);
    }

    //    @OneToOne
//    private Recipes recipes;
//    @OneToMany
//    private Iterable<Recipe> recipes;
//    @OneToMany(targetEntity=Recipe.class, mappedBy="appointment")
    @OneToMany(cascade = CascadeType.ALL, targetEntity = RecipeBlock.class, mappedBy = "appointment")
    private List<RecipeBlock> recipeBlocks = new LinkedList<>();
 /*   @OneToMany(cascade = CascadeType.ALL, targetEntity = Recipe.class, mappedBy = "appointment")
    private List<Recipe> recipes = new LinkedList<>();

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void addRecipe(Recipe recipe) {
        recipe.setAppointment(this);
        getRecipes().add(recipe);
    }*/

    private String diagnosis;
    private String procedures;
    private String diet;
    private String lifestyle;

    private String additionalInfo;


}
