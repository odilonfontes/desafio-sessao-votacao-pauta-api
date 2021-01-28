package br.com.odilonfontes.desafiosessaovotacaopautaapi.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class SessaoVotacaoPautaTest {

    @DisplayName("Ao instanciar objetos da classe SessaoVotacaoPauta")
    @Nested
    class AoInstanciarObjetosDaClasseSessaoVotacaoPauta {
        SessaoVotacaoPauta sessaoVotacaoPauta1;
        SessaoVotacaoPauta sessaoVotacaoPauta2;

        @BeforeEach
        void inicializarContexto() {
            sessaoVotacaoPauta1 = new SessaoVotacaoPauta();
            sessaoVotacaoPauta2 = new SessaoVotacaoPauta();
        }

        @DisplayName("Dado que possuam mesmo estado, deveriam ser iguais")
        @Test
        void verificarSeEstaoIguais() {
            sessaoVotacaoPauta1.setId(1L);
            LocalDateTime abertura = LocalDateTime.now();
            sessaoVotacaoPauta1.setAbertura(abertura);
            Pauta pauta = new Pauta();
            sessaoVotacaoPauta1.setPauta(pauta);
            LocalDateTime termino = LocalDateTime.now();
            sessaoVotacaoPauta1.setTermino(termino);
            sessaoVotacaoPauta2.setId(sessaoVotacaoPauta1.getId());
            sessaoVotacaoPauta2.setAbertura(sessaoVotacaoPauta1.getAbertura());
            sessaoVotacaoPauta2.setPauta(sessaoVotacaoPauta1.getPauta());
            sessaoVotacaoPauta2.setTermino(sessaoVotacaoPauta1.getTermino());
            assertThat(sessaoVotacaoPauta1).isEqualTo(sessaoVotacaoPauta2);
        }
    }

}
