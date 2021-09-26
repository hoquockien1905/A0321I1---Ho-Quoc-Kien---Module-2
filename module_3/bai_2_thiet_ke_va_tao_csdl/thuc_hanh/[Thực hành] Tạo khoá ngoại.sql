USE kien_database;
CREATE TABLE customers (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40),
    address VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE orders (
	id INT AUTO_INCREMENT,
    staff VARCHAR(50),
    customer_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);