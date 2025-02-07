package com.andres.curso.java.springboot.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_detalles_factura")
public class TblDetallesFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_factura")
    private Integer idFactura;

    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "cantidad_de_producto")
    private Integer cantidadDeProducto;

    @Column(name = "precio_unitario_producto")
    private Double precioUnitarioProducto;

    @Column(name = "subtotal_producto")
    private Double subtotalProducto;

    @Column(name = "notas")
    private String notas;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidadDeProducto() {
        return cantidadDeProducto;
    }

    public void setCantidadDeProducto(Integer cantidadDeProducto) {
        this.cantidadDeProducto = cantidadDeProducto;
    }

    public Double getPrecioUnitarioProducto() {
        return precioUnitarioProducto;
    }

    public void setPrecioUnitarioProducto(Double precioUnitarioProducto) {
        this.precioUnitarioProducto = precioUnitarioProducto;
    }

    public Double getSubtotalProducto() {
        return subtotalProducto;
    }

    public void setSubtotalProducto(Double subtotalProducto) {
        this.subtotalProducto = subtotalProducto;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}