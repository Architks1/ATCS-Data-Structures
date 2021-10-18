// Name: Archit Srivastava  Date: Sep 19

public class MatrixRecreate
{
   public static void main(String[] args)
   {
      int[][] matrix = TheMatrix.create();
      int[] rowcount = new int[matrix.length];
      int[] colcount = new int[matrix[0].length];
      TheMatrix.count(matrix, rowcount, colcount);
      System.out.println("Recreated Matrix:");
      int[][] new_matrix = TheMatrix.getRecreatedMatrix(rowcount, colcount);
      if(new_matrix == null)
         System.out.println("Did not find a match.");
      else
         TheMatrix.display( new_matrix, rowcount, colcount );
   }
}
class TheMatrix
{
	//do not instantiate recreatedMatrix yet. Only instantiate and set that in recur.
   private static int[][] recreatedMatrix = null;
   
   public static int[][] getRecreatedMatrix(int[] rowcount, int[] colcount)
   {
      re_create(rowcount, colcount);
      return recreatedMatrix;
   }
   public static int[][] create() {
       int row = 2 + (int) (Math.random() * 5);
       int col = 2 + (int) (Math.random() * 5);
       System.out.println(row + " by " + col);
       int[][] arr = new int[row][col];

       for (int i = 0; i < arr.length; i++) {
           for (int j = 0; j < arr[0].length; j++) {
               double c = Math.random();
               if(c >= 0.5){
                   arr[i][j] = 1;
               }
               System.out.print(arr[i][j] + " ");
           }
           System.out.println();
       }
       return arr;
   }
   public static void count(int[][] matrix,int[] rowCount, int[] colCount)
   {
       for(int i = 0; i < matrix.length; i++){
           int count = 0;
           for(int j = 0; j <  matrix[i].length; j++){
               count += matrix[i][j];
           }
           rowCount[i] = count;
       }
       for(int i = 0; i < matrix[0].length; i++){
           int count = 0;
           for(int j = 0; j <  matrix.length; j++){
               count += matrix[j][i];
           }
           colCount[i] = count;

       }
   }
   public static void display(int[][] matrix, int[] rowCount, int[] colCount)
   {
       System.out.print("Row Sum: ");
       for(int i = 0; i < rowCount.length; i++) {
           System.out.print(rowCount[i] + " ");
       }
       System.out.println();
       System.out.print("Col Sum: ");
       for(int i = 0; i < colCount.length; i++) {
           System.out.print(colCount[i] + " ");
       }
       System.out.println();
       for (int[] aMatrix : matrix) {
           for (int j = 0; j < matrix[0].length; j++) {
               System.out.print(aMatrix[j] + " ");
           }
           System.out.println();
       }
   }

   public static void re_create(int[] orig_rowcount, int[] orig_colcount)
   {
       int[][] new_matrix = new int[orig_rowcount.length][orig_colcount.length];
      recur(new_matrix, orig_rowcount, orig_colcount, 0, 0);
   }

   private static void recur(int[][] new_matrix, int[] orig_rowcount, int[] orig_colcount, int row, int col)
   {
      if(compare(new_matrix, orig_rowcount, orig_colcount))    //base case: if new_matrix works, then copy over to recreatedMatrix
      {
      	//copy over from new_matrix to recreatedMatrix (not just references)
         recreatedMatrix = new int[new_matrix.length][];
         for(int i = 0; i < new_matrix.length; i++)
         {
            recreatedMatrix[i] = new int[new_matrix[i].length];
            for (int j = 0; j < new_matrix[i].length; j++)
            {
               recreatedMatrix[i][j] = new_matrix[i][j];
            }
         }
         return;
      }
   	//ENTER YOUR PERMUTATION CODE HERE
      if(col >= orig_colcount.length){
        row++;
        col = 0;
      }
       if(row < orig_rowcount.length && col < orig_colcount.length){
           new_matrix[row][col] = 0;
           recur(new_matrix, orig_rowcount, orig_colcount, row, col + 1);
           new_matrix[row][col] = 1;
           recur(new_matrix, orig_rowcount, orig_colcount, row, col + 1);
       }



   }
   private static boolean compare(int[][] new_matrix, int[] orig_rowcount, int[] orig_colcount)
   {
       int[] rowCount = new int[orig_rowcount.length];
       int[] colCount = new int[orig_colcount.length];
       for(int i = 0; i < new_matrix.length; i++){
           int count = 0;
           for(int j = 0; j <  new_matrix[0].length; j++){
               count += new_matrix[i][j];
           }
           rowCount[i] = count;
       }

       for(int i = 0; i < new_matrix[0].length; i++){
           int count = 0;
           for(int j = 0; j <  new_matrix.length; j++){
               count += new_matrix[j][i];
           }
           colCount[i] = count;
       }
       for(int i = 0; i < rowCount.length; i++){
           if(rowCount[i] != orig_rowcount[i]){
               return false;
           }
       }
       for(int i = 0; i < colCount.length; i++){
           if(colCount[i] != orig_colcount[i]){
               return false;
           }
       }
       return true;
   }


}
