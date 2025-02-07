package com.andres.curso.java.springboot.backend.services;

import com.andres.curso.java.springboot.backend.entities.CatProducto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<CatProducto> findAll();
    Optional<CatProducto> findById(Long id);
    CatProducto save(CatProducto product);
    Optional<CatProducto> deleteById(Long id);
}