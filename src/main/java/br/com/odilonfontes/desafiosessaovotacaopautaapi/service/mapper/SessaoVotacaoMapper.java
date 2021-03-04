package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.mapper;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.SessaoVotacao;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.SessaoVotacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface SessaoVotacaoMapper {

    @Mapping(source = "pauta.id", target = "pautaId")
    SessaoVotacaoDTO converterParaDTO(SessaoVotacao sessaoVotaca);

}