package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.impl;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.Pauta;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.repository.PautaRepository;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.PautaService;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.PautaDTO;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.mapper.PautaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PautaServiceImpl implements PautaService {

    private final PautaRepository pautaRepository;
    private final PautaMapper pautaMapper;

    public PautaServiceImpl(PautaRepository pautaRepository, PautaMapper pautaMapper) {
        this.pautaRepository = pautaRepository;
        this.pautaMapper = pautaMapper;
    }

    @Override
    public PautaDTO salvar(PautaDTO pautaDTO) {
        Pauta pauta = pautaMapper.converterParaEntidade(pautaDTO);
        pauta = pautaRepository.save(pauta);
        return pautaMapper.converterParaDTO(pauta);
    }

}
