CREATE DATABASE kien_database;
USE kien_database;

CREATE TABLE courses (
	id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(40) NOT NULL
);

CREATE TABLE student (
	id INT AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    money DOUBLE NOT NULL,
    course_id INT,
    FOREIGN KEY (course_id) REFERENCES courses(id)
);

INSERT INTO courses 
VALUES 
(1, "CNTT"), 
(2, "DTVT"), 
(3, "KTDN"), 
(4, "CK"), 
(5, "TCNH");

INSERT INTO student(student_name, age, money, course_id)
VALUES ("Hoàng", 21, 400000, 1),
	("Việt", 19, 320000, 2),
	("Thanh", 18, 400000, 3),
    ("Nhàn", 19, 450000, 4),
    ("Hương", 20, 200000, 5),
    ("Hương", 20, 200000, 5);

-- Viết câu lệnh hiện thị tất cả các dòng có tên là Huong
SELECT * FROM student WHERE student_name = "Hương";

-- Viết câu lệnh lấy ra tổng số tiền của Huong
SELECT student_name,SUM(money) AS sum_money_of_huong FROM student WHERE student_name = "Hương";

-- Viết câu lệnh lấy ra tên danh sách của tất cả học viên, không trùng lặp
SELECT DISTINCT student_name FROM student;
SELECT student_name FROM student GROUP BY student_name;

