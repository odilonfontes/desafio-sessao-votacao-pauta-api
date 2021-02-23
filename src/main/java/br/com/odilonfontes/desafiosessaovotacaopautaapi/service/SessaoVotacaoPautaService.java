package br.com.odilonfontes.desafiosessaovotacaopautaapi.service;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.AberturaSessaoVotacaoPautaDTO;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.SessaoVotacaoPautaDTO;

public interface SessaoVotacaoPautaService {

    SessaoVotacaoPautaDTO salvar(AberturaSessaoVotacaoPautaDTO sessaoVotacaoPautaAberturaDTO);

}
