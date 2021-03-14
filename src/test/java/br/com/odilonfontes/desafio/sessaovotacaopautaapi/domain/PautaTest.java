package br.com.odilonfontes.desafio.sessaovotacaopautaapi.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PautaTest {

    @DisplayName("Ao instanciar objetos da classe Pauta")
    @Nested
    class AoInstanciarObjetosDaClassePauta {
        Pauta pauta1;
        Pauta pauta2;

        @BeforeEach
        void inicializarContexto() {
            pauta1 = new Pauta();
            pauta2 = new Pauta();
        }

        @DisplayName("Dado que possuam mesmo estado, deveriam ser iguais")
        @Test
        void verificarSeEstaoIguais() {
            pauta1.setId(1L);
            pauta1.setTitulo("Título");
            pauta1.setDescricao("Descrição");
            pauta2.setId(pauta1.getId());
            pauta2.setTitulo(pauta1.getTitulo());
            pauta2.setDescricao(pauta1.getDescricao());
            assertThat(pauta1).isEqualTo(pauta2);
        }
    }

}
