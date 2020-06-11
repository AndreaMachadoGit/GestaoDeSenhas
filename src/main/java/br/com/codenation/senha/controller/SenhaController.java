package br.com.codenation.senha.controller;

import br.com.codenation.controller.advice.ResourceNotFoundException;
import br.com.codenation.senha.dto.SenhaDTO;
import br.com.codenation.senha.mapper.SenhaMapper;
import br.com.codenation.senha.model.Senha;
import br.com.codenation.senha.model.TipoSenha;
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
    List<SenhaDTO> senhaDTO;

    @PostMapping
    @ApiOperation("Cria um novo parâmetro de senha")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Parâmetro de senha criado com sucesso")})
    public ResponseEntity<Senha> create(@Valid @RequestBody Senha senha) {
        return new ResponseEntity<Senha>(this.senhaService.save(senha), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Atualiza um parâmetro de senha")
    public ResponseEntity<Senha> update(@Valid @RequestBody Senha senha) {
        return new ResponseEntity<Senha>(this.senhaService.save(senha), HttpStatus.ACCEPTED);
    }

    @GetMapping
    @ApiOperation("Lista todos os parâmetros de senha da APP")
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
    @ApiOperation("Exclui um parâmetro de senha")
    public void delete(@PathVariable("id") Long id) {
        this.senhaService.deleteById(id);
    }

    @GetMapping("/byTipoSenha/{tipoSenha}")
    @ApiOperation("Busca uma lista de parâmetros de erros pelo tipo da senha (NORMAL, PRIORITARIO)")
    public List<Senha> findByTipoSenha(@PathVariable("tipoSenha") TipoSenha tipoSenha, Pageable pageable) {
        return this.senhaService.findByTipoSenha(tipoSenha,pageable);
    }

    //@GetMapping("/search/{searchTerm}")
    //@ApiOperation("Efetua a busca no banco de dados pelo conteúdo dos campos Descrição ou Origem")
    //public Iterable<SenhaDTO> search(
     //       @PathVariable("searchTerm") String searchTerm,
     //       @RequestParam(value = "page",required = false,defaultValue = "0") int page,
     //       @RequestParam(value = "size",required = false,defaultValue = "10") int size) {
     //   return senhaDTO = SenhaMapper.INSTANCE.map(senhaService.search(searchTerm, page, size));
    //}

}
