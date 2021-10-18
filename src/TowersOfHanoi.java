public class TowersOfHanoi {
    public static void main(String[] args){
        int num = 10;
        move(num, 1, 3, 2);
    }

    private static void move(int n, int i, int j, int k){
        if(n > 0){
            move(n-1, i, k, j);
            System.out.println("Move ring " + n + " from peg " + i + " to " + j);
            move(n-1,k,j,i);
        }

    }

}
