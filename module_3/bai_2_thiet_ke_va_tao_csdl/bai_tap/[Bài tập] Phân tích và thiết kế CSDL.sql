CREATE DATABASE sales_management;
USE sales_management;

CREATE TABLE address (
	id INT AUTO_INCREMENT PRIMARY KEY,
    address_line1 VARCHAR(40) NOT NULL,
    address_line2 VARCHAR(40),
    state VARCHAR(20),
    country VARCHAR(50) NOT NULL,
    postal_code VARCHAR(20) NOT NULL
);

CREATE TABLE product_line (
	id INT AUTO_INCREMENT PRIMARY KEY,
    decription TEXT,
    image VARCHAR(255)
);

CREATE TABLE offices (
	id INT AUTO_INCREMENT PRIMARY KEY,
    address_id INT,
    FOREIGN KEY (address_id) REFERENCES address(id)
);

CREATE TABLE employees (
	id INT AUTO_INCREMENT PRIMARY KEY,
    last_name VARCHAR(20) NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL,
    job_title VARCHAR(30) NOT NULL,
    office_id INT,
    FOREIGN KEY (office_id) REFERENCES offices(id)
);

CREATE TABLE products (
	id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(50) NOT NULL,
    product_scale VARCHAR(10) NOT NULL,
    product_ventor VARCHAR(50) NOT NULL,
    decription TEXT NOT NULL,
    quantity_in_stock INT NOT NULL,
    buy_price DOUBLE NOT NULL,
    MSRP DOUBLE NOT NULL,
    product_line_id INT,
    FOREIGN KEY (product_line_id) REFERENCES product_line(id)
);

CREATE TABLE customers (
	id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(50) NOT NULL,
    contact_last_name VARCHAR(50) NOT NULL,
    contact_first_name VARCHAR(50) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    credit_limit DOUBLE NOT NULL,
    address_id INT,
    employee_id INT,
    FOREIGN KEY (address_id) REFERENCES address(id),
    FOREIGN KEY (employee_id) REFERENCES employees(id)
);

CREATE TABLE orders (
	id INT AUTO_INCREMENT PRIMARY KEY,
    order_date DATE NOT NULL,
    required_date DATE NOT NULL,
    shipped_date DATE NOT NULL,
    status VARCHAR(15) NOT NULL,
    comments TEXT,
    quantity_order INT NOT NULL,
    price_each DOUBLE NOT NULL,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE TABLE order_detail (
	product_id INT,
    order_id INT,
    PRIMARY KEY(product_id, order_id),
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (order_id) REFERENCES orders(id)
);

CREATE TABLE payments (
	id INT AUTO_INCREMENT PRIMARY KEY,
    payment_date DATE NOT NULL,
    amount DOUBLE NOT NULL,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);








