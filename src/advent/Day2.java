package advent;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Day2 {

    public void run() {
        try {
            File file = new File("src/datosDay2.txt");
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            String content2 = content.replace(" ", "");
            String[] str = content2.split("\r\n");
            int points = 0;
            for(int i = 0; i < str.length; i++){
                points += totalPoints(str[i]);
            }
            System.out.println(points);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public int totalPoints(String str){
        int points = 0;
        if(str.contains("A")){
            points = pointsElement(str) + pointsMatchRock(str);
        }
        else if (str.contains("B")) {
            points = pointsElement(str) + pointsMatchPaper(str);
        }
        else if(str.contains("C")){
            points = pointsElement(str) + pointsMatchScissors(str);
        }
        return points;
    }

    public int pointsElement(String str){
        int points = 0;
        if(str.contains("Y")){
            points = 2; //paper
        }
        else if (str.contains("X")) {
            points = 1; //rock
        }
        else if (str.contains("Z")){
            points = 3; //scissors
        }
        return points;
    }

    public int pointsMatchRock(String str){
        int points = 0;
        if(str.contains("Y")){
            points = 6;
        }
        else if (str.contains("X")) {
            points = 3;
        }
        return points;
    }

    public int pointsMatchPaper(String str){
        int points = 0;
        if(str.contains("Y")){
            points = 3;
        }
        else if (str.contains("Z")) {
            points = 6;
        }
        return points;
    }

    public int pointsMatchScissors(String str){
        int points = 0;
        if(str.contains("Z")){
            points = 3;
        }
        else if (str.contains("X")) {
            points = 6;
        }
        return points;
    }
}
