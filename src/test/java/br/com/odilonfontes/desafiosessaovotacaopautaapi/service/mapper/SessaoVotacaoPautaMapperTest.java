package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.mapper;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.Pauta;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.SessaoVotacaoPauta;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.SessaoVotacaoPautaDTO;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SessaoVotacaoPautaMapperTest {

    static SessaoVotacaoPautaMapper sessaoVotacaoPautaMapper;

    @BeforeAll
    static void inicializarContexto() {
        sessaoVotacaoPautaMapper = new SessaoVotacaoPautaMapperImpl();
    }

    @DisplayName("Ao instanciar um objeto da classe SessaoVotacaoPautaDTO")
    @Nested
    class AoInstanciarUmObjetoDaClasseSessaoVotacaoPautaDTO {
        SessaoVotacaoPauta sessaoVotacaoPauta;

        @BeforeEach
        void inicializarContexto() {
            sessaoVotacaoPauta = new SessaoVotacaoPauta();
        }

        @DisplayName("Dado que convertido para DTO, deveria gerar o DTO conforme mapeamento")
        @Test
        void verificarSeEstaMapeada() {
            sessaoVotacaoPauta.setId(1L);
            sessaoVotacaoPauta.setAbertura(LocalDateTime.now());
            Pauta pauta = new Pauta();
            pauta.setId(2L);
            sessaoVotacaoPauta.setPauta(pauta);
            sessaoVotacaoPauta.setTermino(LocalDateTime.now().plusMinutes(1));
            SessaoVotacaoPautaDTO sessaoVotacaoPautaDTO = sessaoVotacaoPautaMapper
                    .converterParaDTO(sessaoVotacaoPauta);
            assertEquals(sessaoVotacaoPauta.getId(), sessaoVotacaoPautaDTO.getId());
            assertEquals(sessaoVotacaoPauta.getAbertura(), sessaoVotacaoPautaDTO.getAbertura());
            assertEquals(sessaoVotacaoPauta.getPauta().getId(), sessaoVotacaoPautaDTO.getPautaId());
            assertEquals(sessaoVotacaoPauta.getTermino(), sessaoVotacaoPautaDTO.getTermino());
        }
    }

}
