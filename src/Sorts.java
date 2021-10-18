import java.util.Arrays;

public class Sorts {
    public static void main(String[] args) {
        int[] a = {1, 9, 213, 32091, 90123, 20398, 123, 120, 0, 99};
        Arrays.sort(a);
      //  System.out.println(bin(a, 991, a.length/2));
    }
    public static int lin(int[] a, int tar){
        for(int i = 0; i < a.length; i++){
            if (a[i] == tar){
                return i;
            }
        }
        return -1;
    }

  /*  public static int bin(int[] a, int tar, int i){
        if(a[i] > tar){
            return bin(a, tar, i / 2);
        }
        if(a[i] < tar){
            return bin(a, tar, i + i / 2);
        }
        if(a[i] == tar){
            return i;
        }
        if(i >= a.length){
            return 0;
        }
        if(a[0] != tar){
            return -1;
        }
        if(a[0] == tar){
            return 0;
        }
        if(a[a.length-1] != tar){
            return -1;
        }
        if(a[a.length-1] == tar){
            return a.length - 1;
        }
        return -1;
    }*/
    public static int bin(int[] a, int tar, int low, int high){
        int mid = (low+high)/2;
        while(low <= high){

        }
        return -1;
    }
}
