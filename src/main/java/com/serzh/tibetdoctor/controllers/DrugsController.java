package com.serzh.tibetdoctor.controllers;

import com.serzh.tibetdoctor.services.DrugsServiceKotlin;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;

/**
 * @author sergii.zagryvyi on 30.11.2017
 */
//@Controller
@RequiredArgsConstructor
public class DrugsController {

//    private final DrugsService drugsService;
    private final DrugsServiceKotlin drugsService;

//    @RequestMapping("/drugs")
    public String list(Model model){
        model.addAttribute("drugs", drugsService.all());
        return "drugs";
    }
}
