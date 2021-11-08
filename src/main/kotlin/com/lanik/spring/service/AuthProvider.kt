package com.lanik.spring.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component


@Component
class AuthProvider : AuthenticationProvider {
    @Autowired
    lateinit var userService: UserService

    val passwordEncoder = BCryptPasswordEncoder()

    @Throws(AuthenticationException::class)
    override fun authenticate(authentication: Authentication): Authentication {
        val username: String = authentication.name
        val password = authentication.credentials as String
        val principal: UserDetails = userService.loadUserByUsername(username)
        return if (principal.username == username) {
            if (!passwordEncoder.matches(password, principal.password)) {
                throw BadCredentialsException("Wrong password")
            }
            UsernamePasswordAuthenticationToken(principal, password, principal.authorities)
        } else throw BadCredentialsException("Username not found")
    }

    override fun supports(arg: Class<*>?): Boolean {
        return true
    }
}