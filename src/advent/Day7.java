package advent;

import java.util.HashMap;
import java.util.Map;

public class Day7 implements InputReader{

    public static void run() {
        String[] content = InputReader.splitInput("advent2022/src/datosDay7.txt");
        Map<String, Integer> map = new HashMap<>();
        System.out.println(directoriesUnder10k(content, map));
    }

    public static int directoriesUnder10k(String[] content, Map<String, Integer> map){
        int directories = 0;
        return directories;
    }
}
