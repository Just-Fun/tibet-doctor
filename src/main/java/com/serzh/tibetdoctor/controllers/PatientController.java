package com.serzh.tibetdoctor.controllers;

import com.serzh.tibetdoctor.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
