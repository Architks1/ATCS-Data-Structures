import java.util.*;
import java.io.*;
public class Twit_Test {
    static List<String> terms = new ArrayList<>();

    public static void main(String[] args) {
        terms.add("hi");
        terms.add("the");
        terms.add("unknown");
        System.out.println(terms);
        removeCommonEnglishWords();
        System.out.print(terms);
        //System.out.println(getFrequencyMax());
    }
    @SuppressWarnings("unchecked")
    public static void removeCommonEnglishWords()
    {
        Scanner infile = null;
        List<String> com = new ArrayList<String>();
        try
        {
            infile = new Scanner(new File("frog.txt"));
        }
        catch(IOException e)
        {
            System.out.println("oops");
        }
        while(infile.hasNextLine()){
            String s = infile.nextLine();
            com.add(s);
        }
        System.out.println(com);
        terms.removeAll(com);
    }

    public static String mostPopularWord1() {
        String prev = terms.get(0);
        String pop = "" + prev;
        int count = 0;
        int max = 0;
        List<String> a = terms;
        for (int i = 1; i < terms.size(); i++) {
            if (terms.get(i).equals(prev)) {
                count++;
            } else {
                if (count > max) {
                    pop = terms.get(i - 1);
                    max = count;
                }
                prev = terms.get(i);
                count = 1;
            }
        }

        return count > max ? terms.get(terms.size() - 1) : pop;
    }

    public static int getFrequencyMax() {
        String s = mostPopularWord1();
        int c = 0;
        for (int i = 0; i < terms.size(); i++) {
            if (s.equals(terms.get(i)))
                c++;
        }
        return c;
    }
}
