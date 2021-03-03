package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.mapper;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.Pauta;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.SessaoVotacao;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.SessaoVotacaoDTO;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
