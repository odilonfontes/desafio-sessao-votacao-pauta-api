package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.impl;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.SessaoVotacaoPauta;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.repository.SessaoVotacaoPautaRepository;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.SessaoVotacaoPautaService;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.SessaoVotacaoPautaAberturaDTO;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.SessaoVotacaoPautaDTO;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.mapper.AberturaSessaoVotacaoPautaMapper;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.mapper.SessaoVotacaoPautaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SessaoVotacaoPautaServiceImpl implements SessaoVotacaoPautaService {

    private final AberturaSessaoVotacaoPautaMapper aberturaSessaoVotacaoPautaMapper;
    private final SessaoVotacaoPautaRepository sessaoVotacaoPautaRepository;
    private final SessaoVotacaoPautaMapper sessaoVotacaoPautaMapper;

    public SessaoVotacaoPautaServiceImpl(AberturaSessaoVotacaoPautaMapper aberturaSessaoVotacaoPautaMapper,
                                         SessaoVotacaoPautaRepository sessaoVotacaoPautaRepository,
                                         SessaoVotacaoPautaMapper sessaoVotacaoPautaMapper) {
        this.aberturaSessaoVotacaoPautaMapper = aberturaSessaoVotacaoPautaMapper;
        this.sessaoVotacaoPautaRepository = sessaoVotacaoPautaRepository;
        this.sessaoVotacaoPautaMapper = sessaoVotacaoPautaMapper;
    }

    @Override
    public SessaoVotacaoPautaDTO salvar(SessaoVotacaoPautaAberturaDTO sessaoVotacaoPautaAberturaDTO) {
        SessaoVotacaoPauta sessaoVotacaoPauta = aberturaSessaoVotacaoPautaMapper
                .converterParaEntidade(sessaoVotacaoPautaAberturaDTO);
        sessaoVotacaoPautaRepository.save(sessaoVotacaoPauta);
        return sessaoVotacaoPautaMapper.converterParaDTO(sessaoVotacaoPauta);
    }

}
