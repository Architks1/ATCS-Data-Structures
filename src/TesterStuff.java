import java.util.*;
public class TesterStuff {
    public static void main(String[] args){
        int[] a = {2,3,9,10,11};
        System.out.println(findMax(a, a.length));
    }

    private static int findMax(int[] array, int upper)//"upper" controls where the inner
    //loop of the Selection Sort ends
    {
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < upper; i++){
            if(array[i] > array[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
