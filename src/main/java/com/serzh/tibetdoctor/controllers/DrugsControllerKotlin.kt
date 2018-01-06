package com.serzh.tibetdoctor.controllers

import com.serzh.tibetdoctor.domain.Drug
import com.serzh.tibetdoctor.services.DrugTypeServiceKotlin
import com.serzh.tibetdoctor.services.DrugsServiceKotlin
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

//@RestController // Сообщаем как обрабатывать http запросы и в каком виде отправлять ответы (сериализация в JSON и обратно)
//@Controller
@RequestMapping("/drugs") // Указываем перфик маршруета для всех экшенов
class DrugsControllerKotlin(private val drugsService: DrugsServiceKotlin,
                            private val drugTypeServiceKotlin: DrugTypeServiceKotlin) {
    // Внедряем наш сервис в качестве зависимости

//    @GetMapping // Говорим что экшен принемает GET запрос без параметров в url
//    fun index() = drugsService.all() // И возвращает результат метода all нашего сервиса. Функциональная запись с выводом типа

    @GetMapping
    fun list(model: Model): String {
        model.addAttribute("drugs", drugsService.all())
        return "drugs"
    }

    @GetMapping("edit/{id}")
    fun edit(@PathVariable id: Int, model: Model): String {
        val get = drugsService.get(id)
        model.addAttribute("drug", get)
        val all = drugTypeServiceKotlin.all()
        model.addAttribute("types", all)
        return "drugform"
    }

    @PostMapping
    fun save(drug: Drug): String {
        val savedRecipe = drugsService.save(drug)
        return "redirect:/drugs/"
    }
}