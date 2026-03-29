import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ep4 {

    // C
    static void saveToFile() throws IOException{
//        File file = new File("src/data.txt");
        File file = new File("src/data123.txt");

        if (!file.exists()){
            throw new IOException("K tồn tại");
        }

        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }

    }

    // B
    static void processUserData() throws IOException{
        saveToFile();
    }

    // A
    public static void main(String[] args) {

        try{
           processUserData();
        } catch (IOException e){

            System.out.println(e.getMessage());
        }

    }
}
