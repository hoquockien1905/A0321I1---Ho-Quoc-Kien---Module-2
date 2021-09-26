CREATE DATABASE demo;
USE demo;

CREATE TABLE products (
	id INT AUTO_INCREMENT PRIMARY KEY,
    productCode VARCHAR(15) NOT NULL,
    productName VARCHAR(50) NOT NULL,
    productPrice DOUBLE NOT NULL,
    productAmount DOUBLE,
    productDecription TEXT,
    productStatus VARCHAR(20)
);

INSERT INTO products(productCode, productName, productPrice) VALUES 
("SMP001", "Iphone", 1100),
("SMP002", "Nokia", 1200),
("SMP003", "Samsung", 2000),
("SMP004", "Oppo", 2100),
("SMP005", "Vivo", 3000),
("SMP006", "Sony", 1500),
("SMP007", "Lenovo", 2500);

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
ALTER TABLE products
	ADD INDEX idx_productCode(productCode);
    
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
ALTER TABLE products
	ADD INDEX idx_name_and_price(productName, productPrice);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
EXPLAIN SELECT * FROM products WHERE productCode = "SMP003";

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
CREATE VIEW info_product AS
SELECT productCode, productName, productPrice, productStatus FROM products;

SELECT * FROM info_product;

-- Tiến hành sửa đổi view
CREATE OR REPLACE VIEW info_product AS
SELECT productName, productPrice FROM products WHERE productPrice = 1100;

-- Tiến hành xoá view
DROP VIEW info_product;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER //
CREATE PROCEDURE getAllInfoProduct()
BEGIN
	SELECT * FROM products;
END //
DELIMITER ;

CALL getAllInfoProduct();

-- Tạo store procedure thêm một sản phẩm mới
DELIMITER //
CREATE PROCEDURE addNewProduct(
	IN productCode VARCHAR(15), 
	IN productName VARCHAR(50),
    IN productPrice DOUBLE,
    IN productAmount DOUBLE,
    IN productDecription TEXT,
    IN productStatus VARCHAR(20)
)
BEGIN
	INSERT INTO products(productCode, productName, productPrice, productAmount, productDecription, productStatus)
    VALUES (productCode, productName, productPrice, productAmount, productDecription, productStatus);
END //
DELIMITER ;

CALL addNewProduct("SMP008", "IphoneX", 2000, 3000, "Gold", "Empty");

-- Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER // 
CREATE PROCEDURE updateProductById(
IN productId INT,
IN productCode VARCHAR(15), 
IN productName VARCHAR(50),
IN productPrice DOUBLE,
IN productAmount DOUBLE,
IN productDecription TEXT,
IN productStatus VARCHAR(20)
)
BEGIN
	UPDATE products SET
    productCode = productCode,
    productName = productName,
    productPrice = productPrice,
    productAmount = productAmount,
    productDecription = productDecription,
    productStatus = productStatus
    WHERE id = productId;
END //
DELIMITER ;

CALL updateProductById(8, "SMP010", "IphoneXSMAX", 4000, 4500, "Diamond", "empty");

-- Tạo store procedure xoá sản phẩm theo id
DELIMITER // 
CREATE PROCEDURE deleteProductById(IN productId INT)
BEGIN
	DELETE FROM products WHERE id = productId;
END //
DELIMITER ;

CALL deleteProductById(8);


