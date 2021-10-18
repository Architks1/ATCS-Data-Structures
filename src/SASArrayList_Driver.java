//  name:        date: 
//  implements the List interface with a backing array of Objects. 
//	 also overrides toString().

import java.util.ArrayList;

public class SASArrayList_Driver {
    public static void main(String[] args) {
        SASArrayList myList = new SASArrayList();
        ArrayList<String> b = new ArrayList<>();

        myList.add("Apple");
        myList.add("Banana");
        myList.add("Fig");
        myList.add(2, "Cucumber");
        myList.add(3, "Dates");
        System.out.println(myList);
        System.out.println("Size is " + myList.size());
        try {
            myList.add(12, "Peach");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println("Get 2: " + myList.get(2));
        System.out.print("Set at 2: ");
        myList.set(2, "Cherry");
        System.out.println(myList);
        Object obj = myList.remove(2);
        System.out.println("Removed " + obj + " from " + myList);
        System.out.println("Size is " + myList.size());
        System.out.print("Add too many items: ");
        for (int i = 3; i <= 10; i++)
            myList.add(new Integer(i));
        System.out.println(myList);
        System.out.println("Size is " + myList.size());
        System.out.println("Contains \"Breadfruit\"?  " + myList.contains("Breadfruit"));
        System.out.println("Contains \"Banana\"?  " + myList.contains("Banana"));
    }
}

class SASArrayList {
    private int size;                            //stores the number of objects
    private Object[] myArray;

    public SASArrayList()                //default constructor makes 10 cells
    {
        size = 0;
        myArray = new Object[10];
    }

    public int size() {
        return size;
    }

    /* appends obj to end of list; increases size;
        must be an O(1) operation when size < array.length,
           and O(n) when it doubles the length of the array.
         @return true  */
    public boolean add(Object obj) {
        Object[] arr = myArray;
        if (size < myArray.length) {
            myArray[size] = obj;
            size += 1;
            return true;
        }
        myArray = new Object[(size * 2) + 1];
        for (int i = 0; i < arr.length; i++) {
            myArray[i] = arr[i];
        }
        size += 1;
        return true;

    }

    /* inserts obj at position index.  increments size.
     */
    public void add(int index, Object obj) throws IndexOutOfBoundsException  //this the way the real ArrayList is coded
    {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        Object[] t = myArray;
        myArray = new Object[t.length + 1];
        int c = 0;
        for(int i = 0; i < t.length; i++){
            if(i == index){
                myArray[c] = obj;
                c++;
            }
            myArray[c] = t[i];
            c++;
        }
        size++;
    }

    /* return obj at position index.
     */
    public Object get(int index) {
        return myArray[index];
    }

    /* replaces obj at position index.
     */
    public void set(int index, Object obj) {
        myArray[index] = obj;
    }

    /*  removes the node from position index. shifts elements
        to the left.   Decrements size.
   	  @return the object at position index.
   	  */
    public Object remove(int index) {
        int c = 0;
        Object t = myArray[index];
        /*for (int i = 0; i < myArray.length; i++) {
            if (i == index) {
                i++;
            }
            myArray[c] = myArray[i];
            c++;
        }
        size -= 1;
        return t;*/
        for(int i = index; i < size(); i++){
            myArray[i] = myArray[i+1];
        }
        size--;
        return t;
    }

    /*
     this method compares objects and should use .equals(), not ==
        */
    public boolean contains(Object obj) {
        for (int i = 0; i < size; i++) {
            if(myArray[i].equals(obj))
                return true;
        }
        return false;
    }

    /*returns a String of Objects in the array with square brackets and commas
     */
    public String toString() {
        String s = "[";
        for (int i = 0; i < size(); i++) {
            s += myArray[i] + ", ";
        }
        s = s.substring(0, s.length() - 2);
        s += "]";
        return s;
    }
}