import java.io.*;
import java.util.*;

public class PlsFormat {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner infile = new Scanner(new File("textToEdit.txt"));
        ArrayList<String> bob = new ArrayList<>();
        while (infile.hasNext()) {
            bob.add(infile.nextLine());
        }
        //System.out.println(bob);
        String s = "";
        for (int i = 0; i < bob.size(); i++) {
            if(bob.get(i).equals("")) {
                System.out.println(s);
                System.out.println();
                s = "";
            }else{
                if(s.equals(""))
                    s += bob.get(i);
                else {
                    s += " " + bob.get(i);
                }
            }



        }
    }
}

