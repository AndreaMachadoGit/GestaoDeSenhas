package br.com.codenation.senha.repository;

import br.com.codenation.senha.model.SenhaHistorico;
import br.com.codenation.senha.model.TipoSenha;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SenhaHistoricoRepository extends CrudRepository<SenhaHistorico, Long> {

    Page<SenhaHistorico> findAll(Pageable pageable);

    List<SenhaHistorico> findByTipoSenha(TipoSenha tipoSenha,Pageable pageable);

    //List<SenhaHistorico> findLastCalledSenhas(Long numero);

    //List<SenhaHistorico> findFaltaChamar();


}
