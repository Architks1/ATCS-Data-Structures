// name:     date:

import java.util.*;
import java.io.*;

public class Josephus
{
    private static String WINNER = "Josephus";
    public static void main(String[] args) throws FileNotFoundException
    {
        /* run it first with J_numbers.txt  */
        ListNode p = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("How many names (2-20)? ");
        int n = Integer.parseInt(sc.next());
        p = readNLinesOfFile(n, new File("J_numbers.txt"));
        System.out.print("How many names to count off each time?"  );
        int countOff = Integer.parseInt(sc.next());
        p = countingOff(p, countOff, n);
        System.out.println(p.getValue() + " is the winning position.");

        /* run it next with J_names.txt  */
        System.out.println("\n ****  Now start all over. **** \n");
        p = readNLinesOfFile(n, new File("J_names.txt"));
        System.out.print("Enter the winning position:  ");
        int winPos = Integer.parseInt(sc.next());
        replaceAt(p, WINNER, winPos);
        p = countingOff(p, countOff, n);
        System.out.println(p.getValue() + " wins!");
    }
    /* reads the names, calls insert(), builds the linked list.
         Notes:
             Objects should be strings.
             This method should call insert.
       */
    public static ListNode readNLinesOfFile(int n, File f) throws FileNotFoundException
    {
        ListNode l = null;
        String s = new String();
        Scanner sc = new Scanner(f);
        for(int i = 0; i < n; i++){
            s = sc.next();
            if(i == 0){
                l = new ListNode(s, null);
            }else{
                l = insert(l, s);
            }
        }
        return l;
    }
    /* helper method to build the list.  Creates the node, then
    inserts it at the back of the circular linked list.
        Hints:
            What happens if p is null? What should happen?
            What happens if p has one node? What should happen?
            What happens if p has a bunch of nodes?
                    What does it look like beforehand?
                    What should the new list look like? Your new node should be at the BACK.
	 */
    private static ListNode insert(ListNode p, Object obj)
    {
        if(p.getNext() != null){
            ListNode t = p;
            t = t.getNext();
            while(t.getNext() != p){
                t = t.getNext();
            }
            t.setNext(new ListNode(obj,p));
            return p;
        }
        p.setNext(new ListNode(obj, p));
        return p;
    }
    /* Runs a Josephus game, counting off and removing each name. Prints after each removal.
       Ends with one remaining name, who is the winner.
       Notes:
          Should call both remove and print
          Should actually change the inputted list
          Should return a list with only one node.
        */
    public static ListNode countingOff(ListNode p, int count, int n)
    {
        if(n == 2)
        {
            for(int i = 0; i < count; i++)
            {
                p = p.getNext();
            }
            p.setNext(null);
            System.out.println();
            System.out.println("[" + p.getValue() + "]");
            return p;
        }
        else
        {
            p = remove(p,count);
            print(p);
            return countingOff(p, count, n-1);
        }
    }
    /* removes the node after counting off count-1 nodes.
         Notes:
             if you called remove with the arguments as:
                     the circular list A->B->C->D and 2,
             it should remove C, and return the circular list D->A->B
       */
    private static ListNode remove(ListNode p, int count)
    {
        for(int i = 0; i < count - 2; i++){
            p = p.getNext();
        }
        p.setNext(p.getNext().getNext());
        p = p.getNext();
        return p;
    }
    /* prints the circular linked list.
         Should print with square brackets and commas.
       */
    public static void print(ListNode p)
    {
        ListNode t = p;
        System.out.print("[" + t.getValue() + " ");
        t = t.getNext();
        while(t != p){
            System.out.print(t.getValue() + " ");
            t = t.getNext();
        }
        System.out.println("]");
        //System.out.println();
    }
    /* replaces the value (the string) at the winning node.
     */
    public static void replaceAt(ListNode p, Object obj, int pos)
    {
        for(int i = 0; i < pos - 1; i++){
            p = p.getNext();
        }
        p.setValue(obj);
    }

   /* Expected output for passing in 5 for num and 3 for counting off.
        Note that you will need to 4 after it reads in the names.
[1, 2, 3, 4, 5]
[4, 5, 1, 2]
[2, 4, 5]
[2, 4]
[4]

 ****  Now start all over.  Enter the winning position in the JOptionPane.  ***

[Michael, Hannah, Jacob, Josephus, Matthew]
[Josephus, Matthew, Michael, Hannah]
[Hannah, Josephus, Matthew]
[Hannah, Josephus]
[Josephus]
Josephus wins!
   */
}


