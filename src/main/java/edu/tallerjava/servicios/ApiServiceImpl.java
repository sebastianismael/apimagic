package edu.tallerjava.servicios;

import edu.tallerjava.controladores.Saludo;
import edu.tallerjava.modelo.Usuario;
import edu.tallerjava.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("ApiService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ApiServiceImpl implements ApiService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Saludo saludar(String nombre) {
        return new Saludo(nombre, "Hola " + nombre);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void crear(String nombre) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuarioRepository.save(usuario);
    }
}
