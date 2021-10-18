import java.io.*;
import static java.lang.System.*;

public class OutWrite {

    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("testing.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Hi my name is ");
            pw.close();
            System.out.println("Done here");
        } catch (IOException e) {
            System.out.println("You got rekt");
        }

    }

}
