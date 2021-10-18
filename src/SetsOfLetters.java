// Name:    Date:
import java.util.*;
import java.io.*;
public class SetsOfLetters
{
   public static void main(String[] args) throws FileNotFoundException
   {
      //Scanner sc = new Scanner(System.in);
      //System.out.print("Enter the file name: ");
      //String fileName = sc.next();
      String fileName = "declarationLast.txt";
      fillTheSets(fileName);
   }
   public static void fillTheSets(String fn) throws FileNotFoundException
   {
      File f = new File(fn);
      Scanner in = new Scanner(f);
      String l = in.nextLine();
      Set<Character> n = new TreeSet<Character>();
      Set<Character> c = new TreeSet<Character>();
      Set<Character> no = new TreeSet<Character>();
      int k = 1;
      while(l != null){
         Set<Character> n1 = new TreeSet<Character>();
         Set<Character> c1 = new TreeSet<Character>();
         Set<Character> no1 = new TreeSet<Character>();
         for(int i = 0; i < l.length(); i++)
         {
            if(l.charAt(i) >= 97 && l.charAt(i) <= 122)
            {
               n1.add(l.charAt(i));
            }
            else if(l.charAt(i) >= 65 && l.charAt(i) <= 90)
            {
               c1.add(l.charAt(i));
            }
            else
            {
               no1.add(l.charAt(i));
            }
         }
         if(k == 1)
         {
            n.addAll(n1);
            c.addAll(c1);
            no.addAll(no1);
         }
      }

   }
}