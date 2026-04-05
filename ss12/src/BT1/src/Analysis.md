## Tại sao PreparedStatement chống được SQL Injection?

PreparedStatement hoạt động theo cơ chế **pre-compiled (biên dịch trước)**:

- Câu lệnh SQL được gửi đến DB và **biên dịch trước** với các placeholder `?`
- Dữ liệu đầu vào (parameters) được truyền vào **riêng biệt**, không nối chuỗi
- DB sẽ **không coi input là một phần của câu lệnh SQL**, mà chỉ là giá trị

### So sánh:

Statement (nguy hiểm)
```java
String sql = "SELECT * FROM Doctors WHERE code='" + code + "' AND pass='" + pass + "'";
```
→ Hacker có thể inject: `' OR '1'='1`

PreparedStatement (an toàn)
```java
String sql = "SELECT * FROM Doctors WHERE code=? AND pass=?";
```
→ Input không thể phá vỡ cấu trúc SQL

### Kết luận

PreparedStatement giúp:
- Ngăn SQL Injection
- Tách biệt query và dữ liệu
- Tăng hiệu năng (query cache)