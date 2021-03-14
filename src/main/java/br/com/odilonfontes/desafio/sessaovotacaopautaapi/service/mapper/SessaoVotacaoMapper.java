package br.com.odilonfontes.desafio.sessaovotacaopautaapi.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.odilonfontes.desafio.sessaovotacaopautaapi.domain.SessaoVotacao;
import br.com.odilonfontes.desafio.sessaovotacaopautaapi.service.dto.SessaoVotacaoDTO;

@Mapper(componentModel = "spring", uses = {})
public interface SessaoVotacaoMapper {

    @Mapping(source = "pauta.id", target = "pautaId")
    SessaoVotacaoDTO converterParaDTO(SessaoVotacao sessaoVotaca);

}
