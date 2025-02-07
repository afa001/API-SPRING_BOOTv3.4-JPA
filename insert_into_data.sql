USE spring_boot_backend_db;

-- Insert data into cat_productos
INSERT INTO cat_productos (nombre_producto, imagen_producto, precio_unitario, ext) VALUES
('Laptop', NULL, 1200.00, 'jpg'),
('Smartphone', NULL, 800.00, 'png'),
('Tablet', NULL, 500.00, 'jpg'),
('Monitor', NULL, 300.00, 'png'),
('Keyboard', NULL, 50.00, 'jpg'),
('Mouse', NULL, 25.00, 'png'),
('Printer', NULL, 150.00, 'jpg'),
('Scanner', NULL, 100.00, 'png'),
('Webcam', NULL, 75.00, 'jpg'),
('Headphones', NULL, 60.00, 'png'),
('Speakers', NULL, 120.00, 'jpg'),
('External Hard Drive', NULL, 200.00, 'png'),
('USB Flash Drive', NULL, 20.00, 'jpg'),
('Router', NULL, 80.00, 'png'),
('Smartwatch', NULL, 250.00, 'jpg');

-- Insert data into cat_tipo_cliente
INSERT INTO cat_tipo_cliente (tipo_cliente) VALUES
('Individual'),
('Business'),
('Government'),
('Non-Profit'),
('Educational'),
('Healthcare'),
('Retail'),
('Wholesale'),
('Manufacturing'),
('Technology'),
('Finance'),
('Real Estate'),
('Transportation'),
('Utilities'),
('Entertainment');

-- Insert data into tbl_clientes
INSERT INTO tbl_clientes (razon_social, id_tipo_cliente, fecha_creacion, rfc) VALUES
('John Doe', 1, '2025-01-01', 'JDOE123456'),
('Acme Corp', 2, '2025-01-02', 'ACME123456'),
('City Government', 3, '2025-01-03', 'CITY123456'),
('Helping Hands', 4, '2025-01-04', 'HELP123456'),
('Tech University', 5, '2025-01-05', 'TECH123456'),
('Health Clinic', 6, '2025-01-06', 'HEAL123456'),
('Retail Store', 7, '2025-01-07', 'RETA123456'),
('Wholesale Inc', 8, '2025-01-08', 'WHOL123456'),
('Manufacturing Co', 9, '2025-01-09', 'MANU123456'),
('Tech Solutions', 10, '2025-01-10', 'TECH123457'),
('Finance Group', 11, '2025-01-11', 'FINA123456'),
('Real Estate LLC', 12, '2025-01-12', 'REAL123456'),
('Transport Services', 13, '2025-01-13', 'TRAN123456'),
('Utility Company', 14, '2025-01-14', 'UTIL123456'),
('Entertainment Hub', 15, '2025-01-15', 'ENTE123456');

-- Insert data into tbl_facturas
INSERT INTO tbl_facturas (fecha_emision_factura, id_cliente, numero_factura, numero_total_articulos, subtotal_facturas, total_impuestos, total_factura) VALUES
('2025-01-01 10:00:00', 1, 1001, 2, 2000.00, 320.00, 2320.00),
('2025-01-02 11:00:00', 2, 1002, 3, 1500.00, 240.00, 1740.00),
('2025-01-03 12:00:00', 3, 1003, 1, 500.00, 80.00, 580.00),
('2025-01-04 13:00:00', 4, 1004, 4, 1200.00, 192.00, 1392.00),
('2025-01-05 14:00:00', 5, 1005, 5, 2500.00, 400.00, 2900.00),
('2025-01-06 15:00:00', 6, 1006, 2, 300.00, 48.00, 348.00),
('2025-01-07 16:00:00', 7, 1007, 3, 450.00, 72.00, 522.00),
('2025-01-08 17:00:00', 8, 1008, 1, 100.00, 16.00, 116.00),
('2025-01-09 18:00:00', 9, 1009, 2, 600.00, 96.00, 696.00),
('2025-01-10 19:00:00', 10, 1010, 3, 900.00, 144.00, 1044.00),
('2025-01-11 20:00:00', 11, 1011, 4, 1200.00, 192.00, 1392.00),
('2025-01-12 21:00:00', 12, 1012, 5, 1500.00, 240.00, 1740.00),
('2025-01-13 22:00:00', 13, 1013, 1, 200.00, 32.00, 232.00),
('2025-01-14 23:00:00', 14, 1014, 2, 400.00, 64.00, 464.00),
('2025-01-15 09:00:00', 15, 1015, 3, 600.00, 96.00, 696.00);

-- Insert data into tbl_detalles_factura
INSERT INTO tbl_detalles_factura (id_factura, id_producto, cantidad_de_producto, precio_unitario_producto, subtotal_producto, notas) VALUES
(1, 1, 1, 1200.00, 1200.00, 'Urgent delivery'),
(1, 2, 1, 800.00, 800.00, 'Include warranty'),
(2, 3, 1, 500.00, 500.00, 'Gift wrap'),
(2, 4, 1, 300.00, 300.00, 'Express shipping'),
(2, 5, 1, 50.00, 50.00, 'Include batteries'),
(3, 6, 1, 25.00, 25.00, 'Standard shipping'),
(4, 7, 1, 150.00, 150.00, 'Include extra ink'),
(4, 8, 1, 100.00, 100.00, 'Handle with care'),
(4, 9, 1, 75.00, 75.00, 'Fragile'),
(4, 10, 1, 60.00, 60.00, 'Include case'),
(5, 11, 1, 120.00, 120.00, 'High quality'),
(5, 12, 1, 200.00, 200.00, 'Include cable'),
(5, 13, 1, 20.00, 20.00, 'Fast shipping'),
(5, 14, 1, 80.00, 80.00, 'Include manual'),
(5, 15, 1, 250.00, 250.00, 'Gift wrap');