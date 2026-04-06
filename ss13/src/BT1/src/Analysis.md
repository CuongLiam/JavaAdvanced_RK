# Phân tích lỗi Transaction trong JDBC

## Vấn đề
Hệ thống gặp lỗi:
- Thuốc trong kho bị trừ
- Nhưng không lưu vào lịch sử (Prescription)
  → Dữ liệu bị **mất tính toàn vẹn**

---

## Nguyên nhân chính

### 1. Auto-commit mặc định trong JDBC
- Mỗi câu lệnh `executeUpdate()` sẽ **tự động commit**
- Không cần gọi `commit()`

---

### 2. Vấn đề trong code
Có 2 thao tác:
1. UPDATE kho thuốc
2. INSERT lịch sử

Khi chạy:
- Câu 1: chạy OK → **commit luôn**
- Câu 2: bị lỗi → **rollback không xảy ra**

---

## Hệ quả
- Kho bị trừ thuốc
- Không có log
  → Sai lệch dữ liệu

---

## Kết luận
- 2 câu SQL KHÔNG nằm trong cùng transaction
- Do:
    - Không tắt auto-commit
    - Không dùng rollback

---

## Nguyên tắc đúng (ACID)
- Atomicity: phải ALL hoặc NOTHING
- Cần:
    - `setAutoCommit(false)`
    - `commit()`
    - `rollback()`