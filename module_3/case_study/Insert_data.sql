
INSERT INTO positions(position_name) 
VALUES 
("General Director"),
("Deputy General Manager"),
("Receptionist"),
("Bell man"),
("Executive Chef"),
("Waiter"),
("Marketer"),
("General Accountant"),
("Cashier"),
("Security Officer");

INSERT INTO education_degree(education_degree_name)
VALUES 
("Colege degree"),
("Intermediate degree"),
("Bachelor’s degree"),
("Master’s degree"),
("Doctoral degree");

INSERT INTO division(division_name)
VALUES 
("Leaders"),
("Front desk department"),
("Room department"),
("Food department"),
("Business department"),
("Finance department"),
("Technical department"),
("Other parts");

INSERT INTO customer_type(customer_type_name)
VALUES
("Diamond"),
("Platinum"),
("Gold"),
("Silver"),
("Member");

INSERT INTO service_type(service_type_name)
VALUES
("Villa"),
("House"),
("Room");

INSERT INTO rent_type(rent_type_name, rent_type_cost)
VALUES
("Year", 105000),
("Month", 85000),
("Week", 65500),
("Day", 50000),
("Hour", 30000);

INSERT INTO attach_service(attach_service_name, attach_service_cost, attach_service_unit, attach_service_status)
VALUES
("Massage", 1000, 00, "full"),
("Karaoke", 1000, 00, "still"),
("Buffet", 500, 00, "still"),
("Water", 200, 00, "stull");

INSERT INTO service(service_name, service_area, service_cost, service_max_people, 
standard_room, decription_other_convenience, pool_area, number_of_floors, 
rent_type_id, service_type_id)
VALUES
("Villa", 50, 2000, 4, "VIP", "fresh", 20, 3, 2, 1),
("House", 40, 1500, 3, "Normal", "fresh", 15, 2, 3, 2),
("Room", 30, 1000, 2, "Normal", "normal", 10, 2, 1, 3);

INSERT INTO address(street, ward, district, city_or_province)
VALUES
("71 Nguyễn Duy Trinh", "Hòa Hải", "Ngũ Hành Sơn", "Đà Nẵng"),
("29 Huyền Trân Công Chúa", "Thạc Gián", "Hải Châu", "Đà Nẵng"),
("Đường Xóm Cồn", "Tam Phú", "Tam Kỳ", "Quảng Nam"),
("51 Phan Châu Trinh", "An Xuân", "Tam Kỳ", "Quảng Nam"),
("399 Trưng Nữ Vương", "Nại Hiên Đông", "Sơn Trà", "Đà Nẵng"),
("92 Cao Bá Quát", "Bình Hưng Hòa", "Bình Tân", "Hồ Chí Minh"),
("19 Phan Đăng Lưu", "Phú Thuận", "Huế", "Thừa Thiên Huế"),
("231 Võ Chí Thanh", "Tây Lộc", "Huế", "Thừa Thiên Huế"),
("34 Nguyễn Tri Phương", "Tân Định", "Quận 1", "Hồ Chí Minh"),
("12 Hàm Nghi", "Nghĩa Hà", "Quảng Ngãi", "Quảng Ngãi"),
("22 Ông Ích Khiêm", "Tịnh Khê", "Quảng Ngãi", "Quảng Ngãi"),
("120 Trần Hưng Đạo", "Hải Cảng", "Quy Nhơn", "Bình Định"),
("19 Quang Trung", "Quang Trung", "Quy Nhơn", "Bình Định"),
("34 Nguyễn Văn Linh", "Thạc Gián", "Hải Châu", "Đà Nẵng"),
("05 Nguyễn Hoàng", "Thạc Gián", "Hải Châu", "Đà Nẵng"),
("19 Hoàng Diệu", "Thạc Gián", "Hải Châu", "Đà Nẵng"),
("199 Nguyễn Văn Linh", "Thạc Gián", "Hải Châu", "Đà Nẵng");

INSERT INTO customer(customer_name, customer_birthday, customer_gender, customer_id_card, 
customer_phone, customer_email, address_id, customer_type_id)
VALUES
("Hồ Quốc Kiên", "19990519", 1, "206314832", "0399733998", "hquockien@gmail.com", 3, 1),
("Trần Trung Hiếu", "20000215", 1, "203586489", "0935162534", "hieu@gmail.com", 1, 3),
("Lê Thị Thu Thảo", "20010822", 0, "234874313", "0356854698", "thao@gmail.com", 8, 5),
("Ngô Bảo Hân", "19980512", 0, "212421121", "0314942842", "han@gmail.com", 4, 2),
("Trần Bá Dự", "19950319", 1, "212434512", "0936938293", "du@gmail.com", 10, 4),
("Huỳnh Hiểu Khánh", "20020929", 1, "223445212", "0931323942", "khanh@gmail.com", 7, 2);

