package br.com.codenation.usuario.service;

import br.com.codenation.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl {

    @Autowired
    private UsuarioRepository usuarioRepository;


}
