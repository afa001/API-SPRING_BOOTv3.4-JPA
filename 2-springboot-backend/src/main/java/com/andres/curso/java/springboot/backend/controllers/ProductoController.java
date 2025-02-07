package com.andres.curso.java.springboot.backend.controllers;

import com.andres.curso.java.springboot.backend.entities.CatProducto;
import com.andres.curso.java.springboot.backend.services.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Productos")
public class ProductoController {
    final private ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping("/GetProducts")
    public ResponseEntity<List<CatProducto>> GetProducts(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/GetProductById/{id}")
    public ResponseEntity<CatProducto> GetProductById(@PathVariable Long id){
        Optional<CatProducto> optionalProduct = service.findById(id);
        if(optionalProduct.isPresent()){
            return ResponseEntity.ok(optionalProduct.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/Add")
    public ResponseEntity<CatProducto> Add(@RequestBody CatProducto product){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity<CatProducto> Update(@RequestBody CatProducto product, @PathVariable Long id){
        Optional<CatProducto> optionalProduct = service.findById(id);
        if(optionalProduct.isPresent()){
            CatProducto productDb = optionalProduct.orElseThrow();
            productDb.setNombreProducto(product.getNombreProducto());
            productDb.setPrecioUnitario(product.getPrecioUnitario());
            productDb.setExt(product.getExt());
            productDb.setImagenProducto(product.getImagenProducto());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<CatProducto> delete(@PathVariable Long id){
        Optional<CatProducto> optionalProduct = service.deleteById(id);
        if(optionalProduct.isPresent()){
            CatProducto productDeleted = optionalProduct.orElseThrow();
            return ResponseEntity.status(HttpStatus.OK).body(productDeleted);
        }
        return ResponseEntity.notFound().build();
    }
}