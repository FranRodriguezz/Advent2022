package advent;

import java.util.HashMap;
import java.util.Map;

public class Day3 implements InputReader{

    public static void run() {
        String[] str = InputReader.splitInput("advent2022/src/datosDay3.txt");
        Map<Character, Integer> map = new HashMap<>();
        loadCharValues(map);
        System.out.println(totalPriority(str, map)); //part1
        System.out.println(totalPriority2(str, map)); //part2
    }

    //Part 2:
    private static int totalPriority2(String[] str, Map<Character, Integer> map){
        int priority = 0;
        int x = 0, y = 1, z = 2;
        String str1, str2, str3;
        char chr;
        while(z < str.length){
            str1 = str[x];
            str2 = str[y];
            str3 = str[z];
            chr = commonChar2(str1, str2, str3);
            priority += charValue(map, chr);
            x+=3;
            y+=3;
            z+=3;
        }
        return priority;
    }

    private static char commonChar2(String str1, String str2, String str3) {
        char commonChar = 0;
        for(int i = 0; i < str1.length(); i++){
            char aux = str1.charAt(i);
            for(int j = 0; j < str2.length(); j++){
                if (aux == str2.charAt(j)) {
                    for(int k = 0; k < str3.length(); k++){
                        if (aux == str3.charAt(k) && str3.charAt(k) > commonChar) {
                            commonChar = aux;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return commonChar;
    }

    //Part 1: ***********************************************************************************************************
    private static int totalPriority(String[] str, Map<Character, Integer> map) {
        int priority = 0;
        for (String s : str) {
            priority += individualPriority(map, s);
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
