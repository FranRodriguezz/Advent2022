package advent;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day3 {

    public void run() {
        try {
            File file = new File("advent2022/src/datosDay3.txt");
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            String[] str = content.split("\r\n");
            System.out.println(str[0]);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
