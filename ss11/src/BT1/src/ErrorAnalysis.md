# Phần 1 – Phân tích lỗi kết nối MySQL (Communications link failure)

## 1. Bối cảnh

Hệ thống bệnh viện cần kết nối đến cơ sở dữ liệu **Hospital_DB** để truy xuất hồ sơ bệnh nhân. Đây là hệ thống yêu cầu hoạt động liên tục (24/7), độ ổn định cao.

---

## 2. Vấn đề hiện tại

Ứng dụng thường xuyên bị treo sau một thời gian hoạt động. Log ghi nhận lỗi:

> Communications link failure

Đoạn code hiện tại:
```java
public Connection getHospitalConn() {
    try {
        return DriverManager.getConnection(
            "jdbc:mysql://192.168.1.10:3306/Hospital_DB",
            "admin",
            "med123"
        );
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}
```

---

## 3. Phân tích nguyên nhân

### 3.1 Không đóng kết nối (Connection Leak)

* Mỗi lần gọi hàm → tạo một connection mới
* Không có `close()` → connection không được giải phóng
* Dẫn đến:

  * Tăng số lượng connection trong MySQL
  * Vượt giới hạn `max_connections`

---

### 3.2 Không quản lý tập trung

* Connection được tạo rải rác
* Không có cơ chế kiểm soát vòng đời
* Khó debug và bảo trì

---

### 3.3 Timeout kết nối

* MySQL có timeout (wait_timeout)
* Connection cũ bị đóng nhưng app vẫn giữ reference
  → Gây lỗi **Communications link failure**

---

### 3.4 Ảnh hưởng hệ thống

* Hết connection → không truy vấn được DB
* Memory leak → tăng RAM → crash server
* Hệ thống treo sau vài giờ
* Không đảm bảo hoạt động 24/7

---

## 4. Kết luận

Nguyên nhân chính:

* Không đóng connection
* Không quản lý connection đúng cách

Hệ quả:

* Rò rỉ tài nguyên
* Mất kết nối database
* Hệ thống không ổn định

---

## 5. Hướng giải quyết

* Đảm bảo luôn đóng connection (`finally`)
* Tạo lớp quản lý DB tập trung (DBContext)
* Sử dụng Connection Pool (HikariCP) để tối ưu hiệu năng

---

## 6. Tổng kết

Việc tạo connection liên tục mà không đóng là một lỗi nghiêm trọng trong hệ thống backend, đặc biệt với các hệ thống yêu cầu uptime cao như bệnh viện. Cần áp dụng quản lý tài nguyên đúng cách để đảm bảo tính ổn định và khả năng mở rộng.
