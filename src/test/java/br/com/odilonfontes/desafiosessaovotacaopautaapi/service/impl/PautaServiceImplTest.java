package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.impl;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.Pauta;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.repository.PautaRepository;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.PautaService;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.PautaDTO;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.mapper.PautaMapper;
import org.junit.jupiter.api.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Set;

public class PautaServiceImplTest {

    static PautaService pautaService;
    static PautaRepository pautaRepositoryMock;
    static PautaMapper pautaMapperMock;

    @BeforeAll
    static void inicializarContexto() {
        pautaRepositoryMock = mock(PautaRepository.class);
        pautaMapperMock = mock(PautaMapper.class);
        pautaService = new PautaServiceImpl(pautaRepositoryMock, pautaMapperMock);
    }

    @DisplayName("Ao chamar o método salvar")
    @Nested
    class AoChamarMetodoSalvar {
        Pauta pauta;
        PautaDTO pautaDTO;

        @BeforeEach
        void inicializarContexto() {
            pauta = new Pauta();
            pautaDTO = new PautaDTO();
        }

        @DisplayName("Dado que possui dados válidos, deveria salvar")
        @Test
        void salvar() {
            when(pautaMapperMock.converterParaEntidade(any())).thenReturn(any());
            when(pautaRepositoryMock.save(pauta)).thenReturn(any());
            when(pautaMapperMock.converterParaDTO(pauta)).thenReturn(any());
            pautaDTO = pautaService.salvar(pautaDTO);
            verify(pautaMapperMock, times(1)).converterParaEntidade(any());
            verify(pautaRepositoryMock,times(1)).save(any());
            verify(pautaMapperMock, times(1)).converterParaDTO(any());
        }
    }

    @DisplayName("Ao chamar o método consultarTodasPautas")
    @Nested
    class AoChamarMetodoConsultar {
        Set<PautaDTO> pautasDTO;

        @DisplayName("Dado que possua pautas cadastradas, deveria retornar todas as pautas")
        @Test
        void consultarTodasPautas() {
            pautasDTO = pautaService.consultarTodasPautas();
            verify(pautaRepositoryMock, times(1)).findAll();
        }
    }

}
