package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class SessaoVotacaoPautaDTOTest {

    @DisplayName("Ao instanciar objetos da classe SessaoVotacaoPautaDTO")
    @Nested
    class AoInstanciarObjetosDaClasseSessaoVotacaoPautaDTO {
        SessaoVotacaoPautaDTO sessaoVotacaoPautaDTO1;
        SessaoVotacaoPautaDTO sessaoVotacaoPautaDTO2;

        @BeforeEach
        void inicializarContexto() {
            sessaoVotacaoPautaDTO1 = new SessaoVotacaoPautaDTO();
            sessaoVotacaoPautaDTO2 = new SessaoVotacaoPautaDTO();
        }

        @DisplayName("Dado que possuam mesmo estado, deveriam ser iguais")
        @Test
        void verificarSeEstaoIguais() {
            sessaoVotacaoPautaDTO1.setId(1L);
            sessaoVotacaoPautaDTO1.setAbertura(LocalDateTime.now());
            sessaoVotacaoPautaDTO1.setPautaId(2L);
            sessaoVotacaoPautaDTO1.setTermino(LocalDateTime.now());
            sessaoVotacaoPautaDTO2.setId(sessaoVotacaoPautaDTO1.getId());
            sessaoVotacaoPautaDTO2.setAbertura(sessaoVotacaoPautaDTO1.getAbertura());
            sessaoVotacaoPautaDTO2.setPautaId(sessaoVotacaoPautaDTO1.getPautaId());
            sessaoVotacaoPautaDTO2.setTermino(sessaoVotacaoPautaDTO1.getTermino());
            assertThat(sessaoVotacaoPautaDTO1).isEqualTo(sessaoVotacaoPautaDTO2);
        }
    }

}
