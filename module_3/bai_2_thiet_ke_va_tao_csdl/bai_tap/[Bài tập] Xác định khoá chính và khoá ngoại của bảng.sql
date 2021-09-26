CREATE DATABASE customer_management;

USE customer_management;
CREATE TABLE customers (
	customer_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE,
    phone VARCHAR(15) NOT NULL UNIQUE
);

CREATE TABLE accounts (
	account_id INT AUTO_INCREMENT PRIMARY KEY,
    date_create_account DATE,
    balance DOUBLE NOT NULL
);

CREATE TABLE account_type (
	account_type_id INT AUTO_INCREMENT PRIMARY KEY,
    account_type VARCHAR(50)
);

CREATE TABLE transactions (
	tran_id INT AUTO_INCREMENT PRIMARY KEY,
    date_transaction DATE NOT NULL,
    amounts DOUBLE,
    deriptions TEXT
);

CREATE TABLE address (
	address_id INT AUTO_INCREMENT PRIMARY KEY,
	street VARCHAR(40),
    ward VARCHAR(40) NOT NULL,
    district VARCHAR(40) NOT NULL,
    city VARCHAR(30) NOT NULL
);

ALTER TABLE customer_management.accounts
	ADD account_type_id INT,
    ADD FOREIGN KEY (account_type_id) REFERENCES account_type(account_type_id);

ALTER TABLE customer_management.transactions
	ADD account_id INT,
    ADD FOREIGN KEY (account_id) REFERENCES accounts(account_id);

ALTER TABLE customer_management.customers
	ADD account_id INT UNIQUE,
    ADD FOREIGN KEY (account_id) REFERENCES accounts(account_id);

ALTER TABLE customer_management.customers
	ADD address_id INT,
    ADD FOREIGN KEY (address_id) REFERENCES address(address_id);

DROP DATABASE customer_management;









