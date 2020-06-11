package br.com.codenation.senha.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@Data
@Entity
public class SenhaHistorico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoSenha tipoSenha;

    @Min(0)
    @PositiveOrZero
    private Long numero;

    @CreatedDate
    private LocalDateTime dataGeracao;

    private LocalDateTime dataChamada;

}
