package advent;
public class Day2 {

    public void run(){
        try{
            File file = new File("src/datosDay2.txt");
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            String str = content.replace("\r\n", "~");
            System.out.println(str);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
