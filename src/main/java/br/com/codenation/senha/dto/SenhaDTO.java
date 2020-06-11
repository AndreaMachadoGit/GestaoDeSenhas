package br.com.codenation.senha.dto;

import br.com.codenation.senha.model.TipoSenha;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SenhaDTO {

    private Long id;
    private Long proximoNumero;
    private TipoSenha tipoSenha;

}
