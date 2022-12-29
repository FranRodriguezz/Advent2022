package advent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public interface InputReader {


    static String regularInput(String fileName){
        try{
            File file = new File(fileName);
            return new String(Files.readAllBytes(Paths.get(file.toURI())));
        }
        catch(IOException | NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    static String[] splitInput(String fileName){
        String content;
        String[] splitContent = null;
        try{
            File file = new File(fileName);
            content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            splitContent = content.split("\r\n");
        }
        catch(IOException | NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
        return splitContent;
    }
}
