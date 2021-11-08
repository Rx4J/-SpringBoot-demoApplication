package com.lanik.spring.control

import com.lanik.spring.repository.UserRepository
import com.lanik.spring.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class RegistrationController {
    @Autowired
    lateinit var userRepository: UserRepository

    val encoder = BCryptPasswordEncoder()

    @GetMapping("/registration")
    fun registration(model: Model): String {
        return "registration"
    }

    @PostMapping("/registration")
    fun addUser(name: String?, password: String?): String {
        if(name!=null && password!=null) {
            val user = User(name, encoder.encode(password), "USER")
            userRepository.save(user)
            return "redirect:/login"
        }
        return "registration"
    }
}