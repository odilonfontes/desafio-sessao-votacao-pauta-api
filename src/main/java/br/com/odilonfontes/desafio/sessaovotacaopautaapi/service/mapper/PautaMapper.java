package br.com.odilonfontes.desafio.sessaovotacaopautaapi.service.mapper;

import org.mapstruct.Mapper;

import br.com.odilonfontes.desafio.sessaovotacaopautaapi.domain.Pauta;
import br.com.odilonfontes.desafio.sessaovotacaopautaapi.service.dto.PautaDTO;

@Mapper(componentModel = "spring", uses = {})
public interface PautaMapper {

    PautaDTO converterParaDTO(Pauta pauta);
    Pauta converterParaEntidade(PautaDTO pautaDTO);

    default Pauta gerarEntidade(Long id) {
        if (id == null) {
            return null;
        }
        Pauta pauta = new Pauta();
        pauta.setId(id);
        return pauta;
    }

}
