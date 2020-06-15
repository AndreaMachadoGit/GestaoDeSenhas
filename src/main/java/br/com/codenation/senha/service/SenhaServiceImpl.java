package br.com.codenation.senha.service;

import br.com.codenation.senha.model.Senha;
import br.com.codenation.senha.model.SenhaHistorico;
import br.com.codenation.senha.model.TipoSenha;
import br.com.codenation.senha.repository.SenhaHistoricoRepository;
import br.com.codenation.senha.repository.SenhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SenhaServiceImpl implements SenhaService {

    @Autowired
    private SenhaRepository senhaRepository;

    private SenhaHistoricoRepository senhaHistoricoRepository;

    @Override
    public List<Senha> findAll(Pageable pageable) {
         return this.senhaRepository.findAll(pageable).getContent();
    }

    //public List<Senha> search(String searchTerm, int page, int size) {
    //    PageRequest pageRequest = PageRequest.of(page,size,Sort.Direction.ASC, "descricao");
    //    return senhaRepository.search(searchTerm.toLowerCase(),pageRequest);
   // }

    @Override
    public Optional<Senha> findById(Long id) {
         return senhaRepository.findById(id);
    }

    @Override
    public Senha save(Senha senha) {
        return this.senhaRepository.save(senha);
    }

    @Override
    public void deleteById(Long id) {
         this.senhaRepository.deleteById(id);
    }

    @Override
    public Senha findByTipoSenha(TipoSenha tipoSenha) {

        Long proximaSenha = senhaRepository.findByTipoSenha(tipoSenha).getProximoNumero();

        //Pega a próxima senha, atualiza a tabela de senha e gera um registro
        //na tabela de historico de senha.
        Senha senha = new Senha();
        senha.setTipoSenha(tipoSenha);
        senha.setProximoNumero(proximaSenha+1);
        senhaRepository.save(senha);

        SenhaHistorico senhaHistorico = new SenhaHistorico();
        senhaHistorico.setDataGeracao(LocalDateTime.now());
        senhaHistorico.setNumero(proximaSenha+1);
        senhaHistorico.setTipoSenha(tipoSenha);
        senhaHistoricoRepository.save(senhaHistorico);

        return senha;
    }

    @Override
    public Senha findProximaSenha(TipoSenha tipoSenha) {
        Long proximaSenha = senhaRepository.findProximaSenha(tipoSenha).getProximoNumero();

        Senha senha = new Senha();
        senha.setTipoSenha(tipoSenha);
        senha.setProximoNumero(proximaSenha+1);
        //senhaRepository.updateProximaSenha(senha);

        return senhaRepository.save(senha);

    }


}
