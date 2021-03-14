package br.com.odilonfontes.desafio.sessaovotacaoapi.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.odilonfontes.desafio.sessaovotacaoapi.service.SessaoVotacaoService;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.dto.AberturaSessaoVotacaoDTO;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.dto.SessaoVotacaoDTO;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class SessaoVotacaoResource {

    private final SessaoVotacaoService sessaoVotacaoService;

    public SessaoVotacaoResource(SessaoVotacaoService sessaoVotacaoService) {
        this.sessaoVotacaoService = sessaoVotacaoService;
    }

    @PostMapping(path = "/v1/sessao-votacao", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SessaoVotacaoDTO> abrirSessaoVotacao(@Valid @RequestBody
        AberturaSessaoVotacaoDTO aberturaSessaoVotacaoDTO) {
        SessaoVotacaoDTO retorno = sessaoVotacaoService.salvar(aberturaSessaoVotacaoDTO);
        return new ResponseEntity<>(retorno, HttpStatus.CREATED);
    }

}
