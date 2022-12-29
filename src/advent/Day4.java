package advent;

public class Day4 implements InputReader{

    public static void run() {
        String[] str = InputReader.splitInput("advent2022/src/datosDay4.txt");
        System.out.println(pairs(str));
    }

    //Part 2: **********************************************************************************************************
    public static boolean compareRanges2(String[] str1, String[] str2) {
        int[] range1 = new int[2];
        int[] range2 = new int[2];
        for (int i = 0; i < 2; i++) {
            range1[i] = Integer.parseInt(str1[i]);
            range2[i] = Integer.parseInt(str2[i]);
        }
        if (range1[0] >= range2[0] && range2[1] >= range1[0]) {
            return true;
        } else return range1[0] <= range2[0] && range1[1] >= range2[0];
    }

    //Part 1: **********************************************************************************************************
    public static int pairs(String[] str) {
        int amount = 0;
        for (String s : str) {
            if (contains(s)) {
                amount++;
            }
        }
        return amount;
    }

    public static boolean contains(String str) {
        String[] aux = str.split(",");
        return compareStrings(aux[0], aux[1]);
    }

    public static boolean compareStrings(String str1, String str2) {
        String[] range1 = str1.split("-");
        String[] range2 = str2.split("-");
        return compareRanges2(range1, range2); //switch between compare ranges and compare ranges 2
    }

    public static boolean compareRanges(String[] str1, String[] str2) {
        int[] range1 = new int[2];
        int[] range2 = new int[2];
        for (int i = 0; i < 2; i++) {
            range1[i] = Integer.parseInt(str1[i]);
            range2[i] = Integer.parseInt(str2[i]);
        }
        if (range1[0] <= range2[0] && range1[1] >= range2[1]) {
            return true;
        } else {
            return range1[0] >= range2[0] && range1[1] <= range2[1];
        }
    }
}
