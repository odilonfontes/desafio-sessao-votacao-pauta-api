package br.com.odilonfontes.desafio.sessaovotacaopautaapi.service;

import java.util.Set;

import br.com.odilonfontes.desafio.sessaovotacaopautaapi.service.dto.PautaDTO;

public interface PautaService {

    PautaDTO salvar(PautaDTO pautaDTO);

    Set<PautaDTO> consultarTodasPautas();

}
