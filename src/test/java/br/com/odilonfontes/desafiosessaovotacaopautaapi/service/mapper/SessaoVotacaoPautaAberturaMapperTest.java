package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.mapper;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.SessaoVotacaoPauta;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.SessaoVotacaoPautaAberturaDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {AberturaSessaoVotacaoPautaMapperImpl.class, PautaMapperImpl.class})
public class SessaoVotacaoPautaAberturaMapperTest {

    @Autowired
    protected AberturaSessaoVotacaoPautaMapper aberturaSessaoVotacaoPautaMapper;

    @DisplayName("Ao instanciar um objeto da classe AberturaDaSessaoVotacaoPautaDTO")
    @Nested
    class AoInstanciarUmObjetoDaClasseSessaoVotacaoPautaAberturaDTO {
        SessaoVotacaoPautaAberturaDTO sessaoVotacaoPautaAberturaDTO;

        @BeforeEach
        void inicializarContexto() {
            sessaoVotacaoPautaAberturaDTO = new SessaoVotacaoPautaAberturaDTO();
        }

        @DisplayName("Dado que convertido para entidade, deveria gerar a entidade conforme mapeamento")
        @Test
        void verificarSeEstaMapeada() {
            sessaoVotacaoPautaAberturaDTO.setPautaId(1L);
            SessaoVotacaoPauta sessaoVotacaoPauta = aberturaSessaoVotacaoPautaMapper
                    .converterParaEntidade(sessaoVotacaoPautaAberturaDTO);
            assertThat(sessaoVotacaoPauta.getAbertura()).isNotNull();
            assertThat(sessaoVotacaoPauta.getPauta()).isNotNull();
            assertThat(sessaoVotacaoPauta.getTermino()).isNotNull();
        }
    }

}
