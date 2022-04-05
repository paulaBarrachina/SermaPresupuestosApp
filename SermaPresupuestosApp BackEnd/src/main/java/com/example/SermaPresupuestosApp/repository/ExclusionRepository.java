package com.example.SermaPresupuestosApp.repository;

import com.example.SermaPresupuestosApp.model.Exclusion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unused")
public interface ExclusionRepository extends JpaRepository<Exclusion, Long> {
}
