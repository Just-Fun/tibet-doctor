package com.serzh.tibetdoctor.controllers

import com.serzh.tibetdoctor.services.DrugsServiceKotlin
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

//@RestController // Сообщаем как обрабатывать http запросы и в каком виде отправлять ответы (сериализация в JSON и обратно)
@Controller
@RequestMapping("/drugs") // Указываем перфик маршруета для всех экшенов
class DrugsControllerKotlin(private val drugsService: DrugsServiceKotlin) {
    // Внедряем наш сервис в качестве зависимости

//    @GetMapping // Говорим что экшен принемает GET запрос без параметров в url
//    fun index() = drugsService.all() // И возвращает результат метода all нашего сервиса. Функциональная запись с выводом типа

    @GetMapping
    fun list(model: Model): String {
        model.addAttribute("drugs", drugsService.all())
        return "drugs"
    }

}