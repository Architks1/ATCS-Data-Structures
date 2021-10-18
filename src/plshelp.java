import java.io.*;
import java.util.*;

public class plshelp {
    public static void main(String[] args) throws FileNotFoundException {
        /*Scanner infile = null;
        try{
            infile = new Scanner(new File("commonWords.txt"));
            System.out.println("hi");
        }catch(IOException e){
            System.out.println("oops");
        }
        String[] s = new String[5];
        int c = 0;
        while(infile.hasNext()){
            s[c] = infile.nextLine();
            c++;
            System.out.println(c);
        }
        for(int i = 0; i < 5; i++){
            System.out.print(s[i]);
        }*/
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Filename (Including .txt)? Example: PigLatin.txt:");
        String filename = sc.next();
        Scanner infile = null;
        try {
            infile = new Scanner(new File(filename));  //PigLatin.txt
        } catch (IOException e) {
            System.out.println("oops cant find the file to piglatinize");
        }
        String[] s = new String[5];
        int c = 0;
        while (infile.hasNext() && c < 5) {
            s[c] = infile.nextLine();
            c++;
            System.out.println(c);
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(s[i] + " ");
        }
    }
}
