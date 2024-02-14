package edu.tallerjava.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id

@Entity
class Usuario {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null
    var nombre: String? = null
}