package br.com.odilonfontes.desafio.sessaovotacaoapi.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.odilonfontes.desafio.sessaovotacaoapi.service.PautaService;
import br.com.odilonfontes.desafio.sessaovotacaoapi.service.dto.PautaDTO;

import java.net.URISyntaxException;
import java.util.Set;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PautaResource {

    private final PautaService pautaService;

    public PautaResource(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PostMapping(path = "/v1/pauta", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PautaDTO> criarPauta(@Valid @RequestBody PautaDTO pautaDTO) throws URISyntaxException {
        if (pautaDTO.possuiId()) {
            throw new IllegalArgumentException("Uma nova pauta não pode ter um ID definido");
        }

        PautaDTO retorno = pautaService.salvar(pautaDTO);
        return new ResponseEntity<>(retorno, HttpStatus.CREATED);
    }

    @GetMapping("/v1/pauta")
    public ResponseEntity<Set<PautaDTO>> consultarTodasPautas() throws URISyntaxException {
        Set<PautaDTO> retorno = pautaService.consultarTodasPautas();
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

}
