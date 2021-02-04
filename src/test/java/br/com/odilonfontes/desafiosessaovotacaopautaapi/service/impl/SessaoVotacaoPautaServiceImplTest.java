package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.impl;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.Pauta;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.SessaoVotacaoPauta;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.repository.SessaoVotacaoPautaRepository;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.SessaoVotacaoPautaService;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.SessaoVotacaoPautaDTO;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.mapper.AberturaSessaoVotacaoPautaMapper;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.mapper.SessaoVotacaoPautaMapper;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class SessaoVotacaoPautaServiceImplTest {

    static SessaoVotacaoPautaService sessaoVotacaoPautaService;
    static AberturaSessaoVotacaoPautaMapper aberturaSessaoVotacaoPautaMapperMock;
    static SessaoVotacaoPautaRepository sessaoVotacaoPautaRepositoryMock;
    static SessaoVotacaoPautaMapper sessaoVotacaoPautaMapperMock;

    @BeforeAll
    static void inicializarContexto() {
        aberturaSessaoVotacaoPautaMapperMock = mock(AberturaSessaoVotacaoPautaMapper.class);
        sessaoVotacaoPautaRepositoryMock = mock(SessaoVotacaoPautaRepository.class);
        sessaoVotacaoPautaMapperMock = mock(SessaoVotacaoPautaMapper.class);
        sessaoVotacaoPautaService = new SessaoVotacaoPautaServiceImpl(aberturaSessaoVotacaoPautaMapperMock,
                sessaoVotacaoPautaRepositoryMock, sessaoVotacaoPautaMapperMock);
    }

    @DisplayName("Ao chamar o método salvar")
    @Nested
    class AoChamarMetodoSalvar {
        SessaoVotacaoPauta sessaoVotacaoPauta;
        SessaoVotacaoPautaDTO sessaoVotacaoPautaDTO;

        @BeforeEach
        void inicializarContexto() {
            sessaoVotacaoPauta = new SessaoVotacaoPauta();
            sessaoVotacaoPauta.setId(1L);
            sessaoVotacaoPauta.setAbertura(LocalDateTime.now());
            Pauta pauta = new Pauta();
            pauta.setId(2L);
            sessaoVotacaoPauta.setPauta(pauta);
            sessaoVotacaoPauta.setTermino(LocalDateTime.now().plusMinutes(1));
            sessaoVotacaoPautaDTO = gerarSessaoVotacaoPautaDTO(sessaoVotacaoPauta);
        }

        @DisplayName("Dado que possui dados válidos, deveria salvar")
        @Test
        void salvar() {
            when(aberturaSessaoVotacaoPautaMapperMock.converterParaEntidade(any())).thenReturn(sessaoVotacaoPauta);
            when(sessaoVotacaoPautaRepositoryMock.save(any())).thenReturn(sessaoVotacaoPauta);
            when(sessaoVotacaoPautaMapperMock.converterParaDTO(any())).thenReturn(sessaoVotacaoPautaDTO);
            sessaoVotacaoPautaDTO = sessaoVotacaoPautaService.salvar(any());
            verify(aberturaSessaoVotacaoPautaMapperMock, times(1)).converterParaEntidade(any());
            verify(sessaoVotacaoPautaRepositoryMock, times(1)).save(any());
            verify(sessaoVotacaoPautaMapperMock, times(1)).converterParaDTO(any());
        }
    }

    static SessaoVotacaoPautaDTO gerarSessaoVotacaoPautaDTO(SessaoVotacaoPauta sessaoVotacaoPauta) {
        SessaoVotacaoPautaDTO sessaoVotacaoPautaDTO = new SessaoVotacaoPautaDTO();
        sessaoVotacaoPautaDTO.setId(sessaoVotacaoPauta.getId());
        sessaoVotacaoPautaDTO.setAbertura(sessaoVotacaoPauta.getAbertura());
        sessaoVotacaoPautaDTO.setPautaId(sessaoVotacaoPauta.getPauta().getId());
        sessaoVotacaoPautaDTO.setTermino(sessaoVotacaoPauta.getTermino());
        return sessaoVotacaoPautaDTO;
    }

}
