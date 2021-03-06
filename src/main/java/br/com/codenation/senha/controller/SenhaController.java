package br.com.codenation.senha.controller;

import br.com.codenation.controller.advice.ResourceNotFoundException;
import br.com.codenation.senha.dto.SenhaDTO;
import br.com.codenation.senha.mapper.SenhaMapper;
import br.com.codenation.senha.model.Senha;
import br.com.codenation.senha.model.SenhaHistorico;
import br.com.codenation.senha.model.TipoSenha;
import br.com.codenation.senha.service.SenhaHistoricoService;
import br.com.codenation.senha.service.SenhaService;
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

@RestController
@RequestMapping("/senha")
public class SenhaController {

    @Autowired
    private SenhaService senhaService;

    @Autowired
    private SenhaHistoricoService senhaHistoricoService;

    List<SenhaDTO> senhaDTO;

    @PostMapping
    @ApiOperation("Cria um novo parâmetro de senha")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Parâmetro de senha criado com sucesso")})
    public ResponseEntity<Senha> create(@Valid @RequestBody Senha senha) {
        return new ResponseEntity<Senha>(this.senhaService.save(senha), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Atualiza um parâmetro de senha, para reiniciar a contagem, mover 1 para o próximo número.")
    public ResponseEntity<Senha> update(@Valid @RequestBody Senha senha) {
        return new ResponseEntity<Senha>(this.senhaService.save(senha), HttpStatus.ACCEPTED);
    }

    @GetMapping
    @ApiOperation("Lista todos os parâmetros de senha do APP")
    public Iterable<SenhaDTO> findAll(Pageable pageable) {
         return senhaDTO = SenhaMapper.INSTANCE.map(this.senhaService.findAll(pageable));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca um parâmetro de senha pelo Id")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Parâmetro de senha não localizado"), @ApiResponse(code = 200, message = "Parâmetro de senha localizado")})
    public ResponseEntity<Senha> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Senha>(this.senhaService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Senha")), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Exclui um parâmetro de senha pelo id")
    public void delete(@PathVariable("id") Long id) {
        this.senhaService.deleteById(id);
    }

    @GetMapping("/byTipoSenha/{tipoSenha}")
    @ApiOperation("Gera o valor da próxima senha pelo tipo da senha (NORMAL, PREFERENCIAL)")
    public Senha findByTipoSenha(@PathVariable("tipoSenha") TipoSenha tipoSenha,SenhaHistorico senhaHistorico) {
        return this.senhaService.findByTipoSenha(tipoSenha,senhaHistorico);
    }

}
