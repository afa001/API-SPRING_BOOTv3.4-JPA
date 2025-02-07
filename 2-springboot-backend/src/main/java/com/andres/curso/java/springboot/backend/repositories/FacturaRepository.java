package com.andres.curso.java.springboot.backend.repositories;

import com.andres.curso.java.springboot.backend.entities.TblFacturas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FacturaRepository extends JpaRepository<TblFacturas, Long> {
}