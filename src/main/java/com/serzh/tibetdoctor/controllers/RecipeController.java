package com.serzh.tibetdoctor.controllers;

import com.serzh.tibetdoctor.domain.*;
import com.serzh.tibetdoctor.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sergii.zagryvyi on 30.11.2017
 */
@Controller
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipesService recipesService;
    private final PatientService patientService;
    private final DrugsService drugsService;
    private final DosageService dosageService;
    private final DayTimeService dayTimeService;
    private final MealRelationService mealRelationService;
    private final TakeWithService takeWithService;

    //    don't used
  /*  @GetMapping
    public String list(Model model) {
        model.addAttribute("recipes", recipesService.listAllRecipes());
        return "recipes";
    }*/

    @GetMapping("new/{id}")
    public String newRecipe(@PathVariable Integer id, Model model) {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        model.addAttribute("recipe", Recipe.builder().patient(patient).build());
        model.addAttribute("drugs", drugsService.listAllDrugs());
        model.addAttribute("dosages", dosageService.listAll());
        model.addAttribute("dayTimes", dayTimeService.listAll());
        model.addAttribute("mealRelations", mealRelationService.listAll());
        model.addAttribute("takeWiths", takeWithService.listAll());

        return "recipeform";
    }

    /*@GetMapping("{id}")
    public String showRecipe(@PathVariable Integer id, Model model) {
        model.addAttribute("patient", patientService.getPatientById(id));
        model.addAttribute("recipes", recipesService.getAllRecipesByPatientId(id));
        return "patientshow";
    }*/

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("recipe", recipesService.getRecipeById(id));
        return "recipeform";
    }

    //    after adding new recipe - show patient with all recipes
    @PostMapping
    public String saveRecipe(Recipe recipe) {
        Recipe savedRecipe = recipesService.saveRecipe(recipe);
        return "redirect:/patients/" + savedRecipe.getPatient().getId();
    }

/*    @GetMapping("new")
    public String newPatient(Model model){
        model.addAttribute("recipe", new Patient());
        return "recipeform";
    }

    @PostMapping
    public String savePatient(Patient patient){
        Patient savedPatient = patientService.savePatient(patient);
        return "redirect:/recipes/" + savedPatient.getId();
    }

    @GetMapping("recipes/delete/{id}")
    public String delete(@PathVariable Integer id){
        patientService.deletePatient(id);
        return "redirect:/recipes";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }*/
}
