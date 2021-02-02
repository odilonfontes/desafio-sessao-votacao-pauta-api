package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.impl;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.Pauta;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.repository.PautaRepository;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.PautaService;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.PautaDTO;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.mapper.PautaMapper;
import org.junit.jupiter.api.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PautaServiceImplTest {

    public static final String TITULO = "Título";
    public static final String DESCRICAO = "Descricção";

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
            pauta.setTitulo(TITULO);
            pauta.setDescricao(DESCRICAO);
            pautaDTO = gerarPautaDTO(pauta);
        }

        @DisplayName("Dado que possui dados válidos, deveria salvar")
        @Test
        void salvar() {
            when(pautaMapperMock.converterParaEntidade(any())).thenReturn(pauta);
            when(pautaRepositoryMock.save(any())).thenReturn(pauta);
            when(pautaMapperMock.converterParaDTO(any())).thenReturn(pautaDTO);
            pautaDTO = pautaService.salvar(any());
            verify(pautaMapperMock, times(1)).converterParaEntidade(any());
            verify(pautaRepositoryMock, times(1)).save(any());
            verify(pautaMapperMock, times(1)).converterParaDTO(any());
        }
    }

    static PautaDTO gerarPautaDTO(Pauta pauta) {
        PautaDTO pautaDTO = new PautaDTO();
        pautaDTO.setId(pauta.getId());
        pautaDTO.setTitulo(pauta.getTitulo());
        pautaDTO.setDescricao(pauta.getDescricao());
        return pautaDTO;
    }

}
