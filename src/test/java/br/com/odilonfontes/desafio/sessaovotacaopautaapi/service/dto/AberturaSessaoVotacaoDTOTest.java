package br.com.odilonfontes.desafio.sessaovotacaopautaapi.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class AberturaSessaoVotacaoDTOTest {

    @DisplayName("Ao instanciar objetos da classe AberturaSessaoVotacaoDTO")
    @Nested
    class AoInstanciarObjetosDaClasseAberturaSessaoVotacaoDTO {
        AberturaSessaoVotacaoDTO aberturaSessaoVotacaoDTO1;
        AberturaSessaoVotacaoDTO aberturaSessaoVotacaoDTO2;

        @BeforeEach
        void inicializarContexto() {
            aberturaSessaoVotacaoDTO1 = new AberturaSessaoVotacaoDTO();
            aberturaSessaoVotacaoDTO2 = new AberturaSessaoVotacaoDTO();
        }

        @DisplayName("Dado que possuam mesmo estado, deveriam ser iguais")
        @Test
        void verificarSeEstaoIguais() {
            aberturaSessaoVotacaoDTO1.setPautaId(1L);
            aberturaSessaoVotacaoDTO1.setDuracao(10);
            aberturaSessaoVotacaoDTO2.setPautaId(aberturaSessaoVotacaoDTO1.getPautaId());
            aberturaSessaoVotacaoDTO2.setDuracao(aberturaSessaoVotacaoDTO1.getDuracao());
            assertThat(aberturaSessaoVotacaoDTO1).isEqualTo(aberturaSessaoVotacaoDTO2);
        }
    }

}
