# Phân tích SQL Injection trong truy vấn tìm bệnh nhân

## 1. Mô tả vấn đề

Câu lệnh ban đầu:

```sql
SELECT * FROM Patients WHERE full_name = 'input'
```

Nhưng khi bị tấn công:

```java
String patientName = "' OR '1'='1";
```

Câu SQL thực tế trở thành:

```sql
SELECT * FROM Patients WHERE full_name = '' OR '1'='1'
```

## 2. Luồng thực thi

* Điều kiện `full_name = ''` → thường là FALSE
* Điều kiện `'1'='1'` → luôn TRUE

=> Mệnh đề WHERE trở thành:

```sql
FALSE OR TRUE → TRUE
```

## 3. Kết quả

* WHERE luôn đúng
* Truy vấn trả về **toàn bộ dữ liệu bảng Patients**
* Gây lộ dữ liệu (Data Breach)

## 4. Nguyên nhân

* Nối chuỗi trực tiếp vào SQL (`+ patientName`)
* Không kiểm tra / sanitize input
* Không dùng PreparedStatement

## 5. Kết luận

SQL Injection xảy ra vì:

* Input của người dùng được thực thi như một phần của câu lệnh SQL
* Hacker chèn điều kiện luôn đúng (`OR '1'='1'`) để bypass filter
