package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.mapper;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.SessaoVotacao;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.AberturaSessaoVotacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PautaMapper.class})
public interface AberturaSessaoVotacaoMapper {

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "abertura")
    @Mapping(ignore = true, target = "termino")
    @Mapping(source = "pautaId", target = "pauta")
    @Mapping(source = "duracao", target = "duracao", defaultValue = "1")
    SessaoVotacao converterParaEntidade(AberturaSessaoVotacaoDTO aberturaSessaoVotacaoDTO);

}
