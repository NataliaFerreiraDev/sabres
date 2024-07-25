package com.starwars.sabresjava.mapper;

import com.starwars.sabresjava.model.Sabre;
import com.starwars.sabresjava.model.SabreDTO;
import com.starwars.sabresjava.enums.SabreStatus;
import com.starwars.sabresjava.enums.SabreTipo;
import com.starwars.sabresjava.util.DataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SabreMapperTest {

    private SabreMapper sabreMapper;

    @BeforeEach
    void setUp() {
        sabreMapper = new SabreMapper();
    }

    @Test
    void testConvertToEntity() {
        SabreDTO sabreDTO = new SabreDTO();
        sabreDTO.setTipo(SabreTipo.AUTOMATICO);
        sabreDTO.setStatus(SabreStatus.DISPONIVEL);
        sabreDTO.setJedi("Luke Skywalker");

        Sabre sabre = sabreMapper.convertToEntity(sabreDTO);

        assertNotNull(sabre);
        assertEquals(sabreDTO.getTipo(), sabre.getTipo());
        assertEquals(sabreDTO.getStatus(), sabre.getStatus());
        assertEquals(sabreDTO.getJedi(), sabre.getJedi());
        }

    @Test
    void testConvertToDTO() {
        Sabre sabre = new Sabre();
        sabre.setId(1L);
        sabre.setTipo(SabreTipo.AUTOMATICO);
        sabre.setStatus(SabreStatus.DISPONIVEL);
        sabre.setJedi("Luke Skywalker");
        sabre.setDataFabricacao(LocalDate.of(2023, 12, 25));

        SabreDTO sabreDTO = sabreMapper.convertToDTO(sabre);

        assertNotNull(sabreDTO);
        assertEquals(sabre.getId(), sabreDTO.getId());
        assertEquals(sabre.getTipo(), sabreDTO.getTipo());
        assertEquals(sabre.getStatus(), sabreDTO.getStatus());
        assertEquals(sabre.getJedi(), sabreDTO.getJedi());
        assertEquals("25/12/2023", sabreDTO.getDataFabricacao());
    }
}