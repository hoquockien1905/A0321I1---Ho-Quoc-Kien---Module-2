

DELIMITER //
CREATE PROCEDURE getCustomerNumber(IN cusNumber INT)
BEGIN
	SELECT * FROM customers
    WHERE customerNumber = cusNumber;
END //
DELIMITER ;

CALL getCustomerNumber(250);

DELIMITER //
DROP PROCEDURE IF EXISTS getCustomerCountByCity//
CREATE PROCEDURE getCustomerCountByCity(IN in_city VARCHAR(50), OUT total INT)
BEGIN
	SELECT COUNT(customerNumber) INTO total FROM customers
    WHERE city = in_city;
END //
DELIMITER ;

CALL getCustomerCountByCity('Lyon', @total);
SELECT @total;

DELIMITER //
CREATE PROCEDURE setCounter(INOUT counter INT, IN inc INT)
BEGIN
	SET counter = counter + inc;
END //
DELIMITER ;

SET @counter = 1;
CALL setCounter(@counter, 1);
CALL setCounter(@counter, 1);
CALL setCounter(@counter, 5);
SELECT @counter;





