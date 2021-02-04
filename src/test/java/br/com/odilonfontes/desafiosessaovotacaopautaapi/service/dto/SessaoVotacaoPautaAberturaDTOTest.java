package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SessaoVotacaoPautaAberturaDTOTest {

    @DisplayName("Ao instanciar objetos da classe AberturaDaSessaoVotacaoPautaDTO")
    @Nested
    class AoInstanciarObjetosDaClasseSessaoVotacaoPautaAberturaDTO {
        SessaoVotacaoPautaAberturaDTO sessaoVotacaoPautaAberturaDTO1;
        SessaoVotacaoPautaAberturaDTO sessaoVotacaoPautaAberturaDTO2;

        @BeforeEach
        void inicializarContexto() {
            sessaoVotacaoPautaAberturaDTO1 = new SessaoVotacaoPautaAberturaDTO();
            sessaoVotacaoPautaAberturaDTO2 = new SessaoVotacaoPautaAberturaDTO();
        }

        @DisplayName("Dado que possuam mesmo estado, deveriam ser iguais")
        @Test
        void verificarSeEstaoIguais() {
            sessaoVotacaoPautaAberturaDTO1.setPautaId(1L);
            sessaoVotacaoPautaAberturaDTO1.setDuracao(10);
            sessaoVotacaoPautaAberturaDTO2.setPautaId(sessaoVotacaoPautaAberturaDTO1.getPautaId());
            sessaoVotacaoPautaAberturaDTO2.setDuracao(sessaoVotacaoPautaAberturaDTO1.getDuracao());
            assertThat(sessaoVotacaoPautaAberturaDTO1).isEqualTo(sessaoVotacaoPautaAberturaDTO2);
        }
    }

}
