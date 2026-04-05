# Module: Tối ưu INSERT hàng loạt (PreparedStatement)

## 1. Vấn đề

Code hiện tại:

* Mỗi lần lặp tạo `Statement`
* Mỗi lần đều parse + compile SQL

Hậu quả:

* Chạy cực chậm khi insert hàng ngàn bản ghi

## 2. Lãng phí tài nguyên DB

Với 1000 lần INSERT:

* DB phải **parse câu SQL 1000 lần**
* Tạo **execution plan 1000 lần**
* Tốn CPU + thời gian

Trong khi câu SQL giống nhau → rất lãng phí

## 3. Nguyên nhân chính

```java
Statement stmt = conn.createStatement();
stmt.executeUpdate(sql);
```

* SQL là chuỗi động → DB không cache
* Không reuse execution plan

## 4. Giải pháp: PreparedStatement

Ưu điểm:

* SQL được **compile 1 lần duy nhất**
* DB cache execution plan
* Chỉ thay đổi tham số → nhanh hơn nhiều

## 5. Cách tối ưu đúng

### Sai (hiện tại)

* Tạo Statement trong vòng lặp

### Đúng

* Tạo PreparedStatement ngoài vòng lặp
* set tham số bên trong vòng lặp

## 6. Ví dụ chuẩn

```java
PreparedStatement pstmt = conn.prepareStatement(
    "INSERT INTO Results(data) VALUES(?)"
);

for (TestResult tr : list) {
    pstmt.setString(1, tr.getData());
    pstmt.executeUpdate();
}
```

## 7. Tối ưu thêm (Batch)

```java
for (TestResult tr : list) {
    pstmt.setString(1, tr.getData());
    pstmt.addBatch();
}

pstmt.executeBatch();
```

→ Giảm round-trip DB → nhanh hơn nữa

## 8. Kết luận

* Statement: chậm vì parse lại nhiều lần
* PreparedStatement: nhanh hơn do reuse
* Batch: nhanh nhất khi insert số lượng lớn
