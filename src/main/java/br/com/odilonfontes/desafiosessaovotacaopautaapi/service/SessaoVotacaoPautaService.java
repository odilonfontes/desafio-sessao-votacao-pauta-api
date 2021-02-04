package br.com.odilonfontes.desafiosessaovotacaopautaapi.service;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.SessaoVotacaoPautaAberturaDTO;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.SessaoVotacaoPautaDTO;

public interface SessaoVotacaoPautaService {

    SessaoVotacaoPautaDTO salvar(SessaoVotacaoPautaAberturaDTO sessaoVotacaoPautaAberturaDTO);

}
