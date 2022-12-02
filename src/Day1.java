import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day1 {

    public void run(){
        try{
            File file = new File("src/datos.txt");
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            String str = content.replace("\r\n", "~");
            String[] strSplit = str.split("~~");
            calcCalories(strSplit);
        }
        catch(IOException | NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void calcCalories(String[] str){
        int caloriesTop1 = 0;
        int caloriesTop2 = 0;
        int caloriesTop3 = 0;
        for(int i = 0; i < str.length; i++){
            int calories = calories(str[i]);
            if(calories > caloriesTop1){
                caloriesTop2 = caloriesTop1;
                caloriesTop1 = calories;
            }
            else if (calories > caloriesTop2){
                caloriesTop3 = caloriesTop2;
                caloriesTop2 = calories;
            }
            else if(calories > caloriesTop3)
                caloriesTop3 = calories;
        }
        this.showInfo(caloriesTop1, caloriesTop2, caloriesTop3);
    }

    public static int calories(String str){
        int calories = 0;
        String[] arr = str.split("~");
        for(int i = 0; i < arr.length; i++){
            int aux = Integer.parseInt(arr[i]);
            calories += aux;
        }
        return calories;
    }

    public void showInfo(int cal1, int cal2, int cal3){
        System.out.println(cal1);
        System.out.println(cal1 + cal2 + cal3);
    }
}
