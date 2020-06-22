package br.com.codenation.senha.repository;

import br.com.codenation.senha.model.Senha;
import br.com.codenation.senha.model.TipoSenha;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SenhaRepository extends CrudRepository<Senha, Long> {

    Page<Senha> findAll(Pageable pageable);

    Senha findByTipoSenha(TipoSenha tipoSenha);


}
