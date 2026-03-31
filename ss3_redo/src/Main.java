import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Optional
        // rỗng
        Optional<String> optionalEmpty = Optional.empty();

        // non-null
        String str = "Java dev";
        Optional<String> optionalString = Optional.of(str);


        // Tạo một đối tượng Optional chứa giá trị cụ thể hoặc giá trị rỗng (empty) nếu tham số
        //là null


//        Optional<String> optionalS = Optional.ofNullable(obj);


        // DateTime:
        // LocalDate, LocalTime, LocalDateTime, ZonedDateTime, OffsetDateTime

        // exp:

        // Lấy thời gian hiện tại
        LocalDate today = LocalDate.now();
// Tính khoảng cách giữa 2 ngày (Period)

        LocalDate futureDate = LocalDate.of(2030, 1, 1);
        Period period = Period.between(today, futureDate);
// Định dạng chuỗi ngày tháng

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = today.format(formatter);
            // TextBlocks

        String jsonResponse = """
            {
                "status": "success",
                "message": "welcome to java 17"
            }
            """;


    }
}