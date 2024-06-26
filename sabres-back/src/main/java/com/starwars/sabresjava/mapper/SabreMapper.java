package com.starwars.sabresjava.mapper;

import com.starwars.sabresjava.model.Sabre;
import com.starwars.sabresjava.model.SabreDTO;
import com.starwars.sabresjava.util.DataUtils;
import org.springframework.stereotype.Component;

@Component
public class SabreMapper {

    public Sabre convertToEntity(SabreDTO sabreDTO){
        Sabre sabre = new Sabre();
        sabre.setId(sabre.getId());
        sabre.setTipo(sabreDTO.getTipo());
        sabre.setStatus(sabreDTO.getStatus());
        sabre.setJedi(sabreDTO.getJedi());

        return sabre;
    }

    public SabreDTO convertToDTO(Sabre sabre){
        SabreDTO sabreDTO = new SabreDTO();
        sabreDTO.setId(sabre.getId());
        sabreDTO.setTipo(sabre.getTipo());
        sabreDTO.setDataFabricacao(DataUtils.convertLocalDateToString(sabre.getDataFabricacao()));
        sabreDTO.setStatus(sabre.getStatus());
        sabreDTO.setJedi(sabre.getJedi());
        return sabreDTO;
    }

}
