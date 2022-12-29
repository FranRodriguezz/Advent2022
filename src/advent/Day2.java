package advent;

public class Day2 implements InputReader{

    public static void run() {
        String content = InputReader.regularInput("advent2022/src/datosDay2.txt");
        assert content != null;
        String content2 = content.replace(" ", "");
        String[] str = content2.split("\r\n");
        runPart1(str);
        runPart2(str);
    }

    //PART 2:
    public static void runPart2(String[] str){
        int points = 0;
        for (String s : str) {
            points += totalPoints2(s);
        }
        System.out.println(points);
    }

    public static int totalPoints2(String str){
        int points = 0;
        if(str.contains("A")){
            points = pointsMatchRock2(str);
        }
        else if (str.contains("B")) {
            points = pointsMatchPaper2(str);
        }
        else if(str.contains("C")){
            points = pointsMatchScissor2(str);
        }
        return points;
    }

    public static int pointsMatchRock2(String str){
        int points = 0;
        if(str.contains("Y")){
            points = 4; //1 rock, 3 draw
        }
        else if (str.contains("Z")) {
            points = 8; //2 paper, 6 win
        }
        else if (str.contains("X")) {
            points = 3; //3 scissor, 0 lose
        }
        return points;
    }

    public static int pointsMatchPaper2(String str){
        int points = 0;
        if(str.contains("Y")){
            points = 5; //2 paper, 3 draw
        }
        else if (str.contains("Z")) {
            points = 9; //3 scissor, 6 win
        }
        else if (str.contains("X")) {
            points = 1; //1 rock, 0 lose
        }
        return points;
    }

    public static int pointsMatchScissor2(String str){
        int points = 0;
        if(str.contains("Y")){
            points = 6; //3 scissor, 3 draw
        }
        else if (str.contains("Z")) {
            points = 7; //1 rock, 6 win
        }
        else if (str.contains("X")) {
            points = 2; //2 paper, 0 lose
        }
        return points;
    }
    //*****************************************************************************************************
    //PART 1:
    public static void runPart1(String[] str){
        int points = 0;
        for (String s : str) {
            points += totalPoints(s);
        }
        System.out.println(points);
    }
    public static int totalPoints(String str){
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

    public static int pointsElement(String str){
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

    public static int pointsMatchRock(String str){
        int points = 0;
        if(str.contains("Y")){
            points = 6;
        }
        else if (str.contains("X")) {
            points = 3;
        }
        return points;
    }

    public static int pointsMatchPaper(String str){
        int points = 0;
        if(str.contains("Y")){
            points = 3;
        }
        else if (str.contains("Z")) {
            points = 6;
        }
        return points;
    }

    public static int pointsMatchScissors(String str){
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
