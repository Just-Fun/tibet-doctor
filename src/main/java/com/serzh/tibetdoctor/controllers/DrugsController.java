package com.serzh.tibetdoctor.controllers;

import com.serzh.tibetdoctor.domain.Drug;
import com.serzh.tibetdoctor.domain.DrugType;
import com.serzh.tibetdoctor.services.DrugTypeServiceKotlin;
import com.serzh.tibetdoctor.services.DrugsServiceKotlin;
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
@RequestMapping("/drugs") // Указываем перфик маршруета для всех экшенов
@RequiredArgsConstructor
public class DrugsController {

    private static final String DRUG = "drug";
    private final DrugsServiceKotlin drugsService;
    private final DrugTypeServiceKotlin drugTypeService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("drugs", drugsService.all());
        return "drugs";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Drug drug = drugsService.get(id);
        model.addAttribute("drug", drug);
        Iterable<DrugType> drugTypes = drugTypeService.all();
        model.addAttribute("types", drugTypes);
        return "drugform";
    }

    @GetMapping("new")
    public String newDrug(Model model) {
        model.addAttribute(DRUG, new Drug());
        Iterable<DrugType> drugTypes = drugTypeService.all();
        model.addAttribute("types", drugTypes);
        return "drugform";
    }

    @PostMapping
    public String saveDrug(Drug drug) {
        drugsService.save(drug);
        return "redirect:/drugs";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
//        try {
        drugsService.delete(id);
//        } catch (Exception e) {
//            model.addAttribute("error", "Bla-bla");
//            e.printStackTrace();
//        }
//        return "drugs";
        return "redirect:/drugs";
    }

}
