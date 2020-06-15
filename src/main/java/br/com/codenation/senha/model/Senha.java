package br.com.codenation.senha.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
public class Senha {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoSenha tipoSenha;

    @Min(1)
    @PositiveOrZero
    private Long proximoNumero;

}
