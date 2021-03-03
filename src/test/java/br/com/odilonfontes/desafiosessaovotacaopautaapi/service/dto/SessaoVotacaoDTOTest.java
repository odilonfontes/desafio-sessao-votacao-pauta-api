package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class SessaoVotacaoDTOTest {

    @DisplayName("Ao instanciar objetos da classe SessaoVotacaoDTO")
    @Nested
    class AoInstanciarObjetosDaClasseSessaoVotacaoDTO {
        SessaoVotacaoDTO sessaoVotacaoDTO1;
        SessaoVotacaoDTO sessaoVotacaoDTO2;

        @BeforeEach
        void inicializarContexto() {
            sessaoVotacaoDTO1 = new SessaoVotacaoDTO();
            sessaoVotacaoDTO2 = new SessaoVotacaoDTO();
        }

        @DisplayName("Dado que possuam mesmo estado, deveriam ser iguais")
        @Test
        void verificarSeEstaoIguais() {
            sessaoVotacaoDTO1.setId(1L);
            sessaoVotacaoDTO1.setAbertura(LocalDateTime.now());
            sessaoVotacaoDTO1.setPautaId(2L);
            sessaoVotacaoDTO1.setTermino(LocalDateTime.now());
            sessaoVotacaoDTO2.setId(sessaoVotacaoDTO1.getId());
            sessaoVotacaoDTO2.setAbertura(sessaoVotacaoDTO1.getAbertura());
            sessaoVotacaoDTO2.setPautaId(sessaoVotacaoDTO1.getPautaId());
            sessaoVotacaoDTO2.setTermino(sessaoVotacaoDTO1.getTermino());
            assertThat(sessaoVotacaoDTO1).isEqualTo(sessaoVotacaoDTO2);
        }
    }

}
