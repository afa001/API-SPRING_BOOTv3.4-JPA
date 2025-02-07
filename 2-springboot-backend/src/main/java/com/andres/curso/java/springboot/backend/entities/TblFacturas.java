package com.andres.curso.java.springboot.backend.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_facturas")
public class TblFacturas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha_emision_factura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmisionFactura;

    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "numero_factura")
    private Integer numeroFactura;

    @Column(name = "numero_total_articulos")
    private Integer numeroTotalArticulos;

    @Column(name = "subtotal_facturas")
    private Double subtotalFacturas;

    @Column(name = "total_impuestos")
    private Double totalImpuestos;

    @Column(name = "total_factura")
    private Double totalFactura;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaEmisionFactura() {
        return fechaEmisionFactura;
    }

    public void setFechaEmisionFactura(Date fechaEmisionFactura) {
        this.fechaEmisionFactura = fechaEmisionFactura;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Integer getNumeroTotalArticulos() {
        return numeroTotalArticulos;
    }

    public void setNumeroTotalArticulos(Integer numeroTotalArticulos) {
        this.numeroTotalArticulos = numeroTotalArticulos;
    }

    public Double getSubtotalFacturas() {
        return subtotalFacturas;
    }

    public void setSubtotalFacturas(Double subtotalFacturas) {
        this.subtotalFacturas = subtotalFacturas;
    }

    public Double getTotalImpuestos() {
        return totalImpuestos;
    }

    public void setTotalImpuestos(Double totalImpuestos) {
        this.totalImpuestos = totalImpuestos;
    }

    public Double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(Double totalFactura) {
        this.totalFactura = totalFactura;
    }
}