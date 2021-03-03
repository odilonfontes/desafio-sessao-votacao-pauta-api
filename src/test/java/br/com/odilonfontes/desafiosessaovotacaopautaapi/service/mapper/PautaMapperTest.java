package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.mapper;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.Pauta;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.PautaDTO;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PautaMapperTest {

    static PautaMapper pautaMapper;

    @BeforeAll
    static void inicializarContexto() {
        pautaMapper = new PautaMapperImpl();
    }

    @DisplayName("Ao chamar o método converterParaDTO")
    @Nested
    class AoChamarMetodoConverterParaDTO {
        Pauta pauta;

        @BeforeEach
        void inicializarContexto() {
            pauta = new Pauta();
        }

        @DisplayName("Dado que seja passada uma entidade como parâmetro, deveria converter para DTO")
        @Test
        void verificarSeEstaMapeado() {
            pauta.setId(1L);
            pauta.setTitulo("Título");
            pauta.setDescricao("Descrição");
            PautaDTO pautaDTO = pautaMapper.converterParaDTO(pauta);
            assertEquals(pauta.getId(), pautaDTO.getId());
            assertEquals(pauta.getTitulo(), pautaDTO.getTitulo());
            assertEquals(pauta.getDescricao(), pautaDTO.getDescricao());
        }
    }

    @DisplayName("Ao chamar o método converterParaEntidade")
    @Nested
    class AoChamarMetodoConverterParaEntidade {
        PautaDTO pautaDTO;

        @BeforeEach
        void inicializarContexto() {
            pautaDTO = new PautaDTO();
        }

        @DisplayName("Dado que seja passada um DTO como parâmetro, deveria converter para Entidade")
        @Test
        void verificarSeEstaMapeada() {
            pautaDTO.setId(1L);
            pautaDTO.setTitulo("Título");
            pautaDTO.setDescricao("Descrição");
            Pauta pauta = pautaMapper.converterParaEntidade(pautaDTO);
            assertEquals(pautaDTO.getId(), pauta.getId());
            assertEquals(pautaDTO.getTitulo(), pauta.getTitulo());
            assertEquals(pautaDTO.getDescricao(), pauta.getDescricao());
        }
    }

}
