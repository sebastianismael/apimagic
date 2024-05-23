package edu.tallerjava.domain

import edu.tallerjava.domain.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service("ApiService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
open class ApiServiceImpl(@Autowired private var usuarioRepository: UsuarioRepository) : ApiService {

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = [Exception::class])
    override fun crear(nombre: String) {
        val user = User()
        user.name = nombre
        usuarioRepository.save(user)
    }
}