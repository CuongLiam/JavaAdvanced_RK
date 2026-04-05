# Module: Tra cứu chi phí phẫu thuật (OUT Parameter)

## 1. Vấn đề

Stored Procedure `GET_SURGERY_FEE`:

* Input: `surgery_id` (IN)
* Output: `total_cost` (OUT)

Lỗi gặp phải:

> `The column index is out of range`

## 2. Nguyên nhân

Trong JDBC, tham số OUT **bắt buộc phải đăng ký trước khi gọi execute()** bằng:

```java
cstmt.registerOutParameter(index, sqlType);
```

Nếu không:

* JDBC không biết kiểu dữ liệu OUT
* Không cấp phát vùng nhớ nhận dữ liệu
  → Gây lỗi khi gọi `getXxx()`

## 3. Kiểu dữ liệu DECIMAL

Trong SQL: `DECIMAL` / `NUMERIC`

Trong Java (JDBC Types):

```java
java.sql.Types.DECIMAL
```

## 4. Quy trình đúng

1. prepareCall()
2. set tham số IN
3. registerOutParameter()
4. execute()
5. get giá trị OUT

## 5. Ví dụ chuẩn

```java
CallableStatement cstmt = conn.prepareCall("{call GET_SURGERY_FEE(?, ?)}");
cstmt.setInt(1, 505);
cstmt.registerOutParameter(2, Types.DECIMAL);

cstmt.execute();

double cost = cstmt.getDouble(2);
```

## 6. Kết luận

* JDBC dùng index bắt đầu từ **1**
* OUT parameter phải đăng ký trước
* DECIMAL → `Types.DECIMAL`
