package br.com.odilonfontes.desafio.sessaovotacaoapi.service;

import java.util.Set;

import br.com.odilonfontes.desafio.sessaovotacaoapi.service.dto.PautaDTO;

public interface PautaService {

    PautaDTO salvar(PautaDTO pautaDTO);

    Set<PautaDTO> consultarTodasPautas();

}
