package com.example.SermaPresupuestosApp.repository;

import com.example.SermaPresupuestosApp.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unused")
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
}
