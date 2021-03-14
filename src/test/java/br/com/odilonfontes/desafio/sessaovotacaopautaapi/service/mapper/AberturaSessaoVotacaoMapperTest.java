package br.com.odilonfontes.desafio.sessaovotacaopautaapi.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.odilonfontes.desafio.sessaovotacaopautaapi.domain.SessaoVotacao;
import br.com.odilonfontes.desafio.sessaovotacaopautaapi.service.dto.AberturaSessaoVotacaoDTO;

@SpringBootTest(classes = {AberturaSessaoVotacaoMapperImpl.class, PautaMapperImpl.class})
public class AberturaSessaoVotacaoMapperTest {

    @Autowired
    protected AberturaSessaoVotacaoMapper aberturaSessaoVotacaoMapper;

    @DisplayName("Ao chamar o método converterParaDTO")
    @Nested
    class AoChamarMetodoConverterParaDTO {
        AberturaSessaoVotacaoDTO aberturaSessaoVotacaoDTO;

        @BeforeEach
        void inicializarContexto() {
            aberturaSessaoVotacaoDTO = new AberturaSessaoVotacaoDTO();
        }

        @DisplayName("Dado que seja passada uma entidade como parâmetro, deveria converter para DTO")
        @Test
        void verificarSeEstaMapeada() {
            aberturaSessaoVotacaoDTO.setPautaId(1L);
            SessaoVotacao sessaoVotacao = aberturaSessaoVotacaoMapper.converterParaEntidade(aberturaSessaoVotacaoDTO);
            assertThat(sessaoVotacao.getAbertura()).isNotNull();
            assertThat(sessaoVotacao.getPauta()).isNotNull();
            assertThat(sessaoVotacao.getTermino()).isNotNull();
        }
    }

}
