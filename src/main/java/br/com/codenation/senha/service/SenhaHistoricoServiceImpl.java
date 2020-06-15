package br.com.codenation.senha.service;

import br.com.codenation.senha.model.SenhaHistorico;
import br.com.codenation.senha.model.TipoSenha;
import br.com.codenation.senha.repository.SenhaHistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SenhaHistoricoServiceImpl implements SenhaHistoricoService {

    @Autowired
    private SenhaHistoricoRepository senhaHistoricoRepository;

    @Override
    public List<SenhaHistorico> findAll(Pageable pageable) {
        return this.senhaHistoricoRepository.findAll(pageable).getContent();
    }

     @Override
    public List<SenhaHistorico> findByTipoSenha(TipoSenha tipoSenha,Pageable pageable) {
        return this.senhaHistoricoRepository.findByTipoSenha(tipoSenha,pageable);
    }

    @Override
    public void deleteById(Long id) {
        this.senhaHistoricoRepository.deleteById(id);
    }

    @Override
    public Optional<SenhaHistorico> findById(Long id) {
        return senhaHistoricoRepository.findById(id);
    }

    @Override
    public SenhaHistorico save(SenhaHistorico senhaHistorico) {
        senhaHistorico.setDataGeracao(LocalDateTime.now());
        return this.senhaHistoricoRepository.save(senhaHistorico);
    }

    @Override
    public SenhaHistorico chamaProximaSenha(SenhaHistorico senhaHistorico) {

        senhaHistorico.setDataChamada(LocalDateTime.now());
        return this.senhaHistoricoRepository.save(senhaHistorico);

    }


}
