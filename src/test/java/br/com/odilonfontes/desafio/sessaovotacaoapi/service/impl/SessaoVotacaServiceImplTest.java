package br.com.odilonfontes.desafio.sessaovotacaoapi.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import br.com.odilonfontes.desafio.sessaovotacaoapi.domain.Pauta;
import br.com.odilonfontes.desafio.sessaovotacaoapi.domain.SessaoVotacao;
import br.com.odilonfontes.desafio.sessaovotacaoapi.repository.SessaoVotacaoRepository;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.SessaoVotacaoService;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.dto.SessaoVotacaoDTO;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.mapper.AberturaSessaoVotacaoMapper;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.mapper.SessaoVotacaoMapper;

public class SessaoVotacaServiceImplTest {

    static SessaoVotacaoService sessaoVotacaoService;
    static AberturaSessaoVotacaoMapper aberturaSessaoVotacaoMapperMock;
    static SessaoVotacaoRepository sessaoVotacaoRepositoryMock;
    static SessaoVotacaoMapper sessaoVotacaoMapperMock;

    @BeforeAll
    static void inicializarContexto() {
        aberturaSessaoVotacaoMapperMock = mock(AberturaSessaoVotacaoMapper.class);
        sessaoVotacaoRepositoryMock = mock(SessaoVotacaoRepository.class);
        sessaoVotacaoMapperMock = mock(SessaoVotacaoMapper.class);
        sessaoVotacaoService = new SessaoVotacaoServiceImpl(aberturaSessaoVotacaoMapperMock,
                sessaoVotacaoRepositoryMock, sessaoVotacaoMapperMock);
    }

    @DisplayName("Ao chamar o método salvar")
    @Nested
    class AoChamarMetodoSalvar {
        SessaoVotacao sessaoVotacao;
        SessaoVotacaoDTO sessaoVotacaoDTO;

        @BeforeEach
        void inicializarContexto() {
            sessaoVotacao = new SessaoVotacao();
            sessaoVotacao.setId(1L);
            sessaoVotacao.setAbertura(LocalDateTime.now());
            Pauta pauta = new Pauta();
            pauta.setId(2L);
            sessaoVotacao.setPauta(pauta);
            sessaoVotacao.setTermino(LocalDateTime.now().plusMinutes(1));
            sessaoVotacaoDTO = gerarSessaoVotacaoDTO(sessaoVotacao);
        }

        @DisplayName("Dado que possui dados válidos, deveria salvar")
        @Test
        void salvar() {
            when(aberturaSessaoVotacaoMapperMock.converterParaEntidade(any())).thenReturn(sessaoVotacao);
            when(sessaoVotacaoRepositoryMock.save(any())).thenReturn(sessaoVotacao);
            when(sessaoVotacaoMapperMock.converterParaDTO(any())).thenReturn(sessaoVotacaoDTO);
            sessaoVotacaoDTO = sessaoVotacaoService.salvar(any());
            verify(aberturaSessaoVotacaoMapperMock, times(1)).converterParaEntidade(any());
            verify(sessaoVotacaoRepositoryMock, times(1)).save(any());
            verify(sessaoVotacaoMapperMock, times(1)).converterParaDTO(any());
        }
    }

    static SessaoVotacaoDTO gerarSessaoVotacaoDTO(SessaoVotacao sessaoVotacao) {
        SessaoVotacaoDTO sessaoVotacaoDTO = new SessaoVotacaoDTO();
        sessaoVotacaoDTO.setId(sessaoVotacao.getId());
        sessaoVotacaoDTO.setAbertura(sessaoVotacao.getAbertura());
        sessaoVotacaoDTO.setPautaId(sessaoVotacao.getPauta().getId());
        sessaoVotacaoDTO.setTermino(sessaoVotacao.getTermino());
        return sessaoVotacaoDTO;
    }

}
