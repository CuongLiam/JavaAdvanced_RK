
import java.io.IOException;

public class BT4 {
    public static void saveToFile() throws IOException {
        throw new IOException("Loi khi luu file!");
    }

    public static void processUserData() throws IOException {
        saveToFile();
    }

    public static void main(String[] args) {
        try {
            processUserData();
        } catch (IOException e) {
            System.out.println("Co loi xay ra: " + e.getMessage());
        }
    }
}