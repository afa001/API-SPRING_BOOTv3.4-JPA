package com.andres.curso.java.springboot.backend.services;

import com.andres.curso.java.springboot.backend.entities.TblFacturas;
import com.andres.curso.java.springboot.backend.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class FacturaService implements IFacturaService {

    @Autowired
    final private FacturaRepository repository;

    public FacturaService(FacturaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<TblFacturas> findAll() {
        return (List<TblFacturas>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TblFacturas> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public TblFacturas save(TblFacturas factura) {
        return repository.save(factura);
    }

    @Override
    @Transactional
    public Optional<TblFacturas> deleteById(Long id) {
        Optional<TblFacturas> facturaOptional = repository.findById(id);
        if(facturaOptional.isPresent()){
            repository.deleteById(id);
            return facturaOptional;
        }
        return Optional.empty();
    }
}