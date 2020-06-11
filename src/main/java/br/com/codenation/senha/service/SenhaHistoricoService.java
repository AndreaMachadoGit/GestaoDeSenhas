package br.com.codenation.senha.service;

import br.com.codenation.senha.model.Senha;
import br.com.codenation.senha.model.SenhaHistorico;
import br.com.codenation.senha.model.TipoSenha;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SenhaHistoricoService {

    List<SenhaHistorico> findAll(Pageable pageable);

    Optional<SenhaHistorico> findById(Long id);

    List<SenhaHistorico> findByTipoSenha(TipoSenha tipoSenha,Pageable pageable);

    void deleteById(Long id);

    //List<SenhaHistorico> findLastCalledSenhas(Long numero);

    //List<SenhaHistorico> findFaltaChamar();

    public SenhaHistorico save(SenhaHistorico senhaHistorico);

}