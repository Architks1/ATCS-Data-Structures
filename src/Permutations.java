import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Permutations
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("\nHow many digits? ");
      int n = sc.nextInt();
      leftRight("", n);
      oddDigits("", n);
      superprime(n);
   }
   public static void leftRight(String s, int n)
   {
        if(s.length() == n)
            System.out.println(s);
        else{
            leftRight(s+"L", n);
            leftRight(s+"R",n);
        }

   }
   public static void oddDigits(String s, int n)
   {
       if(s.length() == n){
           System.out.println(s);
       }
       else{
           oddDigits(s + 1, n);
           oddDigits(s + 3, n);
           oddDigits(s + 5, n);
           oddDigits(s + 7, n);
           oddDigits(s + 9, n);
       }

   }
   //Hint on how to do this: build up from a nonexistant number (similar to the other two problems)
   public static void superprime(int n)
   {
      //try leading 2, 3, 5, 7, i.e. all the single-digit primes. 
      //A massive hint for this problem: Why these numbers?
      recur(2, n);
      recur(3, n); 
      recur(5, n);
      recur(7, n);

   }
   //Look at the examples. What numbers should you recur on? Why???
   private static void recur(int k, int n)
   {
        if(isPrime(k)){
            if(k > Math.pow(10, n - 1) && k < Math.pow(10,n)){
                System.out.println(k);
            }else{
                recur((k*10)+1, n);
                recur((k*10)+3, n);
                recur((k*10)+5, n);
                recur((k*10)+7, n);
                recur((k*10)+9, n);
            }
        }
   }
   //You need to write this one.
   private static boolean isPrime(int n)
   {
       for(int i = 2; i < n/2; i++){
           if(n%i == 0){
               return false;
           }
       }
      return true;
   }
}