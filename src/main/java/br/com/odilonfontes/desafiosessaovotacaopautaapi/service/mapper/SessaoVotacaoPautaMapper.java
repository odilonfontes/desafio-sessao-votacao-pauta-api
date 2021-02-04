package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.mapper;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.SessaoVotacaoPauta;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.SessaoVotacaoPautaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface SessaoVotacaoPautaMapper {

    @Mapping(source = "pauta.id", target = "pautaId")
    SessaoVotacaoPautaDTO converterParaDTO(SessaoVotacaoPauta sessaoVotacaoPauta);

}
