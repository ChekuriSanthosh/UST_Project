package bystream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadingFile {
    public static void main(String[] args) {
        try {
            InputStream input=new FileInputStream("data.txt");
            int ch;
            while ((ch=input.read())!=-1){
                System.out.println((char)ch);
            }

        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
