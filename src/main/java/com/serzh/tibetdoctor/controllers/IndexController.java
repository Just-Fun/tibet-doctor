package com.serzh.tibetdoctor.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sergii.zagryvyi on 30.11.2017
 */
@Controller
@Slf4j
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/error/{message}")
    public String error(@PathVariable String message, Model model) {
        String errorMessage = String.format("Ошибка: %s", message);
        model.addAttribute("error", errorMessage);
        return "index";
    }

}
