package com.serzh.tibetdoctor.controllers;

import com.serzh.tibetdoctor.domain.Patient;
import com.serzh.tibetdoctor.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sergii.zagryvyi on 30.11.2017
 */
@Controller
public class PatientController {

    private PatientService patientService;

    @Autowired
    public void setProductService(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("patients", patientService.listAllPatients());
        return "patients";
    }


    @RequestMapping("patient/show/{id}")
    public String showPatient(@PathVariable Integer id, Model model){
        model.addAttribute("patient", patientService.getPatientById(id));
        return "patientshow";
    }

    @RequestMapping("patient/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("patient", patientService.getPatientById(id));
        return "patientform";
    }

    @RequestMapping("product/new")
    public String newPatient(Model model){
        model.addAttribute("patient", new Patient());
        return "patientform";
    }

    @RequestMapping(value = "patient", method = RequestMethod.POST)
    public String savePatient(Patient patient){
        Patient savedPatient = patientService.savePatient(patient);
        return "redirect:/patient/show/" + savedPatient.getId();
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
