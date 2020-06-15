package br.com.codenation.senha.repository;

import br.com.codenation.senha.model.Senha;
import br.com.codenation.senha.model.SenhaHistorico;
import br.com.codenation.senha.model.TipoSenha;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface SenhaHistoricoRepository extends CrudRepository<SenhaHistorico, Long> {

    Page<SenhaHistorico> findAll(Pageable pageable);

    Optional<SenhaHistorico> findById(Long id);

    List<SenhaHistorico> findByTipoSenha(TipoSenha tipoSenha,Pageable pageable);

    @Query(value = "SELECT id FROM SENHA_HISTORICO " +
            "WHERE data_chamada IS NULL " +
            "ORDER BY tipo_senha DESC, NUMERO ASC )  ", nativeQuery = true)
    SenhaHistorico chamaProximaSenha(SenhaHistorico senhaHistorico);

}
