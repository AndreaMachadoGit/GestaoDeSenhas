package br.com.codenation.senha.mapper;

import br.com.codenation.senha.dto.SenhaDTO;
import br.com.codenation.senha.model.Senha;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SenhaMapper {

    SenhaMapper INSTANCE = Mappers.getMapper( SenhaMapper.class );

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "proximoNumero", target = "proximoNumero"),
            @Mapping(source = "tipoSenha", target = "tipoSenha")
            //@Mapping(source = "data", target = "data", dateFormat = "yyyy-MM-dd HH:mm"),
    })
    SenhaDTO map(Senha senha);

    List<SenhaDTO> map(List<Senha> senhas);

    //Page<SenhaDTO> map(Page<Senha> eventosP);

}
