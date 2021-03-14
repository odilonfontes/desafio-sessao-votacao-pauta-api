package br.com.odilonfontes.desafio.sessaovotacaoapi.service.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import br.com.odilonfontes.desafio.sessaovotacaoapi.domain.Pauta;
import br.com.odilonfontes.desafio.sessaovotacaoapi.domain.SessaoVotacao;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.dto.SessaoVotacaoDTO;

public class SessaoVotacaoMapperTest {

    static SessaoVotacaoMapper sessaoVotacaoMapper;

    @BeforeAll
    static void inicializarContexto() {
        sessaoVotacaoMapper = new SessaoVotacaoMapperImpl();
    }

    @DisplayName("Ao chamar o método converterParaDTO")
    @Nested
    class AoChamarMetodoConverterParaDTO {
        SessaoVotacao sessaoVotacao;

        @BeforeEach
        void inicializarContexto() {
            sessaoVotacao = new SessaoVotacao();
        }

        @DisplayName("Dado que seja passada uma entidade como parâmetro, deveria converter para DTO")
        @Test
        void verificarSeEstaMapeada() {
            sessaoVotacao.setId(1L);
            sessaoVotacao.setAbertura(LocalDateTime.now());
            Pauta pauta = new Pauta();
            pauta.setId(2L);
            sessaoVotacao.setPauta(pauta);
            sessaoVotacao.setTermino(LocalDateTime.now().plusMinutes(1));
            SessaoVotacaoDTO sessaoVotacaoDTO = sessaoVotacaoMapper.converterParaDTO(sessaoVotacao);
            assertEquals(sessaoVotacao.getId(), sessaoVotacaoDTO.getId());
            assertEquals(sessaoVotacao.getAbertura(), sessaoVotacaoDTO.getAbertura());
            assertEquals(sessaoVotacao.getPauta().getId(), sessaoVotacaoDTO.getPautaId());
            assertEquals(sessaoVotacao.getTermino(), sessaoVotacaoDTO.getTermino());
        }
    }

}
