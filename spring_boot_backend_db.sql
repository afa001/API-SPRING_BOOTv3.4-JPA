CREATE DATABASE spring_boot_backend_db;
USE spring_boot_backend_db;

-- Tabla cat_productos
CREATE TABLE cat_productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(50) NOT NULL,
    imagen_producto LONGBLOB,
    precio_unitario DECIMAL(18, 2) NOT NULL,
    ext VARCHAR(5)
);

-- Tabla cat_tipo_cliente
CREATE TABLE cat_tipo_cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_cliente VARCHAR(50) NOT NULL
);

-- Tabla tbl_clientes
CREATE TABLE tbl_clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    razon_social VARCHAR(200) NOT NULL,
    id_tipo_cliente INT NOT NULL,
    fecha_creacion DATE NOT NULL,
    rfc VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_tipo_cliente) REFERENCES cat_tipo_cliente(id)
);

-- Tabla tbl_facturas
CREATE TABLE tbl_facturas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha_emision_factura DATETIME NOT NULL,
    id_cliente INT NOT NULL,
    numero_factura INT NOT NULL,
    numero_total_articulos INT NOT NULL,
    subtotal_facturas DECIMAL(18, 2) NOT NULL,
    total_impuestos DECIMAL(18, 2) NOT NULL,
    total_factura DECIMAL(18, 2) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES tbl_clientes(id)
);

-- Tabla tbl_detalles_factura
CREATE TABLE tbl_detalles_factura (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_factura INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad_de_producto INT NOT NULL,
    precio_unitario_producto DECIMAL(18, 2) NOT NULL,
    subtotal_producto DECIMAL(18, 2) NOT NULL,
    notas VARCHAR(200),
    FOREIGN KEY (id_producto) REFERENCES cat_productos(id) ON DELETE CASCADE,
    FOREIGN KEY (id_factura) REFERENCES tbl_facturas(id) ON DELETE CASCADE
);

-- Procedimientos almacenados
DELIMITER //

CREATE PROCEDURE add_cliente(
    IN razon_social VARCHAR(200),
    IN id_tipo_cliente INT,
    IN fecha_creacion DATE,
    IN rfc VARCHAR(50)
)
BEGIN
    INSERT INTO tbl_clientes (razon_social, id_tipo_cliente, fecha_creacion, rfc)
    VALUES (razon_social, id_tipo_cliente, fecha_creacion, rfc);
END //

CREATE PROCEDURE add_detalle_factura(
    IN id_factura INT,
    IN id_producto INT,
    IN cantidad_de_producto INT,
    IN precio_unitario_producto DECIMAL(18, 2),
    IN subtotal_producto DECIMAL(18, 2),
    IN notas VARCHAR(200)
)
BEGIN
    INSERT INTO tbl_detalles_factura (id_factura, id_producto, cantidad_de_producto, precio_unitario_producto, subtotal_producto, notas)
    VALUES (id_factura, id_producto, cantidad_de_producto, precio_unitario_producto, subtotal_producto, notas);
END //

CREATE PROCEDURE add_factura(
    IN fecha_emision_factura DATETIME,
    IN id_cliente INT,
    IN numero_factura INT,
    IN numero_total_articulos INT,
    IN subtotal_facturas DECIMAL(18, 2),
    IN total_impuestos DECIMAL(18, 2),
    IN total_factura DECIMAL(18, 2)
)
BEGIN
    INSERT INTO tbl_facturas (fecha_emision_factura, id_cliente, numero_factura, numero_total_articulos, subtotal_facturas, total_impuestos, total_factura)
    VALUES (fecha_emision_factura, id_cliente, numero_factura, numero_total_articulos, subtotal_facturas, total_impuestos, total_factura);
END //

CREATE PROCEDURE add_producto(
    IN nombre_producto VARCHAR(50),
    IN imagen_producto LONGBLOB,
    IN precio_unitario DECIMAL(18, 2),
    IN ext VARCHAR(5)
)
BEGIN
    INSERT INTO cat_productos (nombre_producto, imagen_producto, precio_unitario, ext)
    VALUES (nombre_producto, imagen_producto, precio_unitario, ext);
END //

CREATE PROCEDURE delete_cliente(IN id INT)
BEGIN
    DELETE FROM tbl_clientes WHERE id = id;
END //

CREATE PROCEDURE delete_detalle_factura(IN id INT)
BEGIN
    DELETE FROM tbl_detalles_factura WHERE id = id;
END //

