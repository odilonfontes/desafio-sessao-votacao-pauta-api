package br.com.odilonfontes.desafiosessaovotacaopautaapi.web.rest;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.SessaoVotacaoPautaService;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.SessaoVotacaoPautaAberturaDTO;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.SessaoVotacaoPautaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class SessaoVotacaoPautaResource {

    private final SessaoVotacaoPautaService sessaoVotacaoPautaService;

    public SessaoVotacaoPautaResource(SessaoVotacaoPautaService sessaoVotacaoPautaService) {
        this.sessaoVotacaoPautaService = sessaoVotacaoPautaService;
    }

    @PostMapping("/v1/sessao-votacao-pauta")
    public ResponseEntity<SessaoVotacaoPautaDTO> criarSessaoVotacaoPauta(
            @Valid @RequestBody SessaoVotacaoPautaAberturaDTO sessaoVotacaoPautaAberturaDTO
    ) {
        SessaoVotacaoPautaDTO retorno = sessaoVotacaoPautaService.salvar(sessaoVotacaoPautaAberturaDTO);
        return new ResponseEntity<>(retorno, HttpStatus.CREATED);
    }

}
