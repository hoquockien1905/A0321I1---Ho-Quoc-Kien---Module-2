CREATE DATABASE kien_database;
USE kien_database;

CREATE TABLE student(
	id int primary key,
    name_student varchar(50),
    address varchar(50)
);

ALTER TABLE kien_database.student ADD dob date;
INSERT INTO student VALUES (1, "Kien", "QN", "20000519");
INSERT INTO student VALUES (2, "Kien", "DN", "20000519");
INSERT INTO student(id, address) VALUES (3, "HCM");
SELECT * FROM kien_database.student;

