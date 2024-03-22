package com.starwars.sabresjava.controller;

import com.starwars.sabresjava.model.SabreDTO;
import com.starwars.sabresjava.service.SabreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sabres")
public class SabreController {

    private final SabreService sabreService;

    public SabreController(SabreService sabreService) {
        this.sabreService = sabreService;
    }

    @PostMapping
    public ResponseEntity<SabreDTO> inserir (@RequestBody SabreDTO sabreDTO){
        SabreDTO sabreSalvo = sabreService.salvar(sabreDTO);

        if (sabreSalvo != null){
            return ResponseEntity.ok(sabreSalvo);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
