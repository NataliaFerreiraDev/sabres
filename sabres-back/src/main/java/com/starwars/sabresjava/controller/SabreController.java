package com.starwars.sabresjava.controller;

import com.starwars.sabresjava.model.SabreDTO;
import com.starwars.sabresjava.service.SabreService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/sabres")
public class SabreController {

    private final SabreService sabreService;

    public SabreController(SabreService sabreService) {
        this.sabreService = sabreService;
    }

    @GetMapping
    public ResponseEntity<List<SabreDTO>> listarTodos() {
        List<SabreDTO> sabreDTOList = sabreService.listarTodos();

        if (!sabreDTOList.isEmpty()) {
            return ResponseEntity.ok(sabreDTOList);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SabreDTO> buscarPorId(@PathVariable @NotNull @Positive Long id) {
        SabreDTO sabreDTO = sabreService.buscarPorId(id);

        if (sabreDTO != null) {
            return ResponseEntity.ok(sabreDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<SabreDTO> inserir(@RequestBody @Valid SabreDTO sabreDTO) {
        SabreDTO sabreSalvo = sabreService.salvar(sabreDTO);

        if (sabreSalvo != null) {
            return ResponseEntity.ok(sabreSalvo);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SabreDTO> atualizar(@PathVariable @Valid @Positive Long id, @RequestBody SabreDTO sabreDTO) {
        SabreDTO sabreSalvo = sabreService.atualizar(id, sabreDTO);

        if (sabreSalvo != null) {
            return ResponseEntity.ok(sabreSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar (@PathVariable @NotNull @Positive Long id){

        try{
            sabreService.deletar(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }

}
