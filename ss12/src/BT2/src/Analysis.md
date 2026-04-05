## Vì sao setDouble(), setInt() không bị lỗi định dạng Locale?

PreparedStatement xử lý tham số theo **kiểu dữ liệu (type-safe)** thay vì nối chuỗi:

- `setDouble()`, `setInt()` gửi dữ liệu xuống DB dưới dạng **binary/typed value**
- Không phụ thuộc vào định dạng vùng miền (`,` hay `.`)
- DB tự hiểu đúng kiểu số → không lỗi cú pháp

### So sánh

Statement (lỗi Locale)
```java
double temp = 37.5;
String sql = "UPDATE Vitals SET temperature = " + temp;
```
→ Có thể thành `37,5` → SQL sai

PreparedStatement (an toàn)
```java
String sql = "UPDATE Vitals SET temperature = ? WHERE p_id = ?";
```
→ Không bị ảnh hưởng bởi Locale

### Kết luận

PreparedStatement giúp:
- Tránh lỗi định dạng số
- Không phụ thuộc Locale
- An toàn và ổn định hơn