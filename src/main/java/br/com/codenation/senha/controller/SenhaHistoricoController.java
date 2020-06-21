package br.com.codenation.senha.controller;


import br.com.codenation.controller.advice.ResourceNotFoundException;
import br.com.codenation.senha.dto.SenhaDTO;
import br.com.codenation.senha.mapper.SenhaMapper;
import br.com.codenation.senha.model.Senha;
import br.com.codenation.senha.model.SenhaHistorico;
import br.com.codenation.senha.model.TipoSenha;
import br.com.codenation.senha.service.SenhaHistoricoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/senhaHistorico")
public class SenhaHistoricoController {

    @Autowired
    private SenhaHistoricoService senhaHistoricoService;

    @PostMapping
    @ApiOperation("Cria um novo registro de historico de senha")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Senha gerada com sucesso")})
    public ResponseEntity<SenhaHistorico> create(@Valid @RequestBody SenhaHistorico senhaHistorico) {
        return new ResponseEntity<SenhaHistorico>(this.senhaHistoricoService.save(senhaHistorico), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Atualiza uma senha gerada")
    public ResponseEntity<SenhaHistorico> update(@Valid @RequestBody SenhaHistorico senhaHistorico) {
        return new ResponseEntity<SenhaHistorico>(this.senhaHistoricoService.save(senhaHistorico), HttpStatus.ACCEPTED);
    }

    @GetMapping
    @ApiOperation("Lista todos os histórico das senhas geradas pelo APP")
    public List<SenhaHistorico> findAll(Pageable pageable) {
        return this.senhaHistoricoService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca uma senha gerada pelo Id")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Senha não localizada"), @ApiResponse(code = 200, message = "Senha localizada")})
    public ResponseEntity<SenhaHistorico> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<SenhaHistorico>(this.senhaHistoricoService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SenhaHistorico")), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Exclui uma senha gerada pelo id")
    public void delete(@PathVariable("id") Long id) {
        this.senhaHistoricoService.deleteById(id);
    }

    @GetMapping("/byTipoSenha/{tipoSenha}")
    @ApiOperation("Busca uma lista de senhas geradas pelo tipo da senha (NORMAL, PRIORITARIO)")
    public List<SenhaHistorico> findByTipoSenha(@PathVariable("tipoSenha") TipoSenha tipoSenha, Pageable pageable) {
        return this.senhaHistoricoService.findByTipoSenha(tipoSenha,pageable);
    }

    @GetMapping("/chamaProximaSenha")
    @ApiOperation("Busca a próxima senha a ser chamada - priorizando as senhas PREFERENCIAIS")
    public SenhaHistorico chamaProximaSenha(SenhaHistorico senhaHistorico,Pageable pageable) {
        //Penso que aqui eu teria que popular o objeto senhahistorico com a proxima senha
        //para poder passar no return esse objeto já populado
        //senhaHistorico = senhaHistoricoService.findAll(pageable).stream().filter(s -> s.getDataChamada() <= '00/00/0000').get();

        return this.senhaHistoricoService.chamaProximaSenha(senhaHistorico);
    }


}
