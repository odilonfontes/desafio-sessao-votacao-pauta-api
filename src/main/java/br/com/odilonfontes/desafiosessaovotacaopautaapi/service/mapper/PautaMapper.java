package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.mapper;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.Pauta;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.PautaDTO;
import org.mapstruct.Mapper;

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
