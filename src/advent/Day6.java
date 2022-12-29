package advent;

public class Day6 implements InputReader {

    public static void run() {
        String content = InputReader.regularInput("advent2022/src/datosDay6.txt");
        assert content != null;
        System.out.println(marker(content));
    }

    public static int marker(String content) {
        int size = 14; //Change between 4 and 14
        char[] aux = new char[size];
        for (int i = 0; i < content.length(); i++) {
            for (int j = 0; j < size; j++) {
                aux[j] = content.charAt(i + j);
            }
            if (!duplicate(aux)) {
                return i + size;
            }
        }
        return -1;
    }

    public static boolean duplicate(char[] aux) {
        for (int i = 0; i < aux.length; i++) {
            for (int j = i + 1; j < aux.length; j++) {
                if (aux[i] == (aux[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
