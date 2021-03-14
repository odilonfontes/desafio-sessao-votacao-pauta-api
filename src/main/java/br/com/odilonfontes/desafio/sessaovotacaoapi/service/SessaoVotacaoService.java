package br.com.odilonfontes.desafio.sessaovotacaoapi.service;

import br.com.odilonfontes.desafio.sessaovotacaoapi.service.dto.AberturaSessaoVotacaoDTO;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.dto.SessaoVotacaoDTO;

public interface SessaoVotacaoService {

    SessaoVotacaoDTO salvar(AberturaSessaoVotacaoDTO aberturaSessaoVotacaoDTO);

}
