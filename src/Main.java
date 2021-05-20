import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {

        System.out.println("Provide a string or input 'exit' to close.");
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            input = scanner.nextLine().replaceAll("[^a-zA-Z0-9]", " ");
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("bye bye.");
            } else {
                WordLogic.checkString(input);
            }
        } while (!input.equalsIgnoreCase("exit"));

    }
}
