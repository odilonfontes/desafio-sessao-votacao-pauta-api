package br.com.odilonfontes.desafiosessaovotacaopautaapi.web.rest;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.PautaService;
import br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto.PautaDTO;
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
public class PautaResource {

    private final PautaService pautaService;

    public PautaResource(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PostMapping("/v1/pauta")
    public ResponseEntity<PautaDTO> criarPauta(@Valid @RequestBody PautaDTO pautaDTO) {
        PautaDTO retorno = pautaService.salvar(pautaDTO);
        return new ResponseEntity<>(retorno, HttpStatus.CREATED);
    }

}
