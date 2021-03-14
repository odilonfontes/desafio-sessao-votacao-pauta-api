package br.com.odilonfontes.desafio.sessaovotacaoapi.web.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.odilonfontes.desafio.sessaovotacaoapi.domain.Pauta;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.SessaoVotacaoService;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.dto.SessaoVotacaoDTO;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.impl.SessaoVotacaoServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class SessaoVotacaoResourceTest {

    public static final String URI_SESSAO_VOTACAO = "/api/v1/sessao-votacao";
    static MockMvc mockMvc;
    static ObjectMapper objectMapper;
    static SessaoVotacaoService sessaoVotacaoServiceMock;

    @BeforeAll
    static void inicializarContexto() {
        sessaoVotacaoServiceMock = mock(SessaoVotacaoServiceImpl.class);
        mockMvc = MockMvcBuilders
                .standaloneSetup(new SessaoVotacaoResource(sessaoVotacaoServiceMock))
                .build();
        objectMapper = new ObjectMapper();
    }

    @DisplayName("Ao chamar o método abrirSessaoVotacao")
    @Nested
    class AoChamarMetodoAbrirSessaoVotacao {
        SessaoVotacaoDTO sessaoVotacaoDTO;

        @BeforeEach
        void inicializarContexto() {
            sessaoVotacaoDTO = new SessaoVotacaoDTO();
        }

        @DisplayName("Dado que possua dados válidos, deveria abrir a sessão de votação")
        @Test
        void deveriaAbrirSessaoVotacao() throws Exception {
            sessaoVotacaoDTO.setId(1L);
            sessaoVotacaoDTO.setAbertura(LocalDateTime.now());
            Pauta pauta = new Pauta();
            pauta.setId(2L);
            sessaoVotacaoDTO.setPautaId(pauta.getId());
            sessaoVotacaoDTO.setTermino(LocalDateTime.now().plusMinutes(1));
            BDDMockito.given(sessaoVotacaoServiceMock.salvar(any())).willReturn(sessaoVotacaoDTO);
            ResultActions resultActions = abrirSessaoVotacao(sessaoVotacaoDTO);
            resultActions.andExpect(status().isCreated());
            BDDMockito.verify(sessaoVotacaoServiceMock, times(1)).salvar(any());
        }

        @DisplayName("Dado que possua dados inválidos, deveria retornar erro 400")
        @Test
        void retornarErro400() throws Exception {
            ResultActions resultActions = abrirSessaoVotacao(sessaoVotacaoDTO);
            resultActions.andExpect(status().isBadRequest());
        }

        ResultActions abrirSessaoVotacao(SessaoVotacaoDTO sessaoVotacaoDTO) throws Exception {
            return mockMvc.perform(MockMvcRequestBuilders.post(URI_SESSAO_VOTACAO)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(sessaoVotacaoDTO)));
        }
    }

}
