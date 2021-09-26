

DELIMITER //
CREATE PROCEDURE show_info_products()
BEGIN 
	SELECT * FROM products LIMIT 0, 10;
END //
DELIMITER ;

CALL show_info_products();

DELIMITER //
DROP PROCEDURE IF EXISTS find_all_customers //
CREATE PROCEDURE find_all_customers()
BEGIN
	SELECT * FROM customers LIMIT 0, 5;
END //
DELIMITER ;

CALL find_all_customers();
