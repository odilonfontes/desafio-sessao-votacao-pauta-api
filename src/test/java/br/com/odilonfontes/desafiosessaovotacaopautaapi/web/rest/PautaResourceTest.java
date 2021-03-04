package br.com.odilonfontes.desafiosessaovotacaopautaapi.web.rest;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.PautaService;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.PautaDTO;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.impl.PautaServiceImpl;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.Set;

@SpringBootTest
@AutoConfigureMockMvc
public class PautaResourceTest {

    public static final String URI_PAUTA = "/api/v1/pauta";
    static MockMvc mockMvc;
    static ObjectMapper objectMapper;
    static PautaService pautaServiceMock;

    @BeforeAll
    static void inicializarContexto() {
        pautaServiceMock = mock(PautaServiceImpl.class);
        mockMvc = MockMvcBuilders
                .standaloneSetup(new PautaResource(pautaServiceMock))
                .build();
        objectMapper = new ObjectMapper();
    }

    @DisplayName("Ao chamar método criarPauta")
    @Nested
    class AoChamarMetodoCriar {
        PautaDTO pautaDTO;

        @BeforeEach
        void inicializarContexto() {
            pautaDTO = new PautaDTO();
        }

        @DisplayName("Dado que possua dados válidos, deveria criar uma nova pauta")
        @Test
        void deveriaCriarNovaPauta() throws Exception {
            pautaDTO.setTitulo("titulo");
            pautaDTO.setDescricao("descricao");
            BDDMockito.given(pautaServiceMock.salvar(any())).willReturn(pautaDTO);
            ResultActions resultActions = criarPauta(pautaDTO);
            resultActions.andExpect(status().isCreated());
            BDDMockito.verify(pautaServiceMock, times(1)).salvar(any());
        }

        @DisplayName("Dado que possua dados inválidos, deveria retornar erro 400")
        @Test
        void deveriaRetornarErro400() throws Exception {
            pautaDTO.setTitulo(null);
            pautaDTO.setDescricao(null);
            ResultActions resultActions = criarPauta(pautaDTO);
            resultActions.andExpect(status().isBadRequest());
        }

        ResultActions criarPauta(PautaDTO pautaDTO) throws Exception {
            return mockMvc.perform(MockMvcRequestBuilders.post(URI_PAUTA)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(pautaDTO)));
        }
    }

    @DisplayName("Ao chamar método consultarTodasPautas")
    @Nested
    class AoChamarMetodoConsultarPautas {
        Set<PautaDTO> pautasDTO;

        @BeforeEach
        void inicializarContexto() {
            pautasDTO = Collections.singleton(new PautaDTO());
        }
        
        @DisplayName("Dado que possua pautas cadastradas, deveria retornar todas as pautas")
        @Test
        void deveriaConsultarTodasPautas() throws Exception {
            BDDMockito.given(pautaServiceMock.consultarTodasPautas()).willReturn(pautasDTO);
            ResultActions resultActions = consultarTodasPautas();
            resultActions.andExpect(status().isOk());
            BDDMockito.verify(pautaServiceMock, times(1)).consultarTodasPautas();
        }

        ResultActions consultarTodasPautas() throws Exception {
            return mockMvc.perform(MockMvcRequestBuilders.get(URI_PAUTA)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON));
        }
    }

}
