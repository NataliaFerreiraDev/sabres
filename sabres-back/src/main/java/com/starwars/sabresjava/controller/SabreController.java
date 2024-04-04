package com.starwars.sabresjava.controller;

import com.starwars.sabresjava.model.SabreDTO;
import com.starwars.sabresjava.service.SabreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sabres")
public class SabreController {

    private final SabreService sabreService;

    public SabreController(SabreService sabreService) {
        this.sabreService = sabreService;
    }

    @PostMapping
    public ResponseEntity<SabreDTO> inserir(@RequestBody SabreDTO sabreDTO){
        SabreDTO sabreSalvo = sabreService.salvar(sabreDTO);

        if (sabreSalvo != null){
            return ResponseEntity.ok(sabreSalvo);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<SabreDTO>> listarTodos(){
        List<SabreDTO> sabreDTOList = sabreService.listarTodos();

        if (!sabreDTOList.isEmpty()){
            return ResponseEntity.ok(sabreDTOList);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
