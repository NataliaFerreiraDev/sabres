package com.starwars.sabresjava.service;


import com.starwars.sabresjava.mapper.SabreMapper;
import com.starwars.sabresjava.model.Sabre;
import com.starwars.sabresjava.model.SabreDTO;
import com.starwars.sabresjava.repository.SabreRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

        Sabre sabre = sabreMapper.convertToEntity(sabreDTO);
        sabre.setDataFabricacao(LocalDate.now());
        sabre.setDeleted(false);
        sabreRepository.save(sabre);
        return sabreMapper.convertToDTO(sabre);
    }

    public List<SabreDTO> listarTodos(){
        List<Sabre> sabreList = sabreRepository.findByDeletedFalse();

        return sabreList.stream()
                .map(sabreMapper::convertToDTO)
                .toList();
    }

    public SabreDTO buscarPorId(Long id){
        Sabre sabre = sabreRepository.findByIdAndDeletedFalse(id).orElse(null);

        return sabre != null ? sabreMapper.convertToDTO(sabre) : null;
    }

    public SabreDTO atualizar(Long id, SabreDTO sabreDTO) {
        Sabre sabre = sabreRepository.findByIdAndDeletedFalse(id).orElse(null);

        if(sabre != null){
            sabre.setTipo(sabreDTO.getTipo());
            sabre.setStatus(sabreDTO.getStatus());
            sabre.setJedi(sabreDTO.getJedi());
            sabreRepository.save(sabre);

            return sabreMapper.convertToDTO(sabre);
        }

        return null;
    }

    public void deletar(Long id) {
        sabreRepository.findById(id).ifPresent(sabre -> {
            sabre.setDeleted(true);
            sabreRepository.save(sabre);
        });
    }
}
