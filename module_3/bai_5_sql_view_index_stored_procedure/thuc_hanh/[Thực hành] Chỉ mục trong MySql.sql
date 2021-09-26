USE classicmodels;

ALTER TABLE customers 
	ADD INDEX idx_customer(customerNumber);
    
SELECT * FROM customers WHERE customerNumber = 175;

ALTER TABLE customers
	ADD INDEX idx_number_and_name(customerNumber, customerName);
    
SELECT * FROM customers WHERE customerNumber = 175 or customerName = "Gift Depot Inc.";

ALTER TABLE customers
	DROP INDEX idx_customer,
	DROP INDEX idx_number_and_name;