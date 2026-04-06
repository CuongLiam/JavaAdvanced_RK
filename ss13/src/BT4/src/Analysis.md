# PHÂN TÍCH BÀI TOÁN JOIN & HIỆU NĂNG

## 1. Input / Output

### Input
- Không có đầu vào cụ thể từ người dùng.
- Hệ thống tự động load danh sách bệnh nhân từ cơ sở dữ liệu.

### Output
- `List<BenhNhanDTO>`
    - Thông tin cơ bản của bệnh nhân.
    - Danh sách các dịch vụ đã sử dụng (có thể rỗng nếu bệnh nhân chưa dùng dịch vụ nào).

---

## 2. Bài toán

- Có 2 bảng trong cơ sở dữ liệu:
    - **BenhNhan** (1)
    - **DichVuSuDung** (N)

- Quan hệ giữa 2 bảng: **1 - N** theo khóa ngoại `maBenhNhan`.

---

## 3. Bẫy nghiệp vụ

### Bẫy 1 - Hiệu năng
- Yêu cầu:
    - Xử lý ~500 bệnh nhân.
    - Thời gian phản hồi **< 1 giây**.

- Vấn đề:  
  Nếu query từng bệnh nhân để lấy dịch vụ → xảy ra hiện tượng **N+1 query** → rất chậm, không đáp ứng được thời gian yêu cầu.

### Bẫy 2 - Mất dữ liệu khi JOIN
- Nếu dùng:
  ```sql
  INNER JOIN