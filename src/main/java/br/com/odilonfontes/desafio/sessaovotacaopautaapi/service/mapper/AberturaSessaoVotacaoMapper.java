package br.com.odilonfontes.desafio.sessaovotacaopautaapi.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.odilonfontes.desafio.sessaovotacaopautaapi.domain.SessaoVotacao;
import br.com.odilonfontes.desafio.sessaovotacaopautaapi.service.dto.AberturaSessaoVotacaoDTO;

@Mapper(componentModel = "spring", uses = {PautaMapper.class})
public interface AberturaSessaoVotacaoMapper {

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "abertura")
    @Mapping(ignore = true, target = "termino")
    @Mapping(source = "pautaId", target = "pauta")
    @Mapping(source = "duracao", target = "duracao", defaultValue = "1")
    SessaoVotacao converterParaEntidade(AberturaSessaoVotacaoDTO aberturaSessaoVotacaoDTO);

}
