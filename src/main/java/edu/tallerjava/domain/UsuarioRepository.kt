package edu.tallerjava.domain

import edu.tallerjava.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<User, Long>