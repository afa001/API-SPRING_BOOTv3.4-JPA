package com.andres.curso.java.springboot.backend.controllers;

import com.andres.curso.java.springboot.backend.entities.TblFacturas;
import com.andres.curso.java.springboot.backend.services.IFacturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Facturas")
public class FacturasController {
    final private IFacturaService service;

    public FacturasController(IFacturaService service) {
        this.service = service;
    }

    @GetMapping("/GetFacturas")
    public ResponseEntity<List<TblFacturas>> GetFacturas(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/GetFacturaById/{id}")
    public ResponseEntity<TblFacturas> GetFacturaById(@PathVariable Long id){
        Optional<TblFacturas> optionalFactura = service.findById(id);
        if(optionalFactura.isPresent()){
            return ResponseEntity.ok(optionalFactura.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/Add")
    public ResponseEntity<TblFacturas> Add(@RequestBody TblFacturas factura){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(factura));
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity<TblFacturas> Update(@RequestBody TblFacturas factura, @PathVariable Long id){
        Optional<TblFacturas> optionalFactura = service.findById(id);
        if(optionalFactura.isPresent()){
            TblFacturas facturaDb = optionalFactura.orElseThrow();
            facturaDb.setFechaEmisionFactura(factura.getFechaEmisionFactura());
            facturaDb.setIdCliente(factura.getIdCliente());
            facturaDb.setNumeroFactura(factura.getNumeroFactura());
            facturaDb.setNumeroTotalArticulos(factura.getNumeroTotalArticulos());
            facturaDb.setSubtotalFacturas(factura.getSubtotalFacturas());
            facturaDb.setTotalImpuestos(factura.getTotalImpuestos());
            facturaDb.setTotalFactura(factura.getTotalFactura());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(facturaDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<TblFacturas> delete(@PathVariable Long id){
        Optional<TblFacturas> optionalFactura = service.deleteById(id);
        if(optionalFactura.isPresent()){
            TblFacturas facturaDeleted = optionalFactura.orElseThrow();
            return ResponseEntity.status(HttpStatus.OK).body(facturaDeleted);
        }
        return ResponseEntity.notFound().build();
    }
}