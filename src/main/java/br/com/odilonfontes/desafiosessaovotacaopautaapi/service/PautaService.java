package br.com.odilonfontes.desafiosessaovotacaopautaapi.service;

import java.util.Set;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.PautaDTO;

public interface PautaService {

    PautaDTO salvar(PautaDTO pautaDTO);

    Set<PautaDTO> consultarTodasPautas();

}
