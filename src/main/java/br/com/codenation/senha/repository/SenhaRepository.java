package br.com.codenation.senha.repository;

import br.com.codenation.senha.model.Senha;
import br.com.codenation.senha.model.SenhaHistorico;
import br.com.codenation.senha.model.TipoSenha;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SenhaRepository extends CrudRepository<Senha, Long> {

    Page<Senha> findAll(Pageable pageable);

    Senha findByTipoSenha(TipoSenha tipoSenha);

    @Query(value = "SELECT proximo_numero FROM Senha s " +
            "WHERE tipo_senha = :tipoSenha)  ", nativeQuery = true)
    Senha findProximaSenha(@Param("tipoSenha")  TipoSenha tipoSenha);

    //@Query(value = "SELECT * FROM Senha e " +
    //        "WHERE (LOWER(e.descricao) like %:searchTerm% " +
    //        "OR LOWER(e.origem) like %:searchTerm%)  ", nativeQuery = true)
    //List<Senha> search(@Param("searchTerm") String searchTerm, Pageable pageable);

}
