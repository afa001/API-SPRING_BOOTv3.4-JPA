package com.andres.curso.java.springboot.backend.repositories;

import com.andres.curso.java.springboot.backend.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
