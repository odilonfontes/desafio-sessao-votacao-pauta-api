package br.com.odilonfontes.desafiosessaovotacaopautaapi.service;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.AberturaSessaoVotacaoDTO;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.SessaoVotacaoDTO;

public interface SessaoVotacaoService {

    SessaoVotacaoDTO salvar(AberturaSessaoVotacaoDTO aberturaSessaoVotacaoDTO);

}
