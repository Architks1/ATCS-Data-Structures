//your name and date
import java.util.*;
/*
[computer, science, java, coffee, nonsense, boo, foo, hello]
[computer, science, java, coffee, nonsense, boo, foo, hello]
First = computer
Second = science
Pointer to Last = hello at ListNode@ddfc2
Copy of Last = hello at ListNode@15dca2
Insert what? what?
[what?, computer, science, java, coffee, nonsense, boo, foo, hello, what?]
*/
public class ListLab1
{
   public static void main(String[] args)
   {
      ListNode head = new ListNode("hello", null);
      head = new ListNode("foo", head);
      head = new ListNode("boo", head);
      head = new ListNode("nonsense", head);
      head = new ListNode("computer",
         	new ListNode("science",
         		new ListNode("java",
         			new ListNode("coffee", head)
         		)
         	)
         );
      print(head);
      print(head);
      
      /**** uncomment the code below for ListLab1 Extension  ****/
      
       System.out.println("First = " + first(head));
       System.out.println("Second = " + second(head));
       ListNode p = pointerToLast(head);
       System.out.println("Pointer to Last = " + p.getValue()+ " at " + p);
       ListNode c = copyOfLast(head);
       System.out.println("Copy of Last =    " + c.getValue()+ " at " + c);

       Scanner in = new Scanner(System.in);
       System.out.print("Insert what? ");
       String x = in.next();
       head = insertFirst(head, x);
       head = insertLast(head, x);
       print(head);
       //System.out.println("done");
   }
   public static void print(ListNode head)
   {
      System.out.print("[");
      while(head != null)
      {
         System.out.print(head.getValue());
         head = head.getNext();
         if(head != null)
            System.out.print(", ");
      }
      System.out.println("]");
   }
   /*   enter your code below   */
   public static Object first(ListNode ptr) {
       if(ptr == null){
           return null;
       }
       return ptr.getValue();
   }
    public static Object second(ListNode head){
       if(head == null|| head.getNext() == null){
           return null;
       }
       return head.getNext().getValue();
    }
    public static ListNode pointerToLast(ListNode head){
        if(head == null){
            return null;
        }
        while(head.getNext() != null){
           head = head.getNext();
        }
        return head;
    }
    public static ListNode copyOfLast(ListNode head){
        if(head == null){
            return null;
        }
        ListNode c = new ListNode(null, null);
        while(head.getNext() != null){
            c = head.getNext();
            head = head.getNext();
        }
        return c;
    }

    public static ListNode insertFirst(ListNode head, Object arg){
       return new ListNode(arg, head);
    }

    public static ListNode insertLast(ListNode head, Object arg){
       ListNode current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(new ListNode(arg, null));
        return head;
    }




    public static ListNode copyNode(ListNode arg)
    {
        ListNode copy = arg;
        return copy;

    }




    //more methods
   
}
