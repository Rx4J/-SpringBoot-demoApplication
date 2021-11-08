package com.lanik.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan("com.lanik.spring")
@EntityScan("com.lanik.spring.model")
@EnableJpaRepositories("com.lanik.spring.repository")
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
