package br.com.codenation.senha.mapper;

import br.com.codenation.senha.dto.SenhaDTO;
import br.com.codenation.senha.model.Senha;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-11T19:32:40-0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_151 (Oracle Corporation)"
)
@Component
public class SenhaMapperImpl implements SenhaMapper {

    @Override
    public SenhaDTO map(Senha senha) {
        if ( senha == null ) {
            return null;
        }

        SenhaDTO senhaDTO = new SenhaDTO();

        senhaDTO.setTipoSenha( senha.getTipoSenha() );
        senhaDTO.setId( senha.getId() );
        senhaDTO.setProximoNumero( senha.getProximoNumero() );

        return senhaDTO;
    }

    @Override
    public List<SenhaDTO> map(List<Senha> senhas) {
        if ( senhas == null ) {
            return null;
        }

        List<SenhaDTO> list = new ArrayList<SenhaDTO>( senhas.size() );
        for ( Senha senha : senhas ) {
            list.add( map( senha ) );
        }

        return list;
    }
}
