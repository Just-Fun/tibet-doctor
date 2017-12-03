package com.serzh.tibetdoctor.controllers

import com.serzh.tibetdoctor.domain.Patient
import com.serzh.tibetdoctor.services.PatientServiceKotlin
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

//@Controller
//@RequestMapping("/patients") // Указываем перфик маршруета для всех экшенов
class PatientControllerKotlin(private val patientService: PatientServiceKotlin) {

    @GetMapping
    fun list(model: Model): String {
        model.addAttribute("patients", patientService.all())
        return "patients"
    }

    @GetMapping("{id}")
    fun edit(@PathVariable id: Int, model: Model): String {
        model.addAttribute("patient", patientService.get(id))
        return "patientform"
    }

    @PostMapping
    fun newPatient(model: Model): String {
        model.addAttribute("patient", Patient())
        return "patientform"
    }

    @PostMapping
    fun savePatient(patient: Patient): String {
        val savedPatient = patientService.add(patient)
        return "redirect:/" //+ savedPatient.id
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Int): String {
        patientService.remove(id)
        return "redirect:/patients"
    }

  /*  @RequestMapping(value = "/login", method = arrayOf(RequestMethod.GET))
    fun login(): String {
        return "login"
    }*/

}