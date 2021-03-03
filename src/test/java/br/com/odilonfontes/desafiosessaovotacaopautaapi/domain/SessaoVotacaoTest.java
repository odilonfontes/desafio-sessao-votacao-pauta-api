package br.com.odilonfontes.desafiosessaovotacaopautaapi.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class SessaoVotacaoTest {

    @DisplayName("Ao instanciar objetos da classe SessaoVotacao")
    @Nested
    class AoInstanciarObjetosDaClasseSessaoVotacao {
        SessaoVotacao sessaoVotacao1;
        SessaoVotacao sessaoVotacao2;

        @BeforeEach
        void inicializarContexto() {
            sessaoVotacao1 = new SessaoVotacao();
            sessaoVotacao2 = new SessaoVotacao();
        }

        @DisplayName("Dado que possuam mesmo estado, deveriam ser iguais")
        @Test
        void verificarSeEstaoIguais() {
            sessaoVotacao1.setId(1L);
            LocalDateTime abertura = LocalDateTime.now();
            sessaoVotacao1.setAbertura(abertura);
            Pauta pauta = new Pauta();
            sessaoVotacao1.setPauta(pauta);
            LocalDateTime termino = LocalDateTime.now();
            sessaoVotacao1.setTermino(termino);
            sessaoVotacao2.setId(sessaoVotacao1.getId());
            sessaoVotacao2.setAbertura(sessaoVotacao1.getAbertura());
            sessaoVotacao2.setPauta(sessaoVotacao1.getPauta());
            sessaoVotacao2.setTermino(sessaoVotacao1.getTermino());
            assertThat(sessaoVotacao1).isEqualTo(sessaoVotacao2);
        }
    }

}
