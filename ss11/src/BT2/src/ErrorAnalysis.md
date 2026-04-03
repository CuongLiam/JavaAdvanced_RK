# Phần 1 – Phân tích lỗi xử lý ResultSet

## 1. Bối cảnh

Hệ thống bệnh viện cần in danh sách toàn bộ các loại thuốc trong kho để phục vụ kiểm kê.

---

## 2. Vấn đề hiện tại

Đoạn code chỉ in được **1 dòng đầu tiên** hoặc lỗi khi bảng rỗng:

```java
ResultSet rs = stmt.executeQuery("SELECT medicine_name, stock FROM Pharmacy");

if (rs.next()) {
    System.out.println("Thuốc: " + rs.getString("medicine_name"));
}
```

---

## 3. Phân tích nguyên nhân

### 3.1 Sai logic xử lý danh sách

* `if (rs.next())` chỉ kiểm tra **1 lần**
* → Chỉ lấy **record đầu tiên**
* Không duyệt toàn bộ dữ liệu

---

### 3.2 Cách hoạt động của ResultSet

* `ResultSet` là con trỏ (cursor)
* Ban đầu: đứng **trước dòng đầu tiên**
* Mỗi lần gọi:

```java
rs.next()
```

→ Con trỏ di chuyển xuống **1 dòng tiếp theo**

---

### 3.3 Hệ quả

* `if` → chỉ chạy 1 lần → chỉ in 1 record
* Nếu bảng rỗng:

  * `rs.next()` = false → không in gì
  * Có thể gây hiểu nhầm là lỗi

---

## 4. Kết luận

Nguyên nhân chính:

* Dùng `if` thay vì vòng lặp

Bản chất:

* Không hiểu cơ chế con trỏ của `ResultSet`

---

## 5. Hướng giải quyết

* Dùng vòng lặp `while` để duyệt toàn bộ dữ liệu:

```java
while (rs.next()) {
    // xử lý từng dòng
}
```

---

## 6. Tổng kết

`ResultSet` cần được duyệt bằng vòng lặp vì mỗi lần `next()` chỉ di chuyển 1 dòng.
Dùng `if` sẽ khiến chương trình chỉ xử lý dòng đầu tiên, không đáp ứng yêu cầu "in danh sách".
