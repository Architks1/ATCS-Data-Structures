//name: Archit S
//date: Sep 12 2018

import java.util.*;
import java.io.*;

public class AreaFill
{
   public static char[][] grid = null;
   public static String filename = null;
      
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner sc = new Scanner(System.in);
      while(true) 
      {
         System.out.print("Filename: ");
         filename = sc.next();
         if(filename.equals("-1"))
         {
            sc.close();
            System.out.println("Good-bye");
            return;   
         }
         grid = read(filename);
         String theGrid = display(grid);
         System.out.println( theGrid );
         System.out.print("\nEnter ROW COL to fill from: ");
         int row = sc.nextInt();
         int col = sc.nextInt(); 
         fill(grid, row, col, grid[row][col]);
         System.out.println( display(grid) );
      //  Extension
      // int count = fillAndCount(grid, row, col, grid[row][col]);
      // System.out.println( display(grid) );
      // System.out.println("count = " + count);
         System.out.println();
      }
   }
   public static char[][] read(String filename) throws FileNotFoundException
   {
      Scanner infile = new Scanner(new File(filename));
      int i = infile.nextInt(), j = infile.nextInt();
      char[][] arr = new char[i][j];
      infile.nextLine();
      for(int c = 0; c < arr.length; c++){
         arr[c] = infile.nextLine().toCharArray();
      }
      return arr;
   }
   
   public static String display(char[][] g)
   {
      String s = "";
      for(int i = 0; i < g.length; i++){
         for(int j = 0; j < g[i].length; j++){
            s = s + g[i][j];
         }
         s = s + "\n";
      }
      return s;
   }

   public static void fill(char[][] g, int r, int c, char ch) //recursive method
   {
      if(r < 0 || c < 0 || r >= g.length || c >= g[0].length){
         return;
      }
      if(ch != g[r][c]){
         return;
      }
      g[r][c] = '*';
      fill(g, r+1, c, ch);
      fill(g, r -1, c, ch);
      fill(g, r, c+1, ch);
      fill(g, r, c-1, ch);
   }
	// Extension-- count and return the number of asterisks
   public static int fillAndCount(char[][] g, int r, int c, char ch)
   {
      return 0; 
   }
}