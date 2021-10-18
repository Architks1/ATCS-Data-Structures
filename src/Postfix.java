//name:     date:
   
import java.util.*;
public class Postfix
{
   public static void main(String[] args)
   {
      System.out.println("Postfix  -->  Evaluate");
      ArrayList<String> postExp = new ArrayList<String>();
      /*  enter tests here  */
      postExp.add("345+*2-5/");
      
      for( String pf : postExp )
      {
         System.out.println(pf + "\t\t" + eval(pf));
      }
   }
   public static int eval(String postfix)
   {
      Stack<String> st = new Stack<String>();
      for(int i = 0; i < postfix.length(); i++){
          if(isOperator(postfix.charAt(i))){
          st.push("" + eval(Integer.parseInt(st.pop()), Integer.parseInt(st.pop()), postfix.charAt(i)));
          }
          else{
          st.push(postfix.charAt(i) + "");
          }
      }
      return Integer.parseInt(st.pop());
   }
   public static int eval(int b, int a, char ch)
   {
      if(ch == '+')
         return a + b;
      if(ch == '-')
         return a - b;
      if(ch == '*')
         return a * b;
      if(ch == '/')
         return a / b;
     return 0;
   }
   public static boolean isOperator(char ch)
   {
      if(ch == '+' || ch == '-' | ch == '*' || ch == '/')
         return true;
      else{
         return false;
      }
   }
}

/*
 Postfix  -->  Evaluate
 345*+		23
 34*5+		17
 45+53*-		-6
 34+56+*		77
 345+*2-5/		5
 812*+93/-		7  
 */