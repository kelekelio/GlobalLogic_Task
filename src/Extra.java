import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Extra {
    public static void saveToFile(String input) {



        String path = "P:\\letterFreq.txt";

        try {
            File myObj = new File(path);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                Files.write(Paths.get(path), (input + "\n").getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(input);

    }

    public static double roundFreq (int a, int b) {
        if (b == 0) {
            return 0.0;
        }
        double freq = a * 1.0 / b;
        return Math.round(freq * 100.0) / 100.0;
    }


}
