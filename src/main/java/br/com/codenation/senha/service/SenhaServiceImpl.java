package br.com.codenation.senha.service;

import br.com.codenation.senha.model.Senha;
import br.com.codenation.senha.model.SenhaHistorico;
import br.com.codenation.senha.model.TipoSenha;
import br.com.codenation.senha.repository.SenhaHistoricoRepository;
import br.com.codenation.senha.repository.SenhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SenhaServiceImpl implements SenhaService {

    @Autowired
    private SenhaRepository senhaRepository;

    @Autowired
    private SenhaHistoricoRepository senhaHistoricoRepository;

    @Override
    public List<Senha> findAll(Pageable pageable) {
         return this.senhaRepository.findAll(pageable).getContent();
    }

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
    public Senha findByTipoSenha(TipoSenha tipoSenha,SenhaHistorico senhaHistorico) {

        //Long proximaSenha = senhaRepository.findByTipoSenha(tipoSenha).getProximoNumero();

        //Pega a próxima senha, atualiza a tabela de senha e gera um registro
        //na tabela de historico de senha.
        Senha senha = senhaRepository.findByTipoSenha(tipoSenha);
        senha.setTipoSenha(tipoSenha);
        senha.setProximoNumero(senha.getProximoNumero()+1);
        senhaRepository.save(senha);


        //senhaHistorico = new SenhaHistorico();
        SenhaHistoricoService senhaHistoricoService =  null;
        senhaHistoricoService.createNewSenha(tipoSenha,senha.getProximoNumero()-1);


        //senhaHistorico.setId(senhaHistoricoRepository.findMaxId()+1); // tem que pegar o proximo id, não consigo fazer trazer automatico
        //senhaHistorico.setDataGeracao(LocalDateTime.now());
        //senhaHistorico.setNumero(senha.getProximoNumero()-1);
        //senhaHistorico.setTipoSenha(senha.getTipoSenha());
        //senhaHistoricoRepository.createNewSenha(tipoSenha, senha.getProximoNumero());
        //senhaHistoricoRepository.save(senhaHistorico);
        return senha;
    }


}
