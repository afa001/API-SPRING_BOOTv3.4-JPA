package com.andres.curso.java.springboot.backend.services;

import com.andres.curso.java.springboot.backend.entities.CatProducto;
import com.andres.curso.java.springboot.backend.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    final private ProductoRepository repository;

    public ProductoServiceImpl(ProductoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<CatProducto> findAll() {
        return (List<CatProducto>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CatProducto> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public CatProducto save(CatProducto product) {
        return repository.save(product);
    }

    @Override
    @Transactional
    public Optional<CatProducto> deleteById(Long id) {
        Optional<CatProducto> productOptional = repository.findById(id);
        if(productOptional.isPresent()){
            repository.deleteById(id);
            return productOptional;
        }
        return Optional.empty();
    }
}