package advent;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Day3 {

    public static void run() {
        try {
            File file = new File("advent2022/src/datosDay3.txt");
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            String[] str = content.split("\r\n");
            System.out.println(totalPriority(str));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    //Part 1: **************************************************************************************
    private static int totalPriority(String[] str) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        loadCharValues(map);
        int priority = 0;
        for(int i = 0; i < str.length; i++){
            priority += individualPriority(map, str[i]);
        }
        return priority;
    }

    public static int individualPriority(Map<Character, Integer> map, String str){
        final int mid = str.length() / 2;
        String[] parts = {str.substring(0, mid), str.substring(mid)};
        char chr = commonChar(parts[0], parts[1]);
        return charValue(map, chr);
    }


    private static void loadCharValues(Map<Character, Integer> map) {
        char key = 'a';
        for(int value = 1; value < 27; value++){
            map.put(key, value);
            key++;
        }
        char key2 = 'A';
        for(int value2 = 27; value2 < 53; value2++){
            map.put(key2, value2);
            key2++;
        }
    }

    private static int charValue(Map<Character, Integer> map, char chr) {
        return map.get(chr);
    }

    private static char commonChar(String part, String part1) {
        char commonChar = 0;
        for(int i = 0; i < part.length(); i++){
            char aux = part.charAt(i);
            for(int j = 0; j < part1.length(); j++){
                if (aux == part1.charAt(j)) {
                    commonChar = aux;
                    i = part.length();
                    break;
                }
            }
        }
        return commonChar;
    }
}
