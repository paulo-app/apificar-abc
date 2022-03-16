package com.pauloapp.apificar.abc.controllers;

import com.pauloapp.apificar.abc.services.ApificarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api-implementado")
public class ApificarController {

    @Autowired
    @Qualifier("serviceRestTemplate")
    private ApificarService apificarService;

    @GetMapping(value = "/consulta/{text}")
    public String consulta(@PathVariable String text) {
        return apificarService.findByStr(text);
    }
}
