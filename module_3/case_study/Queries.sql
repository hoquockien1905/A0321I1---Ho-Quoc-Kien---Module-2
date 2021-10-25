-- Câu 2: Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là 
-- một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
SELECT * FROM employee
WHERE (employee_name LIKE "H%" OR employee_name LIKE "T%" OR employee_name LIKE "K%") AND  length(employee_name) < 15;

-- Câu 3: Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và 
-- có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT DISTINCT customer.*, city_or_province FROM customer, address
WHERE city_or_province IN ("Đà Nẵng", "Quảng Trị") 
AND (curdate() - customer_birthday > (18*30*365)) 
AND (curdate() - customer_birthday < (50*30*365));

-- Câu 4: Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu
-- lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của
-- khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
SELECT customer.customer_name, COUNT(contract.customer_id) AS number_of_booking
FROM customer 
INNER JOIN contract ON customer.customer_id = contract.customer_id
INNER JOIN customer_type ON customer.customer_type_id = customer_type.customer_type_id 
WHERE customer_type.customer_type_name = "Diamond"
GROUP BY customer.customer_id ORDER BY number_of_booking;

-- Câu 5: Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
-- cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
SELECT customer.customer_id, customer.customer_name, customer_type.customer_type_name, contract.contract_id, 
service.service_name, contract.contract_start_date, contract.contract_end_date,
SUM(service.service_cost + contract_detail.quantity * attach_service.attach_service_cost) AS sum 
FROM customer
LEFT JOIN customer_type ON customer_type.customer_type_id = customer.customer_type_id
LEFT JOIN contract ON contract.customer_id = customer.customer_id
LEFT JOIN service ON service.service_id = contract.service_id
LEFT JOIN contract_detail ON contract_detail.contract_id = contract.contract_id
LEFT JOIN attach_service ON attach_service.attach_service_id = contract_detail.attach_service_id
GROUP BY contract.contract_id;

-- 6. Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue,
-- TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được Khách hàng
-- thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
SELECT service_id, service_name, service_area, service_cost, service_type_name
FROM service
INNER JOIN service_type ON service.service_type_id = service_type.service_type_id
WHERE NOT EXISTS (
	SELECT contract.contract_id FROM contract
    WHERE (contract.contract_start_date BETWEEN "2019-01-01" AND "2019-03-31") AND contract.service_id = service.service_id
);

-- 7. Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa,
-- ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ đã từng được
-- Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách
-- hàng đặt phòng trong năm 2019.
SELECT service_id, service_name, service_area, service_max_people, service_cost, service_type.service_type_name
FROM service
INNER JOIN service_type ON service.service_type_id = service_type.service_type_id
WHERE EXISTS (
	SELECT contract.contract_id FROM contract
    WHERE year(contract.contract_start_date) = "2018" AND contract.service_id = service.service_id
) AND NOT EXISTS (
	SELECT contract.contract_id FROM contract
    WHERE year(contract.contract_start_date) = "2019" AND contract.service_id = service.service_id
);

-- 8. Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu
-- HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên

-- Cách 1:
SELECT DISTINCT customer_name FROM customer;

-- Cách 2:
SELECT customer_name FROM customer GROUP BY customer.customer_name;

-- Cách 3:
SELECT customer_name FROM customer UNION SELECT customer_name FROM customer;

-- 9. Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi
-- tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt
-- phòng.
SELECT temp.month, COUNT(month(contract.contract_start_date)) AS number_of_customer_register, SUM(contract.contract_total_money) AS sum FROM
(SELECT 1 AS month
UNION SELECT 2 AS month
UNION SELECT 3 AS month
UNION SELECT 4 AS month
UNION SELECT 5 AS month
UNION SELECT 6 AS month
UNION SELECT 7 AS month
UNION SELECT 8 AS month
UNION SELECT 9 AS month
UNION SELECT 10 AS month
UNION SELECT 11 AS month
UNION SELECT 12 AS month) AS temp
LEFT JOIN contract ON temp.month = month(contract.contract_start_date)
LEFT JOIN customer ON customer.customer_id = contract.customer_id
WHERE year(contract.contract_start_date) = "2019" OR year(contract.contract_start_date) IS NULL OR month(contract.contract_start_date) IS NULL
GROUP BY temp.month
ORDER BY temp.month;

-- 10. Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu
-- Dịch vụ đi kèm. Kết quả hiển thị bao gồm IDHopDong,
-- NgayLamHopDong, NgayKetthuc, TienDatCoc,
-- SoLuongDichVuDiKem (được tính dựa trên việc count các
-- IDHopDongChiTiet).
SELECT contract.contract_id, contract.contract_start_date, contract.contract_end_date, contract_deposit,
COUNT(contract_detail.attach_service_id) AS number_of_attach_service 
FROM contract
INNER JOIN contract_detail ON contract.contract_id = contract_detail.contract_id
GROUP BY contract.contract_id ORDER BY contract_id;

-- 11. Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách
-- hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh”
-- hoặc “Quảng Ngãi”.
SELECT attach_service.attach_service_name, attach_service.attach_service_cost, attach_service.attach_service_unit FROM contract
INNER JOIN contract_detail ON contract_detail.contract_id = contract.contract_id
INNER JOIN attach_service ON contract_detail.attach_service_id = attach_service.attach_service_id
INNER JOIN customer ON contract.customer_id = customer.customer_id
INNER JOIN address ON address.address_id = customer.address_id
INNER JOIN customer_type ON customer_type.customer_type_id = customer.customer_type_id
WHERE customer_type.customer_type_name = "Diamond" AND address.city_or_province IN ("Vinh", "Quảng Ngãi");

