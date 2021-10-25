CREATE DATABASE furama_resort;
USE furama_resort;

CREATE TABLE positions (
	position_id INT AUTO_INCREMENT PRIMARY KEY,
    position_name VARCHAR(45) NOT NULL
);

CREATE TABLE education_degree (
	education_degree_id INT AUTO_INCREMENT PRIMARY KEY,
    education_degree_name VARCHAR(45) NOT NULL
);

CREATE TABLE division (
	division_id INT AUTO_INCREMENT PRIMARY KEY,
    division_name VARCHAR(45) NOT NULL
);

CREATE TABLE customer_type (
	customer_type_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_type_name VARCHAR(45) NOT NULL
);

CREATE TABLE service_type (
	service_type_id INT AUTO_INCREMENT PRIMARY KEY,
    service_type_name VARCHAR(45) NOT NULL
);

CREATE TABLE rent_type (
	rent_type_id INT AUTO_INCREMENT PRIMARY KEY,
    rent_type_name VARCHAR(45) NOT NULL,
    rent_type_cost DOUBLE NOT NULL
);

CREATE TABLE attach_service (
	attach_service_id INT AUTO_INCREMENT PRIMARY KEY,
    attach_service_name VARCHAR(45) NOT NULL,
    attach_service_cost DOUBLE NOT NULL,
    attach_service_unit INT,
    attach_service_status VARCHAR(45)
);

CREATE TABLE service (
	service_id INT AUTO_INCREMENT PRIMARY KEY,
    service_name VARCHAR(45) NOT NULL,
    service_area INT,
    service_cost DOUBLE NOT NULL,
    service_max_people INT,
    standard_room VARCHAR(45),
    decription_other_convenience VARCHAR(45),
    pool_area DOUBLE,
    number_of_floors INT,
    rent_type_id INT,
    service_type_id INT,
    FOREIGN KEY (rent_type_id) REFERENCES rent_type(rent_type_id)
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (service_type_id) REFERENCES service_type(service_type_id)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE address (
	address_id INT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(45) NOT NULL,
    ward VARCHAR(45),
    district VARCHAR(45),
    city_or_province VARCHAR(45)
);

CREATE TABLE customer (
	customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(45) NOT NULL,
    customer_birthday DATE,
    customer_gender BIT(1),
    customer_id_card VARCHAR(45),
    customer_phone VARCHAR(45),
    customer_email VARCHAR(45),
    address_id INT,
    customer_type_id INT,
    FOREIGN KEY (address_id) REFERENCES address(address_id)
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (customer_type_id) REFERENCES customer_type(customer_type_id)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE role (
	role_id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL
);

CREATE TABLE user (
	username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE user_role (
	role_id INT,
    username VARCHAR(255),
    PRIMARY KEY(role_id, username),
    FOREIGN KEY (role_id) REFERENCES role(role_id)
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (username) REFERENCES user(username)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE employee (
	employee_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_name VARCHAR(45) NOT NULL,
    employee_birthday DATE,
    employee_id_card VARCHAR(45) NOT NULL,
    employee_salary DOUBLE,
    employee_phone VARCHAR(45),
    employee_email VARCHAR(45),
    address_id INT,
    position_id INT,
    education_degree_id INT,
    division_id INT,
    username VARCHAR(255),
    FOREIGN KEY (address_id) REFERENCES address(address_id)
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (education_degree_id) REFERENCES education_degree(education_degree_id)
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (position_id) REFERENCES positions(position_id)
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (division_id) REFERENCES division(division_id)
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (username) REFERENCES user(username)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE contract (
	contract_id INT AUTO_INCREMENT PRIMARY KEY,
    contract_start_date DATETIME NOT NULL,
    contract_end_date DATETIME NOT NULL,
    contract_deposit DOUBLE NOT NULL,
    contract_total_money DOUBLE NOT NULL,
    employee_id INT,
    customer_id INT,
    service_id INT,
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (service_id) REFERENCES service(service_id)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE contract_detail (
	contract_detail_id INT AUTO_INCREMENT PRIMARY KEY,
    quantity INT,
    contract_id INT,
    attach_service_id INT,
    FOREIGN KEY (contract_id) REFERENCES contract(contract_id)
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (attach_service_id) REFERENCES attach_service(attach_service_id)
    ON UPDATE CASCADE ON DELETE CASCADE
);










