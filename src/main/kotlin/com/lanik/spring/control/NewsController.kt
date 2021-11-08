package com.lanik.spring.control

import com.lanik.spring.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.security.Principal

@Controller
class NewsController {
    @Autowired
    lateinit var userRepo: UserRepository

    @GetMapping("/news")
    fun news(principal: Principal?, model: Model): String {
        if(principal != null) {
            model.addAttribute("name", principal.name)
            model.addAttribute("Users", userRepo.findAll())
            return "news"
        }
        return "redirect:/login"
    }
}