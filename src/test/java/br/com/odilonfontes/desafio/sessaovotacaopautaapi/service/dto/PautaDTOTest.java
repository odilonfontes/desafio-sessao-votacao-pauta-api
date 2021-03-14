package br.com.odilonfontes.desafio.sessaovotacaopautaapi.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PautaDTOTest {

    @DisplayName("Ao instanciar objetos da classe PautaDTO")
    @Nested
    class AoInstanciarObjetosDaClassePautaDTO {
        PautaDTO pautaDTO1;
        PautaDTO pautaDTO2;

        @BeforeEach
        void inicializarContexto() {
            pautaDTO1 = new PautaDTO();
            pautaDTO2 = new PautaDTO();
        }

        @DisplayName("Dado que possuam mesmo estado, deveriam ser iguais")
        @Test
        void verificarSeEstaoIguais() {
            pautaDTO1.setId(1L);
            pautaDTO1.setTitulo("Título");
            pautaDTO1.setDescricao("Descrição");
            pautaDTO2.setId(pautaDTO1.getId());
            pautaDTO2.setTitulo(pautaDTO1.getTitulo());
            pautaDTO2.setDescricao(pautaDTO1.getDescricao());
            assertThat(pautaDTO1).isEqualTo(pautaDTO2);
        }
    }

}
