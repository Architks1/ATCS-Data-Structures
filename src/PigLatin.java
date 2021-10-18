//name: Archit Srivastava     date: Aug 29

import java.util.*;
import java.io.*;

public class PigLatin {
    public static void main(String[] args) {
       // part_1_using_pig();
        part_2_using_piglatenizeFile();
    }

    public static void part_1_using_pig() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\nWhat word? ");
            String s = sc.next();
            if (s.equals("-1"))
                System.exit(0);
            System.out.println(makeWord(removePunc(s)));
        }
    }

    public static String makeWord(String[] str) {
        return str[0] + pig(str[1]) + str[2];
    }

    public static String[] removePunc(String s) {
        String[] put = {"", "", ""};
        String grammar = ",.;:\"()!?";
        int start = 0, end = s.length();
        for (int j = 0; j < s.length(); j++) {
            if (grammar.indexOf(s.charAt(j)) == -1) {
                put[0] = s.substring(0, j);
                start = j;
                break;
            }
        }
        for (int j = s.length() - 1; j > -1; j--) {
            if (grammar.indexOf(s.charAt(j)) == -1) {
                put[2] = s.substring(j + 1);
                end = j;
                break;
            }
        }
        put[1] = s.substring(start, end + 1);
        return put;
    }

    public static String pig(String s) {
        boolean cap = false;
        boolean haveV = false;
        int fV = Integer.MAX_VALUE;
        String vowels = "aeiou";
        if (Character.isUpperCase(s.charAt(0))) {
            cap = true;
            s = s.toLowerCase();
        }
        for (int j = 0; j < s.length(); j++) {
            if (vowels.indexOf(s.charAt(j)) != -1) {
                haveV = true;
                fV = j;
                break;
            }
        }
        if (fV == 0) {
            if (cap) {
                return s.substring(0, 1).toUpperCase() + s.substring(1) + "way";
            }
            return s + "way";
        }


        if (fV > s.indexOf('y') && s.indexOf('y') > 0) {
            if (cap) {
                return (s.substring(s.indexOf('y'), s.indexOf('y') + 1)).toUpperCase() + s.substring(s.indexOf('y') + 1) + s.substring(0, s.indexOf('y')) + "ay";
            }
            return s.substring(s.indexOf('y')) + s.substring(0, s.indexOf('y')) + "ay";
        }
        if (!haveV) {
            return "***INVALID***";
        }
        if (fV != -1 && s.charAt(fV) == 'u' && s.charAt(fV - 1) == 'q') {
            if (cap) {
                return s.substring(fV + 1, fV + 2).toUpperCase() + s.substring(fV + 2) + s.substring(0, fV + 1) + "ay";
            }
            return s.substring(fV + 1) + s.substring(0, fV + 1) + "ay";
        }
        if (cap) {
            return s.substring(fV, fV + 1).toUpperCase() + s.substring(fV + 1) + s.substring(0, fV) + "ay";
        }
        return s.substring(fV) + s.substring(0, fV) + "ay";
    }

    public static void part_2_using_piglatenizeFile() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Filename (Including .txt)? Example: PigLatin.txt:");
        String filename = sc.next();
        Scanner infile = null;
        try {
            infile = new Scanner(new File(filename));  //PigLatin.txt
        } catch (IOException e) {
            System.out.println("oops cant find the file to piglatinize");
        }
        System.out.print("Output Filename (Including .txt)? Example: PigLatinOut.txt:");
        String filenameOut = sc.next();
        try {
            piglatenizeFile(infile, filenameOut);
            System.out.println("Done!");
        } catch (IOException e) {
            System.out.println("oops");
        }
        System.out.println("Piglatin done!");
        sc.close();
    }

    public static void piglatenizeFile(Scanner infile, String filename) throws FileNotFoundException {
        Scanner input = infile;
        PrintStream outfile = new PrintStream(new FileOutputStream(filename));
        while (infile.hasNext()) {
            String s = infile.nextLine();
            if (s.equals("") || s.equals("\r") || s.equals("\r\n")) {
                outfile.println();
            } else {
                String[] str = s.split(" ");
                String[] piggy = new String[str.length];
                for (int j = 0; j < str.length; j++) {
                    piggy[j] = makeWord(removePunc(str[j]));
                }
                String fileLine = String.join(" ", piggy);
                outfile.print(fileLine);
                outfile.println();
            }
        }
    }
}
