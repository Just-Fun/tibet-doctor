package com.serzh.tibetdoctor.controllers;

import com.serzh.tibetdoctor.domain.Patient;
import com.serzh.tibetdoctor.domain.SexEnum;
import com.serzh.tibetdoctor.services.PatientService;
import com.serzh.tibetdoctor.services.RecipesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author sergii.zagryvyi on 30.11.2017
 */
@Controller
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    public static final String PATIENT = "patient";
    private final PatientService patientService;
    private final RecipesService recipesService;

    @GetMapping
    public String list(Model model){
        model.addAttribute("patients", patientService.listAllPatients());
        return "patients";
    }

    @GetMapping("{id}")
    public String showPatient(@PathVariable Integer id, Model model){
        model.addAttribute(PATIENT, patientService.getPatientById(id));
        model.addAttribute("recipes", recipesService.getAllRecipesByPatientId(id));
        return "patientshow";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute(PATIENT, patientService.getPatientById(id));
        model.addAttribute("sexes", SexEnum.getSexList());
        return "patientform";
    }

    @GetMapping("new")
    public String newPatient(Model model){
        model.addAttribute(PATIENT, new Patient());
        model.addAttribute("sexes", SexEnum.getSexList());
        return "patientform";
    }

    @PostMapping
    public String savePatient(Patient patient){
        Patient savedPatient = patientService.savePatient(patient);
        return "redirect:/patients/" + savedPatient.getId();
    }

    @GetMapping("patients/delete/{id}")
    public String delete(@PathVariable Integer id){
        patientService.deletePatient(id);
        return "redirect:/patients";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}
