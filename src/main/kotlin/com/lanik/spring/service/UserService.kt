package com.lanik.spring.service

import com.lanik.spring.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserService : UserDetailsService {
    @Autowired
    lateinit var userRepository: UserRepository

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val myUser =
            userRepository.findByUsername(username) ?: throw(UsernameNotFoundException("Unknown user: $username"))
        return User.builder()
            .username(username)
            .password(myUser.password)
            .roles(myUser.role)
            .build()
    }
}