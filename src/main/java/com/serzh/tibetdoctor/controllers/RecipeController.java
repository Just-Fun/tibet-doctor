package com.serzh.tibetdoctor.controllers;

import com.serzh.tibetdoctor.domain.Appointment;
import com.serzh.tibetdoctor.repositories.RecipeRepository;
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
@RequestMapping("/resipes")
@RequiredArgsConstructor
public class RecipeController {

    private final AppointmentService appointmentsService;
    private final PatientService patientService;
    private final DrugsService drugsService;
    private final DosageService dosageService;
    private final DayTimeService dayTimeService;
    private final MealRelationService mealRelationService;
    private final TakeWithService takeWithService;
    private final RecipeRepository recipeRepository;

    //    don't used
  /*  @GetMapping
    public String list(Model model) {
        model.addAttribute("appointments", appointmentsService.listAllAppointments());
        return "appointments";
    }*/

    @GetMapping("new/{id}")
    public String newAppointment(@PathVariable Integer id, Model model) {
//        Patient patient = patientService.getPatientById(id);
//        model.addAttribute("patient", patient);
//        model.addAttribute("appointment", Appointment.builder().patient(patient).build());
//        addAllForAppointments(model);

        return "appointment_form";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
//        Appointment appointment = appointmentsService.getAppointmentById(id);
//        model.addAttribute("appointment", appointment);
//        model.addAttribute("patient", appointment.getPatient());
//        addAllForAppointments(model);

        return "appointment_form";
    }

    //    after adding new appointment - show patient with all appointments

    @PostMapping
    public String saveAppointment(Appointment appointment) {
//    public String saveAppointment(Appointment appointment, Recipe recipe) {
//        recipe.setAppointment(appointment);
//        recipeRepository.save(recipe);
        Appointment savedAppointment = appointmentsService.saveAppointment(appointment);
        return "redirect:/patients/" + savedAppointment.getPatient().getId();
    }

    private void addAllForAppointments(Model model) {
        model.addAttribute("drugs", drugsService.all());
        model.addAttribute("dosages", dosageService.listAll());
        model.addAttribute("dayTimes", dayTimeService.listAll());
        model.addAttribute("mealRelations", mealRelationService.listAll());
        model.addAttribute("takeWiths", takeWithService.listAll());
    }

}
