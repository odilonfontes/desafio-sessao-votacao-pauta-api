package br.com.odilonfontes.desafiosessaovotacaopautaapi.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssociadoTest {

    @DisplayName("Ao instanciar objetos da classe Associado")
    @Nested
    class AoInstanciarObjetosDaClasseAssociado {
        Associado associado1;
        Associado associado2;

        @BeforeEach
        void inicializarContexto() {
            associado1 = new Associado();
            associado2 = new Associado();
        }

        @DisplayName("Dado que possuam mesmo estado, deveriam ser iguais")
        @Test
        void verificarSeEstaoIguais() {
            associado1.setId(1L);
            associado1.setCpf("00123456789");
            associado2.setId(associado1.getId());
            associado2.setCpf(associado1.getCpf());
            assertThat(associado1).isEqualTo(associado2);
        }
    }

}
