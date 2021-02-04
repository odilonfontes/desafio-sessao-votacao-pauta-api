package br.com.odilonfontes.desafiosessaovotacaopautaapi.web.rest;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.Pauta;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.SessaoVotacaoPautaService;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.SessaoVotacaoPautaDTO;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.impl.SessaoVotacaoPautaServiceImpl;
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

@SpringBootTest
@AutoConfigureMockMvc
public class SessaoVotacaoPautaResourceTest {

    public static final String URL_ABERTURA = "/api/v1/sessao-votacao-pauta";
    static MockMvc mockMvc;
    static ObjectMapper objectMapper;
    static SessaoVotacaoPautaService sessaoVotacaoPautaServiceMock;

    @BeforeAll
    static void inicializarContexto() {
        sessaoVotacaoPautaServiceMock = mock(SessaoVotacaoPautaServiceImpl.class);
        mockMvc = MockMvcBuilders
                .standaloneSetup(new SessaoVotacaoPautaResource(sessaoVotacaoPautaServiceMock))
                .build();
        objectMapper = new ObjectMapper();
    }

    @DisplayName("Ao chamar método criarSessaoVotacaoPauta")
    @Nested
    class AoChamarMetodoCriarSessaoVotacaoPauta {
        SessaoVotacaoPautaDTO sessaoVotacaoPautaDTO;

        @BeforeEach
        void inicializarContexto() {
            sessaoVotacaoPautaDTO = new SessaoVotacaoPautaDTO();
        }

        @DisplayName("Dado que possua dados válidos, deveria criar a sessão de votação")
        @Test
        void criarSessaoVotacaoPauta() throws Exception {
            sessaoVotacaoPautaDTO.setId(1L);
            sessaoVotacaoPautaDTO.setAbertura(LocalDateTime.now());
            Pauta pauta = new Pauta();
            pauta.setId(2L);
            sessaoVotacaoPautaDTO.setPautaId(pauta.getId());
            sessaoVotacaoPautaDTO.setTermino(LocalDateTime.now().plusMinutes(1));
            BDDMockito.given(sessaoVotacaoPautaServiceMock.salvar(any())).willReturn(sessaoVotacaoPautaDTO);
            ResultActions resultActions = SessaoVotacaoPautaResourceTest.criarSessaoVotacaoPauta(sessaoVotacaoPautaDTO);
            resultActions.andExpect(status().isCreated());
            BDDMockito.verify(sessaoVotacaoPautaServiceMock, times(1)).salvar(any());
        }

        @DisplayName("Dado que possua dados inválidos, deveria retornar erro 400")
        @Test
        void retornarErro400() throws Exception {
            ResultActions resultActions = SessaoVotacaoPautaResourceTest.criarSessaoVotacaoPauta(sessaoVotacaoPautaDTO);
            resultActions.andExpect(status().isBadRequest());
        }
    }

    static ResultActions criarSessaoVotacaoPauta(SessaoVotacaoPautaDTO sessaoVotacaoPautaDTO) throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.post(URL_ABERTURA)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(sessaoVotacaoPautaDTO)));
    }

}
