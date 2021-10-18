  //name:   date: 
import java.util.*;
public class Infix
{
   public static void main(String[] args)
   {
      System.out.println("Infix  -->  Postfix  -->  Evaluate");
      Scanner in = new Scanner(System.in);
      /*enter code here  */
      ArrayList <String> infixExp= new ArrayList<String>();
      System.out.println("Enter your equation");
      infixExp.add(in.nextLine());


      for( String s : infixExp )
      {
         String pf = infixToPostfix(s);
         System.out.println(s + "       " + pf + "       " + Postfix.eval(pf));
      }
   }
   public static String infixToPostfix(String infix)
   {
      Stack<String> s = new Stack<>();
      String eq = "";
      String signs = "+-/*()";
      infix = "(" + infix + ")";
      s.push(infix.charAt(0) + "");
      int c = 1;
      while(!s.empty()){
         String n = infix.charAt(c) + "";
         char nn = infix.charAt(c);
         if(signs.indexOf(n) == -1){
            eq = eq + n;
         }
         else{
            String n1 = s.peek().charAt(0) + "";
            char n1n1 = s.peek().charAt(0);
            if(n.equals(")")){
               while(!s.peek().equals("(")){
                  eq = eq + s.pop();
               }
                  s.pop();
            }
            else if (n.equals("(") || n1.equals("(")){
               s.push(n);
            }
            else if (!isLower(n1n1,nn))
            {
               while((!isLower(s.peek().charAt(0), nn)) && (!s.peek().equals("(")))
                  eq = eq + ("" + s.pop());
               s.push(nn + "");
            }
         }
      c++;
      }
      return eq;
   }
	//returns true if c1 has strictly lower precedence than c2
   public static boolean isLower(char c1, char c2)
   {
      String h = "*/";
      String l = "+-";
      if(h.indexOf(c1)!= -1)
         return false;
      else if((l.indexOf(c1)!=-1)&&(h.indexOf(c2) != -1))
         return true;
      else if((l.indexOf(c1) != -1) && (l.indexOf(c2) != -1))
         return false;
      else
         return true;
//   return false;
   }
}
	
	/*
 Infix  -->  Postfix  -->  Evaluate
 3+4*5       345*+       23
 3*4+5       34*5+       17
 (4+5)-5*3       45+53*-       -6
 (3+4)*(5+6)       34+56+*       77
 (3*(4+5)-2)/5       345+*2-5/       5
 8+1*2-9/3       812*+93/-       7
	*/