INSERT INTO user
VALUES
("quockien1905", 123456789),
("hieutran1502", 123456789),
("baohan1502", 123456789),
("badu1903", 123456789),
("hieukhanh2909", 123456789),
("minhquan1207", 123456789),
("vanha0506", 123456789),
("vumminh1509", 123456789),
("huudat1608", 123456789),
("ductien1809", 123456789),
("minhthanh2406", 123456789),
("minhnam0307", 123456789),
("minhtien1007", 123456789),
("vanvu1706", 123456789),
("vutuan1503", 123456789),
("ducquang1804", 123456789),
("minhdo2406",123456789),
("minhluan2807", 123456789);

INSERT INTO role(role_name)
VALUES
("role_1"),
("role_2"),
("role_3"),
("role_4"),
("role_5");

INSERT INTO user_role
VALUES 
(1, "quockien1905"),
(2, "hieutran1502"),
(3, "baohan1502"),
(4, "badu1903"),
(5, "hieukhanh2909");

INSERT INTO employee(employee_name, employee_birthday, employee_id_card, employee_salary,
employee_phone, employee_email, address_id, position_id, education_degree_id, division_id, username)
VALUES
("Trần Minh Quân", "20001207", "245564234", "1000", "0392934823", "quan@gmail.com", 4, 2, 4, 1, "minhquan1207"),
("Hồ Văn Hà", "19980605", "235846848", "1000.00", "0365226586", "ha@gmail.com", 3, 5, 1, 3, "vanha0506"),
("Hà Vũ Minh", "20030915", "223423523", "1200.00", "0345938949", "minh@gmail.com", 9, 6, 2, 3, "vumminh1509"),
("Vũ Đức Tiến", "19960918", "250483085", "1400.00", "0394833948", "tien@gmail.com", 7, 4, 5, 2, "ductien1809"),
("Võ Minh Thành", "19970624", "294873948", "1300.00", "0368546526", "thanh@gmail.com", 8, 5, 4, 2, "minhthanh2406"),
("Nguyễn Minh Nam", "19980703", "213568468", "1200", "0365488454", "nam@gmail.com", 12, 3, 2, 4, "minhnam0307"),
("Trần Minh Tiến", "20001007", "245564232", "1200", "0392934843", "tien@gmail.com", 14, 1, 4, 1, "minhtien1007"),
("Hồ Văn Vũ", "19980617", "235826848", "1030.00", "0365426586", "vu@gmail.com", 16, 5, 4, 3, "vanvu1706"),
("Hà Vũ Tuấn", "20030315", "221423523", "1300.00", "0345978949", "tuan@gmail.com", 14, 3, 2, 3, "vutuan1503"),
("Vũ Đức Quang", "19960418", "250483045", "1500.00", "0394833648", "quang@gmail.com", 17, 2, 5, 2, "ducquang1804"),
("Võ Minh Đô", "19930624", "294573948", "2200.00", "0368246526", "do@gmail.com", 14, 5, 4, 1, "minhdo2406"),
("Nguyễn Minh Luân", "19980728", "213528468", "1800", "0326488454", "luan@gmail.com", 15, 5, 2, 4, "minhluan2807");

INSERT INTO contract(contract_start_date, contract_end_date, contract_deposit, contract_total_money,
employee_id, customer_id, service_id)
VALUES
("2019-06-20 00:00:00", "2020-02-29 00:00:00", 1700, 2200, 10, 1, 2),
("2019-05-15 00:00:00", "2020-12-06 00:00:00", 1700, 2200, 11, 1, 2),
("2019-02-04 00:00:00", "2020-05-08 00:00:00", 1700, 2200, 8, 1, 2),
("2019-07-11 00:00:00", "2020-01-24 00:00:00", 1700, 2200, 7, 1, 2),
("2019-12-12 00:00:00", "2020-11-06 00:00:00", 1700, 2200, 9, 1, 2),
("2014-01-15 00:00:00", "2015-06-15 12:00:00", "950", "1300", 2, 3, 1),
("2013-05-05 00:00:00", "2014-05-05 12:00:00", "1000", "1500", 5, 1, 1),
("2021-05-05 00:00:00", "2022-05-05 12:00:00", "1000", "1500", 1, 1, 1),
("2021-03-25 00:00:00", "2021-08-25 12:00:00", "1200", "2000", 2, 2, 2),
("2021-01-15 00:00:00", "2021-06-15 12:00:00", "950", "1300", 3, 3, 3),
("2021-01-01 00:00:00", "2022-01-01 12:00:00", "2300", "3000", 4, 4, 2),
("2021-03-19 00:00:00", "2021-08-19 00:00:00", "1400", 1800, 5, 5, 1),
("2018-03-03 00:00:00", "2021-02-02 00:00:00", "1900", 2000, 4, 2, 2),
("2019-01-02 00:00:00", "2020-05-06 00:00:00", 2000, 2300, 3, 1, 3),
("2019-10-02 00:00:00", "2020-11-06 00:00:00", 2000, 2300, 3, 1, 3),
("2019-12-12 00:00:00", "2020-11-06 00:00:00", 1700, 2200, 3, 1, 2);

INSERT INTO contract_detail(quantity, contract_id, attach_service_id)
VALUES
(3, 2, 4),
(5, 5, 1),
(2, 1, 3),
(1, 4, 2),
(4, 3, 1);


