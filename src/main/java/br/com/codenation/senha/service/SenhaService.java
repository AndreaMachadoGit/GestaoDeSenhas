package br.com.codenation.senha.service;

import br.com.codenation.senha.model.Senha;
import br.com.codenation.senha.model.TipoSenha;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SenhaService {

    List<Senha> findAll(Pageable pageable);

    Optional<Senha> findById(Long id);

    Senha save(Senha senha);

    void deleteById(Long id);

    List<Senha> findByTipoSenha(TipoSenha level, Pageable pageable);

    //Senha findNextNumero(Senha senha);
    //List<Senha> search(String searchTerm, int page, int size);

}
