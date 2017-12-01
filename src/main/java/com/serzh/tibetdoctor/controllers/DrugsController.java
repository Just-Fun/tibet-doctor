package com.serzh.tibetdoctor.controllers;

import com.serzh.tibetdoctor.services.DrugsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sergii.zagryvyi on 30.11.2017
 */
@Controller
@RequiredArgsConstructor
public class DrugsController {


    private final DrugsService drugsService;

    @RequestMapping("/drugs")
    public String list(Model model){
        model.addAttribute("drugs", drugsService.listAllDrugs());
        return "drugs";
    }
}