CREATE PROCEDURE delete_factura(IN id INT)
BEGIN
    DELETE FROM tbl_facturas WHERE id = id;
END //

CREATE PROCEDURE delete_producto(IN id INT)
BEGIN
    DELETE FROM cat_productos WHERE id = id;
END //

CREATE PROCEDURE get_all_clientes()
BEGIN
    SELECT * FROM tbl_clientes;
END //

CREATE PROCEDURE get_all_detalles_factura()
BEGIN
    SELECT * FROM tbl_detalles_factura;
END //

CREATE PROCEDURE get_all_facturas()
BEGIN
    SELECT * FROM tbl_facturas;
END //

CREATE PROCEDURE get_all_productos()
BEGIN
    SELECT * FROM cat_productos;
END //

CREATE PROCEDURE get_all_tipos_cliente()
BEGIN
    SELECT * FROM cat_tipo_cliente;
END //

CREATE PROCEDURE get_cliente_by_id(IN id INT)
BEGIN
    SELECT * FROM tbl_clientes WHERE id = id;
END //

CREATE PROCEDURE get_detalle_factura_by_id(IN id INT)
BEGIN
    SELECT * FROM tbl_detalles_factura WHERE id_factura = id;
END //

CREATE PROCEDURE get_factura_by_id(IN id INT)
BEGIN
    SELECT * FROM tbl_facturas WHERE id = id;
END //

CREATE PROCEDURE get_facturas_by_cliente_id(IN id_cliente INT)
BEGIN
    SELECT * FROM tbl_facturas WHERE id_cliente = id_cliente;
END //

CREATE PROCEDURE get_facturas_by_numero_factura(IN numero_factura INT)
BEGIN
    SELECT * FROM tbl_facturas WHERE numero_factura = numero_factura;
END //

CREATE PROCEDURE get_producto_by_id(IN id INT)
BEGIN
    SELECT * FROM cat_productos WHERE id = id;
END //

CREATE PROCEDURE get_tipo_cliente_by_id(IN id INT)
BEGIN
    SELECT * FROM cat_tipo_cliente WHERE id = id;
END //

CREATE PROCEDURE update_cliente(
    IN id INT,
    IN razon_social VARCHAR(200),
    IN id_tipo_cliente INT,
    IN fecha_creacion DATE,
    IN rfc VARCHAR(50)
)
BEGIN
    UPDATE tbl_clientes
    SET razon_social = razon_social,
        id_tipo_cliente = id_tipo_cliente,
        fecha_creacion = fecha_creacion,
        rfc = rfc
    WHERE id = id;
END //

CREATE PROCEDURE update_detalle_factura(
    IN id INT,
    IN id_factura INT,
    IN id_producto INT,
    IN cantidad_de_producto INT,
    IN precio_unitario_producto DECIMAL(18, 2),
    IN subtotal_producto DECIMAL(18, 2),
    IN notas VARCHAR(200)
)
BEGIN
    UPDATE tbl_detalles_factura
    SET id_factura = id_factura,
        id_producto = id_producto,
        cantidad_de_producto = cantidad_de_producto,
        precio_unitario_producto = precio_unitario_producto,
        subtotal_producto = subtotal_producto,
        notas = notas
    WHERE id = id;
END //

CREATE PROCEDURE update_factura(
    IN id INT,
    IN fecha_emision_factura DATETIME,
    IN id_cliente INT,
    IN numero_factura INT,
    IN numero_total_articulos INT,
    IN subtotal_facturas DECIMAL(18, 2),
    IN total_impuestos DECIMAL(18, 2),
    IN total_factura DECIMAL(18, 2)
)
BEGIN
    UPDATE tbl_facturas
    SET fecha_emision_factura = fecha_emision_factura,
        id_cliente = id_cliente,
        numero_factura = numero_factura,
        numero_total_articulos = numero_total_articulos,
        subtotal_facturas = subtotal_facturas,
        total_impuestos = total_impuestos,
        total_factura = total_factura
    WHERE id = id;
END //

CREATE PROCEDURE update_producto(
    IN id INT,
    IN nombre_producto VARCHAR(50),
    IN imagen_producto LONGBLOB,
    IN precio_unitario DECIMAL(18, 2),
    IN ext VARCHAR(5)
)
BEGIN
    UPDATE cat_productos
    SET nombre_producto = nombre_producto,
        imagen_producto = imagen_producto,
        precio_unitario = precio_unitario,
        ext = ext
    WHERE id = id;
END //

DELIMITER ;