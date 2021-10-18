//name:    date:  
import java.util.*;
import java.io.*;
public class QuickSort_Driver
{
   public static void main(String[] args) throws Exception
   {
      int n = (int)(Math.random()*50 + 10);
      double[] array = new double[n];
      for(int k = 0; k < array.length; k++)
         array[k] = Math.random();
         	
      QuickSort.sort(array);
      print(array);
      if( isAscending(array) )
         System.out.println("In order!");
      else
         System.out.println("oops!");
   }
   public static void print(double[] a)   
   {
      for(double number : a)    //doing something to each element
         System.out.print(number+" ");
      System.out.println();
   }
   public static boolean isAscending(double[] a)
   {
      for(int i = 0; i < a.length - 1; i++){
         if(a[i] > a[i+1]){
            return false;
         }
      }
      return true;
   }
}
/************************************************
name:    date:
copy the code from the handout
************************************************/
class QuickSort
{
   public static void sort(double[] array)
   {
       helper(array, 0, array.length - 1);
   }
   private static void helper(double[] array, int start, int end)
   {
       int i = start;
       int j = end;
       double pivot = array[(start+end)/2];
       // Divide into two arrays
       while (i <= j) {
           while (array[i] < pivot) {
               i++;
           }
           while (array[j] > pivot) {
               j--;
           }
           if (i <= j) {
               swap(array, i, j);
               i++;
               j--;
           }
       }
       if (start < j)
           helper(array, start, j);
       if (i < end)
           helper(array, i, end);
   }
   private static void swap(double[] array, int a, int b)
   {
      double c = array[b];
      array[b] = array[a];
      array[a] = c;
   }
}

