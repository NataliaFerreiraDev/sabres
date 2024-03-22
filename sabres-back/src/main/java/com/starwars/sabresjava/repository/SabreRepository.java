package com.starwars.sabresjava.repository;

import com.starwars.sabresjava.model.Sabre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SabreRepository extends JpaRepository<Sabre, Long> {
}
