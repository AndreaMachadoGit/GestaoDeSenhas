package br.com.codenation.senha.service;

import br.com.codenation.senha.model.SenhaHistorico;
import br.com.codenation.senha.model.TipoSenha;
import org.springframework.data.domain.Pageable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface SenhaHistoricoService {

    List<SenhaHistorico> findAll(Pageable pageable);

    Optional<SenhaHistorico> findById(Long id);

    List<SenhaHistorico> findByTipoSenha(TipoSenha tipoSenha,Pageable pageable);

    void deleteById(Long id);

    SenhaHistorico chamaProximaSenha(SenhaHistorico senhaHistorico);

    SenhaHistorico save(SenhaHistorico senhaHistorico);

    SenhaHistorico createNewSenha(TipoSenha tipoSenha, Long numero);

}