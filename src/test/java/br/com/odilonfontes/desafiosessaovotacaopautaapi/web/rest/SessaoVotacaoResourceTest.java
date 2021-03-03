package br.com.odilonfontes.desafiosessaovotacaopautaapi.web.rest;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.Pauta;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.SessaoVotacaoService;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.SessaoVotacaoDTO;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.impl.SessaoVotacaoServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @SpringBootTest
// @AutoConfigureMockMvc
public class SessaoVotacaoResourceTest {

    public static final String URI_ABERTURA_SESSAO_VOTACAO_PAUTA = "/api/v1/sessao-votacao-pauta";
    static MockMvc mockMvc;
    static ObjectMapper objectMapper;
    static SessaoVotacaoService sessaoVotacaoServiceMock;

    @BeforeAll
    static void inicializarContexto() {
        // sessaoVotacaoServiceMock = mock(SessaoVotacaoServiceImpl.class);
        // mockMvc = MockMvcBuilders
        //         .standaloneSetup(new SessaoVotacaoResource(sessaoVotacaoServiceMock))
        //         .build();
        // objectMapper = new ObjectMapper();
    }

    @DisplayName("Ao chamar o método criarSessaoVotacao")
    @Nested
    class AoChamarMetodoCriarSessaoVotacao {
        SessaoVotacaoDTO sessaoVotacaoDTO;

        @BeforeEach
        void inicializarContexto() {
            sessaoVotacaoDTO = new SessaoVotacaoDTO();
        }

        @DisplayName("Dado que possua dados válidos, deveria criar a sessão de votação")
        @Test
        void criarSessaoVotacao() throws Exception {
            // sessaoVotacaoDTO.setId(1L);
            // sessaoVotacaoDTO.setAbertura(LocalDateTime.now());
            // Pauta pauta = new Pauta();
            // pauta.setId(2L);
            // sessaoVotacaoDTO.setPautaId(pauta.getId());
            // sessaoVotacaoDTO.setTermino(LocalDateTime.now().plusMinutes(1));
            // BDDMockito.given(sessaoVotacaoServiceMock.salvar(any())).willReturn(sessaoVotacaoDTO);
            // ResultActions resultActions = SessaoVotacaoResourceTest.criarSessaoVotacao(sessaoVotacaoDTO);
            // resultActions.andExpect(status().isCreated());
            // BDDMockito.verify(sessaoVotacaoServiceMock, times(1)).salvar(any());
        }

        @DisplayName("Dado que possua dados inválidos, deveria retornar erro 400")
        @Test
        void retornarErro400() throws Exception {
            // ResultActions resultActions = SessaoVotacaoResourceTest.criarSessaoVotacao(sessaoVotacaoDTO);
            // resultActions.andExpect(status().isBadRequest());
        }
    }

    static ResultActions criarSessaoVotacao(SessaoVotacaoDTO sessaoVotacaoDTO) throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.post(URI_ABERTURA_SESSAO_VOTACAO_PAUTA)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(sessaoVotacaoDTO)));
    }

}
