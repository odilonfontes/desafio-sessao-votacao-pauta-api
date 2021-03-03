package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.impl;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.SessaoVotacao;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.repository.SessaoVotacaoRepository;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.SessaoVotacaoService;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.AberturaSessaoVotacaoDTO;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.SessaoVotacaoDTO;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.mapper.AberturaSessaoVotacaoMapper;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.mapper.SessaoVotacaoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SessaoVotacaoServiceImpl implements SessaoVotacaoService {

    private final AberturaSessaoVotacaoMapper aberturaSessaoVotacaoMapper;
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final SessaoVotacaoMapper sessaoVotacaoMapper;

    public SessaoVotacaoServiceImpl(AberturaSessaoVotacaoMapper aberturaSessaoVotacaoMapper,
                                         SessaoVotacaoRepository sessaoVotacaoRepository,
                                         SessaoVotacaoMapper sessaoVotacaoMapper) {
        this.aberturaSessaoVotacaoMapper = aberturaSessaoVotacaoMapper;
        this.sessaoVotacaoRepository = sessaoVotacaoRepository;
        this.sessaoVotacaoMapper = sessaoVotacaoMapper;
    }

    @Override
    public SessaoVotacaoDTO salvar(AberturaSessaoVotacaoDTO aberturaSessaoVotacaoDTO) {
        SessaoVotacao sessaoVotacao = aberturaSessaoVotacaoMapper
                .converterParaEntidade(aberturaSessaoVotacaoDTO);
        sessaoVotacaoRepository.save(sessaoVotacao);
        return sessaoVotacaoMapper.converterParaDTO(sessaoVotacao);
    }

}
