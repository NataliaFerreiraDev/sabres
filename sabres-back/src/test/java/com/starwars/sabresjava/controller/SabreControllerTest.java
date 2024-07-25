package com.starwars.sabresjava.controller;

import com.starwars.sabresjava.model.SabreDTO;
import com.starwars.sabresjava.service.SabreService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SabreControllerTest {

    @Mock
    private SabreService sabreService;

    @InjectMocks
    private SabreController sabreController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarTodos() {
        SabreDTO sabreDTO1 = new SabreDTO();
        SabreDTO sabreDTO2 = new SabreDTO();
        List<SabreDTO> sabreDTOList = Arrays.asList(sabreDTO1, sabreDTO2);

        when(sabreService.listarTodos()).thenReturn(sabreDTOList);

        ResponseEntity<List<SabreDTO>> response = sabreController.listarTodos();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(sabreDTOList, response.getBody());
    }

    @Test
    void testListarTodos_emptyList() {
        when(sabreService.listarTodos()).thenReturn(List.of());

        ResponseEntity<List<SabreDTO>> response = sabreController.listarTodos();

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testBuscarPorId() {
        SabreDTO sabreDTO = new SabreDTO();
        Long id = 1L;

        when(sabreService.buscarPorId(id)).thenReturn(sabreDTO);

        ResponseEntity<SabreDTO> response = sabreController.buscarPorId(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(sabreDTO, response.getBody());
    }

    @Test
    void testBuscarPorId_notFound() {
        Long id = 1L;

        when(sabreService.buscarPorId(id)).thenReturn(null);

        ResponseEntity<SabreDTO> response = sabreController.buscarPorId(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testInserir() {
        SabreDTO sabreDTO = new SabreDTO();
        SabreDTO sabreSalvo = new SabreDTO();

        when(sabreService.salvar(sabreDTO)).thenReturn(sabreSalvo);

        ResponseEntity<SabreDTO> response = sabreController.inserir(sabreDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(sabreSalvo, response.getBody());
    }

    @Test
    void testInserir_badRequest() {
        SabreDTO sabreDTO = new SabreDTO();

        when(sabreService.salvar(sabreDTO)).thenReturn(null);

        ResponseEntity<SabreDTO> response = sabreController.inserir(sabreDTO);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testAtualizar() {
        SabreDTO sabreDTO = new SabreDTO();
        SabreDTO sabreSalvo = new SabreDTO();
        Long id = 1L;

        when(sabreService.atualizar(id, sabreDTO)).thenReturn(sabreSalvo);

        ResponseEntity<SabreDTO> response = sabreController.atualizar(id, sabreDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(sabreSalvo, response.getBody());
    }

    @Test
    void testAtualizar_notFound() {
        SabreDTO sabreDTO = new SabreDTO();
        Long id = 1L;

        when(sabreService.atualizar(id, sabreDTO)).thenReturn(null);

        ResponseEntity<SabreDTO> response = sabreController.atualizar(id, sabreDTO);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testDeletar() {
        Long id = 1L;

        doNothing().when(sabreService).deletar(id);

        ResponseEntity<Object> response = sabreController.deletar(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void testDeletar_exception() {
        Long id = 1L;

        doThrow(new RuntimeException()).when(sabreService).deletar(id);

        ResponseEntity<Object> response = sabreController.deletar(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}