package edu.tallerjava.domain

import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<User, Long>