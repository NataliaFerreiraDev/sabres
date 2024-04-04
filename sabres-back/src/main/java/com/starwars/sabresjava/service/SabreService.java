package com.starwars.sabresjava.service;


import com.starwars.sabresjava.mapper.SabreMapper;
import com.starwars.sabresjava.model.Sabre;
import com.starwars.sabresjava.model.SabreDTO;
import com.starwars.sabresjava.repository.SabreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SabreService {

    private final SabreRepository sabreRepository;
    private final SabreMapper sabreMapper;

    public SabreService(SabreRepository sabreRepository, SabreMapper sabreMapper) {
        this.sabreRepository = sabreRepository;
        this.sabreMapper = sabreMapper;
    }

    public SabreDTO salvar(SabreDTO sabreDTO) {
        Sabre sabre = sabreRepository.save(sabreMapper.convertToEntity(sabreDTO));
        return sabreMapper.convertToDTO(sabre);
    }

    public List<SabreDTO> listarTodos(){
        List<Sabre> sabreList = sabreRepository.findAll();

        return sabreList.stream()
                .map(sabreMapper::convertToDTO)
                .toList();
    }


}
