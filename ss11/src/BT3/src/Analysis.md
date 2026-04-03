# Phân tích executeUpdate() trong JDBC

## 1. Ý nghĩa của executeUpdate()

Phương thức `executeUpdate()` trong JDBC được sử dụng cho các câu lệnh SQL như:

* `INSERT`
* `UPDATE`
* `DELETE`

Giá trị trả về của `executeUpdate()` là:

* **Số lượng dòng (rows) bị ảnh hưởng** bởi câu lệnh SQL.

## 2. Áp dụng vào bài toán

Trong bài toán cập nhật trạng thái giường:

```sql
UPDATE Beds SET bed_status = 'Occupied' WHERE bed_id = ?
```

Kết quả trả về:

* Nếu **bed_id tồn tại** → số dòng bị ảnh hưởng = **1**
* Nếu **bed_id không tồn tại** → số dòng bị ảnh hưởng = **0**

## 3. Cách xử lý đúng

Ta sử dụng giá trị trả về để kiểm tra:

* Nếu `rowsAffected == 0`
  → Không có giường nào được cập nhật
  → Kết luận: **Mã giường không tồn tại**

* Nếu `rowsAffected > 0`
  → Cập nhật thành công

## 4. Lợi ích

* Tránh hiểu nhầm cho người dùng (y tá)
* Phát hiện lỗi logic sớm
* Tăng độ tin cậy hệ thống

## 5. Kết luận

`executeUpdate()` không chỉ dùng để thực thi SQL, mà còn là cơ chế kiểm tra tính hợp lệ của dữ liệu thông qua số dòng bị ảnh hưởng.
