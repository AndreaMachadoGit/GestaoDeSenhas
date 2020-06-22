package br.com.codenation.senha.repository;

import br.com.codenation.senha.model.SenhaHistorico;
import br.com.codenation.senha.model.TipoSenha;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SenhaHistoricoRepository extends CrudRepository<SenhaHistorico, Long> {

    Page<SenhaHistorico> findAll(Pageable pageable);

    Optional<SenhaHistorico> findById(Long id);

    List<SenhaHistorico> findByTipoSenha(TipoSenha tipoSenha,Pageable pageable);

    @Query(value = "SELECT id FROM SENHA_HISTORICO " +
            "WHERE data_chamada IS NULL " +
            "ORDER BY tipo_senha DESC, NUMERO ASC   ", nativeQuery = true)
    SenhaHistorico chamaProximaSenha(SenhaHistorico senhaHistorico);

    ///@Query(value = "INSERT INTO SENHA_HISTORICO (TIPO_SENHA, NUMERO) VALUES (:tipo_senha, :numero)", nativeQuery = true)
    //SenhaHistorico createNewSenha(@Param("tipo_senha")TipoSenha tipoSenha, @Param("numero")Long numero);
    @Query(value = "SELECT top(1) id FROM SENHA_HISTORICO " +
            "ORDER BY id  DESC   ", nativeQuery = true)
    Long findMaxId();

    //SenhaHistorico createNewSenha(TipoSenha tipoSenha, Long numero);

}
