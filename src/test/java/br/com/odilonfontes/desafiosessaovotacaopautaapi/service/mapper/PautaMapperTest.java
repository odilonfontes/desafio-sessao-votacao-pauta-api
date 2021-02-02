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

    @DisplayName("Ao instanciar um objeto da classe PautaDTO")
    @Nested
    class AoInstanciarUmObjetoDaClassePautaDTO {
        PautaDTO pautaDTO;

        @BeforeEach
        void inicializarContexto() {
            pautaDTO = new PautaDTO();
        }

        @DisplayName("Dado que convertido para entidade, deveriam possuir mesmo estado")
        @Test
        void verificarSePossuemMesmoEstado() {
            pautaDTO.setId(1L);
            pautaDTO.setTitulo("Título");
            pautaDTO.setDescricao("Descrição");
            Pauta pauta = pautaMapper.converterParaEntidade(pautaDTO);
            assertEquals(pautaDTO.getId(), pauta.getId());
            assertEquals(pautaDTO.getTitulo(), pauta.getTitulo());
            assertEquals(pautaDTO.getDescricao(), pauta.getDescricao());
        }
    }

    @DisplayName("Ao instanciar um objeto da classe Pauta")
    @Nested
    class AoInstanciarUmObjetoDaClassePauta {
        Pauta pauta;

        @BeforeEach
        void inicializarContexto() {
            pauta = new Pauta();
        }

        @DisplayName("Dado que convertido para DTO, deveriam possuir mesmo estado")
        @Test
        void verificarSeEstaoIguais() {
            pauta.setId(1L);
            pauta.setTitulo("Título");
            pauta.setDescricao("Descrição");
            PautaDTO pautaDTO = pautaMapper.converterParaDTO(pauta);
            assertEquals(pauta.getId(), pautaDTO.getId());
            assertEquals(pauta.getTitulo(), pautaDTO.getTitulo());
            assertEquals(pauta.getDescricao(), pautaDTO.getDescricao());
        }
    }

}
