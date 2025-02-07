package com.andres.curso.java.springboot.backend.services;

import com.andres.curso.java.springboot.backend.entities.TblFacturas;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IFacturaService {
    List<TblFacturas> findAll();
    Optional<TblFacturas> findById(Long id);
    TblFacturas save(TblFacturas product);
    Optional<TblFacturas> deleteById(Long id);
}