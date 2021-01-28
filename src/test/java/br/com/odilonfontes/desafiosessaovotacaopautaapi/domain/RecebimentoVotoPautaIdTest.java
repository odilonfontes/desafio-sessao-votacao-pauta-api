package br.com.odilonfontes.desafiosessaovotacaopautaapi.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecebimentoVotoPautaIdTest {

    @DisplayName("Ao instanciar objetos da classe RecebimentoVotoPautaId")
    @Nested
    class AoInstanciarObjetosDaClasseRecebimentoVotoPautaId {
        RecebimentoVotoPautaId recebimentoVotoPautaId1;
        RecebimentoVotoPautaId recebimentoVotoPautaId2;

        @BeforeEach
        void inicializarContexto() {
            recebimentoVotoPautaId1 = new RecebimentoVotoPautaId();
            recebimentoVotoPautaId2 = new RecebimentoVotoPautaId();
        }

        @DisplayName("Dado que possuam mesmo estado, deveriam ser iguais")
        @Test
        void verificarSeEstaoIguais() {
            SessaoVotacaoPauta sessaoVotacaoPauta = new SessaoVotacaoPauta();
            recebimentoVotoPautaId1.setSessaoVotacaoPauta(sessaoVotacaoPauta);
            Associado associado = new Associado();
            recebimentoVotoPautaId1.setAssociado(associado);
            recebimentoVotoPautaId2.setSessaoVotacaoPauta(recebimentoVotoPautaId1.getSessaoVotacaoPauta());
            recebimentoVotoPautaId2.setAssociado(recebimentoVotoPautaId1.getAssociado());
            assertThat(recebimentoVotoPautaId1).isEqualTo(recebimentoVotoPautaId2);
        }
    }

}
