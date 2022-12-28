package advent;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day5 {


    public static void run() {
        List<Stack<Character>> towers = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            towers.add(new Stack<>());
        }
        loadTowers(towers);
        makeMovements(towers);
        finalMessage(towers);
    }


    //Part 2:
    private static void individualMovement2(List<Stack<Character>> towers, String str) {
        String[] aux = str.split("~");
        int[] numbers = new int[aux.length];
        for (int i = 0; i < aux.length; i++) {
            numbers[i] = Integer.parseInt(aux[i]);
        }
        int amount = numbers[0];
        int originalTower = numbers[1];
        int targetTower = numbers[2];
        char[] arrAux = new char[amount];
        while (amount > 0) {
            var charAux = towers.get(originalTower - 1).pop();
            arrAux[amount - 1] = charAux;
            amount--;
        }
        for (char charAux : arrAux) {
            towers.get(targetTower - 1).push(charAux);
        }
    }

    //Part 1: ***********************************************************************************************************
    public static void loadTowers(List<Stack<Character>> towers) {
        try {
            File file = new File("advent2022/src/datos1Day5.txt");
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            String[] str = content.split("\r\n");
            for (int i = 7; i > -1; i--) {
                loadTower(towers, str[i]);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void loadTower(List<Stack<Character>> towers, String str) {
        int pos = 1;
        int tower = 0;
        while (tower < 10 && pos < str.length()) {
            if (str.charAt(pos) != ' ') {
                towers.get(tower).add(str.charAt(pos));
            }
            pos += 4;
            tower++;
        }
    }

    public static void makeMovements(List<Stack<Character>> towers) {
        try {
            File file = new File("advent2022/src/datos2Day5.txt");
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            String[] str = content.split("\r\n");
            for (int i = 0; i < str.length; i++) {
                str[i] = str[i].replace("move ", "");
                str[i] = str[i].replace(" from ", "~");
                str[i] = str[i].replace(" to ", "~");
            }
            for (String s : str) {
                individualMovement2(towers, s); //Switch between individualMovements and individualMovements2
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void finalMessage(List<Stack<Character>> towers) {
        for (Stack<Character> tower : towers) {
            System.out.println(tower.peek());
        }
    }

    private static void individualMovement(List<Stack<Character>> towers, String str) {
        String[] aux = str.split("~");
        int[] numbers = new int[aux.length];
        for (int i = 0; i < aux.length; i++) {
            numbers[i] = Integer.parseInt(aux[i]);
        }
        int amount = numbers[0];
        int originalTower = numbers[1];
        int targetTower = numbers[2];
        while (amount > 0) {
            var charAux = towers.get(originalTower - 1).pop();
            towers.get(targetTower - 1).push(charAux);
            amount--;
        }
    }
}
