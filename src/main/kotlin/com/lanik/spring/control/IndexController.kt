package com.lanik.spring.control

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.security.Principal

@Controller
class IndexController {
    @GetMapping("/")
    fun index(principal: Principal?, model: Model): String {
        if(principal != null){
            model.addAttribute("name", principal.name)
            model.addAttribute("auth", true)
        } else {
            model.addAttribute("name", "Гость")
            model.addAttribute("auth", false)
        }
        return "index"
    }
}