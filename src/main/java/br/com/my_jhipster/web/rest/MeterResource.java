package br.com.my_jhipster.web.rest;

import com.codahale.metrics.annotation.Timed;

import br.com.my_jhipster.domain.Meter;
import br.com.my_jhipster.domain.Password;

import br.com.my_jhipster.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Map;

/**
 * REST controller for managing Meter.
 */
@RestController
@RequestMapping("/api")
public class MeterResource {

    private final Logger log = LoggerFactory.getLogger(MeterResource.class);

    private final Meter meter;

    public MeterResource() {
        this.meter = new Meter();
    }

    /**
     * POST /meter : get score from meter.
     *
     * @param pass
     * @return the entire detailed score with status 200 (OK) 
     * @throws java.net.URISyntaxException
     */
    @PostMapping("/meter")
    @Timed
    public Map<Integer, List<Integer>> getAllMemory_users(@Valid @RequestBody Password pass) throws URISyntaxException {
        log.debug("Post para calcular força de senha: {}", pass);
        if (pass == null) {
            throw new BadRequestAlertException("Parâmetro Senha requisitado", "Meter", "parametro invalido");
        }
        Map<Integer, List<Integer>> retorno;
        meter.setPassword(pass.getPassword());
        retorno = meter.calcScore();
        return retorno;
    }

    /**
     * GET /meter : get all the meter.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of
     * meter in body
     
    @GetMapping("/meter/{pass}")
    @Timed
    public List<String> getAllMemory_users(@PathVariable String pass) {
        log.debug("Get para calcular força de senha: {}", pass);
    }*/

}
/*
curl -X GET --header 'Accept: application/json' --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTUxNDIwMTc4Nn0.lTFJlJR3vgmN7bI-ROELdylx6JA2KQaJT3XeUnVggmG8RaTczTDI6SNtyjgi3gRHaZCt3M37EJR9gM_iLo6cog' 'http://localhost:8080/api/meter/ASD'

curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/problem+json' --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTUxNDIwMTc4Nn0.lTFJlJR3vgmN7bI-ROELdylx6JA2KQaJT3XeUnVggmG8RaTczTDI6SNtyjgi3gRHaZCt3M37EJR9gM_iLo6cog' -d '{"password": "TesTe123" }' 'http://localhost:8080/api/meter/'
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/problem+json' --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTUxNDIwMTc4Nn0.lTFJlJR3vgmN7bI-ROELdylx6JA2KQaJT3XeUnVggmG8RaTczTDI6SNtyjgi3gRHaZCt3M37EJR9gM_iLo6cog' -d "TesTe123" 'http://localhost:8080/api/meter/'
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/problem+json' --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTUxNDIwMTc4Nn0.lTFJlJR3vgmN7bI-ROELdylx6JA2KQaJT3XeUnVggmG8RaTczTDI6SNtyjgi3gRHaZCt3M37EJR9gM_iLo6cog' -d '{"password": "asdasd"}' 'http://localhost:8080/api/meter/'
 */
