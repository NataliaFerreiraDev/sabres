package com.starwars.sabresjava.repository;

import com.starwars.sabresjava.model.Sabre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SabreRepository extends JpaRepository<Sabre, Long> {
}
