import javafx.scene.shape.Path;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {




        PrintWriter out = new PrintWriter("myfile.txt", String.valueOf(StandardCharsets.UTF_8));
        String dir = System.getProperty("user.dir");
        out.println("nihao");
        System.out.println(dir);



    }
}
