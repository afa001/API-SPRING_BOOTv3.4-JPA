package com.andres.curso.java.springboot.backend.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "cat_productos")
public class CatProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //In the file application.properties spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
    //Configuracion Adicional que Evita a Hibernate convertir nombres de columnas de camelCase a snake_case, Útil cuando la base de datos ya usa camelCase y no queremos que Hibernate lo modifique > ejemplo de columna en base de datos > CREATE TABLE cat_productos ( nombreProducto VARCHAR(50) NOT NULL );  & En ese caso no es necesario usar los DataAnotations @Column

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "imagen_producto")
    private byte[] imagenProducto;

    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @Column(name = "ext")
    private String ext;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProducto() { return nombreProducto; }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public byte[] getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(byte[] imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}