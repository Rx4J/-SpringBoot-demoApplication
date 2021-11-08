package com.lanik.spring.model

import javax.persistence.*

@Entity
@Table(name = "users")
class User (
    @Column(name = "username")
    var username: String,

    @Column(name = "password")
    var password: String,

    @Column(name = "role")
    var role: String,

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Long? = null
)