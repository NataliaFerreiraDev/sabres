package com.starwars.sabresjava.service;

import com.starwars.sabresjava.enums.SabreStatus;
import com.starwars.sabresjava.enums.SabreTipo;
import com.starwars.sabresjava.mapper.SabreMapper;
import com.starwars.sabresjava.model.Sabre;
import com.starwars.sabresjava.model.SabreDTO;
import com.starwars.sabresjava.repository.SabreRepository;import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SabreServiceTest {

    @Mock
    private SabreRepository sabreRepository;

    @Mock
    private SabreMapper sabreMapper;

    @InjectMocks
    private SabreService sabreService;

    private Sabre sabre;
    private SabreDTO sabreDTO;

    @BeforeEach
    void setUp() {
        sabre = new Sabre();
        sabre.setId(1L);
        sabre.setTipo(SabreTipo.AUTOMATICO);
        sabre.setDataFabricacao(LocalDate.now());
        sabre.setStatus(SabreStatus.DISPONIVEL);
        sabre.setJedi("Luke Skywalker");
        sabre.setDeleted(false);

        sabreDTO = new SabreDTO();
        sabreDTO.setId(1L);
        sabreDTO.setTipo(SabreTipo.AUTOMATICO);
        sabreDTO.setDataFabricacao(LocalDate.now().toString());
        sabreDTO.setStatus(SabreStatus.DISPONIVEL);
        sabreDTO.setJedi("Luke Skywalker");
    }

    @Test
    void salvar() {
        when(sabreMapper.convertToEntity(any(SabreDTO.class))).thenReturn(sabre);
        when(sabreRepository.save(any(Sabre.class))).thenReturn(sabre);
        when(sabreMapper.convertToDTO(any(Sabre.class))).thenReturn(sabreDTO);

        SabreDTO result = sabreService.salvar(sabreDTO);

        assertNotNull(result);
        assertEquals(sabreDTO.getId(), result.getId());
        verify(sabreRepository, times(1)).save(sabre);
    }

    @Test
    void listarTodos() {
        when(sabreRepository.findByDeletedFalse()).thenReturn(Collections.singletonList(sabre));
        when(sabreMapper.convertToDTO(any(Sabre.class))).thenReturn(sabreDTO);

        List<SabreDTO> result = sabreService.listarTodos();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        verify(sabreRepository, times(1)).findByDeletedFalse();
    }

    @Test
    void buscarPorId() {
        when(sabreRepository.findByIdAndDeletedFalse(anyLong())).thenReturn(Optional.of(sabre));
        when(sabreMapper.convertToDTO(any(Sabre.class))).thenReturn(sabreDTO);

        SabreDTO result = sabreService.buscarPorId(1L);

        assertNotNull(result);
        assertEquals(sabreDTO.getId(), result.getId());
        verify(sabreRepository, times(1)).findByIdAndDeletedFalse(1L);
    }

    @Test
    void atualizar() {
        when(sabreRepository.findByIdAndDeletedFalse(anyLong())).thenReturn(Optional.of(sabre));
        when(sabreRepository.save(any(Sabre.class))).thenReturn(sabre);
        when(sabreMapper.convertToDTO(any(Sabre.class))).thenReturn(sabreDTO);

        SabreDTO result = sabreService.atualizar(1L, sabreDTO);

        assertNotNull(result);
        assertEquals(sabreDTO.getId(), result.getId());
        verify(sabreRepository, times(1)).findByIdAndDeletedFalse(1L);
        verify(sabreRepository, times(1)).save(sabre);
    }

    @Test
    void deletar() {
        when(sabreRepository.findById(anyLong())).thenReturn(Optional.of(sabre));

        sabreService.deletar(1L);

        assertTrue(sabre.isDeleted());
        verify(sabreRepository, times(1)).findById(1L);
        verify(sabreRepository, times(1)).save(sabre);
    }

    @Test
    void atualizar_recebeNull() {
        SabreDTO result = sabreService.atualizar(1L, null);

        assertNull(result);
        verify(sabreRepository, never()).save(any(Sabre.class));
    }

    @Test
    void atualizar_sabreNaoEncontrado() {
        when(sabreRepository.findByIdAndDeletedFalse(anyLong())).thenReturn(Optional.empty());

        SabreDTO result = sabreService.atualizar(1L, sabreDTO);

        assertNull(result);
        verify(sabreRepository, times(1)).findByIdAndDeletedFalse(1L);
        verify(sabreRepository, never()).save(any(Sabre.class));
    }


}