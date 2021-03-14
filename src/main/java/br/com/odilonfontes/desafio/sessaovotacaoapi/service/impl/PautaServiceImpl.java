package br.com.odilonfontes.desafio.sessaovotacaoapi.service.impl;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.odilonfontes.desafio.sessaovotacaoapi.domain.Pauta;
import br.com.odilonfontes.desafio.sessaovotacaoapi.repository.PautaRepository;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.PautaService;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.dto.PautaDTO;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.mapper.PautaMapper;

@Service
@Transactional
public class PautaServiceImpl implements PautaService {

    private final PautaMapper pautaMapper;
    private final PautaRepository pautaRepository;

    public PautaServiceImpl(PautaRepository pautaRepository, PautaMapper pautaMapper) {
        this.pautaMapper = pautaMapper;
        this.pautaRepository = pautaRepository;
    }

    @Override
    public PautaDTO salvar(PautaDTO pautaDTO) {
        Pauta pauta = pautaMapper.converterParaEntidade(pautaDTO);
        pauta = pautaRepository.save(pauta);
        return pautaMapper.converterParaDTO(pauta);
    }

    @Override
    public Set<PautaDTO> consultarTodasPautas() {
        return pautaRepository.findAll().stream().map(pautaMapper::converterParaDTO).collect(Collectors.toSet());
    }

}
