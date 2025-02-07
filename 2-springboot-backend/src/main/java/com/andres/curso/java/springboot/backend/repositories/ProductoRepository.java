package com.andres.curso.java.springboot.backend.repositories;

import com.andres.curso.java.springboot.backend.entities.CatProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//@Repository
public interface ProductoRepository extends JpaRepository<CatProducto, Long> {
}