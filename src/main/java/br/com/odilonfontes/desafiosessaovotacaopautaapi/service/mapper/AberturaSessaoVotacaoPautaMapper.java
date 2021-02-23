package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.mapper;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.SessaoVotacaoPauta;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.AberturaSessaoVotacaoPautaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PautaMapper.class})
public interface AberturaSessaoVotacaoPautaMapper {

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "abertura")
    @Mapping(ignore = true, target = "termino")
    @Mapping(source = "pautaId", target = "pauta")
    @Mapping(source = "duracao", target = "duracao", defaultValue = "1")
    SessaoVotacaoPauta converterParaEntidade(AberturaSessaoVotacaoPautaDTO sessaoVotacaoPautaAberturaDTO);

}