-- 12. Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang,
-- SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được
-- tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ
-- đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa
-- từng được khách hàng đặt vào 6 tháng đầu năm 2019.
SELECT contract.contract_id, employee.employee_name, customer.customer_name, customer.customer_phone,
service.service_name, COUNT(contract_detail.attach_service_id) AS number_of_attach_service, contract.contract_deposit
FROM contract
INNER JOIN employee ON employee.employee_id = contract.employee_id
INNER JOIN customer ON customer.customer_id = contract.customer_id
INNER JOIN service ON service.service_id = contract.service_id
INNER JOIN contract_detail ON contract_detail.contract_id = contract.contract_id
WHERE EXISTS (
	SELECT contract.contract_id FROM contract
    WHERE contract.contract_start_date BETWEEN "2019-10-01" AND "2019-12-31"
) AND NOT EXISTS (
	SELECT contract.contract_id FROM contract
    WHERE contract.contract_start_date BETWEEN "2019-01-01" AND "2019-06-31"
);

-- 13. Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các
-- Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử
-- dụng nhiều như nhau).
SELECT attach_service.*, COUNT(contract_detail.attach_service_id) AS quantity FROM attach_service
INNER JOIN contract_detail ON contract_detail.attach_service_id = attach_service.attach_service_id
GROUP BY attach_service_id;

-- 14. Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một
-- lần duy nhất. Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu,
-- TenDichVuDiKem, SoLanSuDung.
SELECT contract.contract_id, service.service_name, attach_service.attach_service_name, COUNT(contract_detail.attach_service_id) AS use_times
FROM contract
INNER JOIN service ON service.service_id = contract.service_id
INNER JOIN contract_detail ON contract_detail.contract_id = contract.contract_id
INNER JOIN attach_service ON contract_detail.attach_service_id = attach_service.attach_service_id
GROUP BY attach_service.attach_service_id
HAVING use_times = 1;

-- 15. Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen,
-- TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3
-- hợp đồng từ năm 2018 đến 2019.
SELECT employee_id, employee_name, education_degree.education_degree_name, division.division_name, employee_phone,
address.* FROM employee
INNER JOIN education_degree ON education_degree.education_degree_id = employee.education_degree_id
INNER JOIN division ON division.division_id = employee.division_id
INNER JOIN address ON address.address_id = employee.address_id
WHERE 3 >= (
	SELECT COUNT(contract.employee_id) FROM contract
    WHERE year(contract.contract_start_date) BETWEEN "2018" AND "2019"
);

-- 16. Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017
-- đến năm 2019.
SET SQL_SAFE_UPDATES = 0;
DELETE FROM employee
WHERE employee.employee_id NOT IN (SELECT contract.employee_id FROM contract WHERE year(contract.contract_start_date) BETWEEN "2017" AND "2019");

-- 17. Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ
-- Platinium lên Diamond, chỉ cập nhật những khách hàng đã từng đặt
-- phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn
-- 10.000.000 VNĐ.
SET SQL_SAFE_UPDATES = 0;
UPDATE customer_type 
SET customer_type_name = "Diamond" 
WHERE EXISTS(
	SELECT contract.customer_id FROM contract 
    WHERE contract.contract_total_money > 10000000 AND year(contract.contract_start_date) = "2019"
);

-- 18. Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc
-- giữa các bảng).
SET SQL_SAFE_UPDATES = 0;
DELETE FROM customer
WHERE customer.customer_id IN (SELECT contract.customer_id FROM contract WHERE year(contract.contract_start_date) < "2016");

-- 19. Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong
-- năm 2019 lên gấp đôi.
SET SQL_SAFE_UPDATES = 0;
CREATE TEMPORARY TABLE temp
(SELECT attach_service.attach_service_id FROM attach_service 
INNER JOIN contract_detail ON contract_detail.attach_service_id = attach_service.attach_service_id
GROUP BY attach_service_id
HAVING COUNT(contract_detail.attach_service_id) > 10);
UPDATE attach_service
SET attach_service_cost = attach_service_cost * 2
WHERE attach_service.attach_service_id IN (SELECT * FROM temp);

-- 20. Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ
-- thống, thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang),
-- HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
SELECT customer_id AS ID, customer_name AS Full_name, customer_email AS Email, customer_phone AS phone, customer_birthday AS Birthday
FROM customer
UNION ALL
SELECT employee_id AS ID, employee_name AS Full_name, employee_email AS Email, employee_phone AS phone, employee_birthday AS Birthday
FROM employee;

-- 21. Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả
-- các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho 1
-- hoặc nhiều Khách hàng bất kỳ với ngày lập hợp đồng là “12/12/2019”
CREATE VIEW v_employee
AS
SELECT employee.employee_id, employee_name, employee_birthday, employee_phone, address.district, 
contract.contract_start_date
FROM employee
INNER JOIN address ON address.address_id = employee.address_id
INNER JOIN contract ON contract.employee_id = employee.employee_id
WHERE address.district = "Hải Châu" AND contract.contract_start_date = "2019-12-12";

-- 22. Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành
-- “Liên Chiểu” đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.
SELECT * FROM v_employee;
UPDATE v_employee
SET district = "Liên Chiểu";







































