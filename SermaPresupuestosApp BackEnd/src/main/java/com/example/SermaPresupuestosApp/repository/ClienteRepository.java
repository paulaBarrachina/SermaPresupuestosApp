package com.example.SermaPresupuestosApp.repository;


import com.example.SermaPresupuestosApp.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unused")
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
