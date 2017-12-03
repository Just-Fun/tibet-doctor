package com.serzh.tibetdoctor.controllers;

import com.serzh.tibetdoctor.domain.Patient;
import com.serzh.tibetdoctor.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author sergii.zagryvyi on 30.11.2017
 */
@Controller
@RequestMapping("/patients")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public void setProductService(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public String list(Model model){
        model.addAttribute("patients", patientService.listAllPatients());
        return "patients";
    }

    @GetMapping("{id}")
    public String showPatient(@PathVariable Integer id, Model model){
        model.addAttribute("patient", patientService.getPatientById(id));
        return "patientshow";
    }

    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("patient", patientService.getPatientById(id));
        return "patientform";
    }

    @RequestMapping("product/new")
    public String newPatient(Model model){
        model.addAttribute("patient", new Patient());
        return "patientform";
    }

    @PostMapping
    public String savePatient(Patient patient){
        Patient savedPatient = patientService.savePatient(patient);
        return "redirect:/patients/" + savedPatient.getId();
    }

    @RequestMapping("patient/delete/{id}")
    public String delete(@PathVariable Integer id){
        patientService.deletePatient(id);
        return "redirect:/patients";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}
