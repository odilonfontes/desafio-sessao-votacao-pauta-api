package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.mapper;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.Pauta;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.PautaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PautaMapper {

    PautaDTO converterParaDTO(Pauta pauta);
    Pauta converterParaEntidade(PautaDTO pautaDTO);

}
