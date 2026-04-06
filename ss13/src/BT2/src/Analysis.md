# PHÂN TÍCH LỖI TRANSACTION - THIẾU ROLLBACK

## 1. Mô tả vấn đề

Hệ thống đã sử dụng:
- `setAutoCommit(false)`
- `commit()`

Tuy nhiên, khi lỗi xảy ra ở **bước 2**:
- Transaction bị dừng giữa chừng
- **Không rollback**
- **Connection bị treo**

---

## 2. Sai lầm trong code

```java
catch(SQLException e){
    System.out.println("Lỗi: " + e.getMessage());
}