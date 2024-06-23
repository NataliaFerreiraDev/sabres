package com.starwars.sabresjava.repository;

import com.starwars.sabresjava.model.Sabre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SabreRepository extends JpaRepository<Sabre, Long> {

    List<Sabre> findByDeletedFalse();

    Optional<Sabre> findByIdAndDeletedFalse(Long id);

}
