package advent;

public class Day1 implements InputReader{

    public static void run(){
        String content = InputReader.regularInput("advent2022/src/datosDay1.txt");
        assert content != null;
        String str = content.replace("\r\n", "~");
        String[] strSplit = str.split("~~");
        calcCalories(strSplit);
    }

    public static void calcCalories(String[] str){
        int caloriesTop1 = 0;
        int caloriesTop2 = 0;
        int caloriesTop3 = 0;
        for (String s : str) {
            int calories = calories(s);
            if (calories > caloriesTop1) {
                caloriesTop2 = caloriesTop1;
                caloriesTop1 = calories;
            } else if (calories > caloriesTop2) {
                caloriesTop3 = caloriesTop2;
                caloriesTop2 = calories;
            } else if (calories > caloriesTop3)
                caloriesTop3 = calories;
        }
        showInfo(caloriesTop1, caloriesTop2, caloriesTop3);
    }

    public static int calories(String str){
        int calories = 0;
        String[] arr = str.split("~");
        for (String s : arr) {
            int aux = Integer.parseInt(s);
            calories += aux;
        }
        return calories;
    }

    public static void showInfo(int cal1, int cal2, int cal3){
        System.out.println(cal1);
        System.out.println(cal1 + cal2 + cal3);
    }
}
