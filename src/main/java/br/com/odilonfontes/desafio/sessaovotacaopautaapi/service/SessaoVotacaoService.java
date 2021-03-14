package br.com.odilonfontes.desafio.sessaovotacaopautaapi.service;

import br.com.odilonfontes.desafio.sessaovotacaopautaapi.service.dto.AberturaSessaoVotacaoDTO;
import br.com.odilonfontes.desafio.sessaovotacaopautaapi.service.dto.SessaoVotacaoDTO;

public interface SessaoVotacaoService {

    SessaoVotacaoDTO salvar(AberturaSessaoVotacaoDTO aberturaSessaoVotacaoDTO);

}
