package br.com.odilonfontes.desafio.sessaovotacaoapi.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.odilonfontes.desafio.sessaovotacaoapi.domain.SessaoVotacao;
import br.com.odilonfontes.desafio.sessaovotacaoapi.repository.SessaoVotacaoRepository;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.SessaoVotacaoService;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.dto.AberturaSessaoVotacaoDTO;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.dto.SessaoVotacaoDTO;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.mapper.AberturaSessaoVotacaoMapper;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.mapper.SessaoVotacaoMapper;

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
