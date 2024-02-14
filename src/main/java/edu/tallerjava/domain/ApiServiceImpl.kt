package edu.tallerjava.domain

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Propagation.REQUIRED
import org.springframework.transaction.annotation.Propagation.SUPPORTS
import org.springframework.transaction.annotation.Transactional

@Service("ApiService")
@Transactional(readOnly = true, propagation = SUPPORTS)
open class ApiServiceImpl(@Autowired private var usuarioRepository: UsuarioRepository) : ApiService {

    @Transactional(readOnly = false, propagation = REQUIRED, rollbackFor = [Exception::class])
    override fun crear(nombre: String) {
        val usuario = Usuario()
        usuario.nombre = nombre
        usuarioRepository.save(usuario)
    }
}