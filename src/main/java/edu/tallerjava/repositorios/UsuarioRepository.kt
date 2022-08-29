package edu.tallerjava.repositorios

import edu.tallerjava.modelo.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long>