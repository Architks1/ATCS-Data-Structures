//name:     date:
import apple.laf.JRSUIUtils;

import java.util.*;
  
/*******************
Represents a binary expression tree.
The BXT can build itself from a postorder expression.  It can
evaluate and print itself. It also prints an inorder string and a preorder string.  
**********************/
class BXT
{
   private int count;
   private TreeNode root;
   public BXT()
   {
      count = 0;
      root = null;
   }
  /*  enter your instance methods here.  */
      //buildTree
      //display
      //inorderTraverse
      //preorderTraverse
      //evaluateTree     
    public void buildTree(String s){
        String[] t = s.split(" ");
        Stack<TreeNode> b = new Stack();
        for(int i = 0; i < t.length; i++){
            if("+-/*".indexOf(t[i]) > -1){
                TreeNode temp = new TreeNode(t[i]);
                temp.setRight(b.pop());
                temp.setLeft(b.pop());
                b.push(temp);
            }else{
                b.push(new TreeNode(t[i]));
            }
        }
        root = b.pop();
    }
    public String display(){
        return display(root,0);
    }

    public String display(TreeNode t, int level){
        String toRet = "";
        if(t == null)
            return "";
        toRet += display(t.getRight(), level + 1);
        for(int k = 0; k < level; k++)
            toRet += "\t";
        toRet += t.getValue() + "\n";
        toRet += display(t.getLeft(), level + 1);
        return toRet;
    }

    public String preorderTraverse(TreeNode t){
        String toReturn = "";
        if(t == null)
            return "";
        toReturn += t.getValue() + " ";  //preorder visit
        toReturn += preorderTraverse(t.getLeft());         //recurse left
        toReturn += preorderTraverse(t.getRight());        //recurse right
        return toReturn;
    }

    public String inorderTraverse(TreeNode t){
        String s = "";
        if(t == null)
            return "";
        s += inorderTraverse(t.getLeft());
        s += t.getValue() + " ";
        s += inorderTraverse(t.getRight());
        return s;
    }

    public static String postorderTraverse(TreeNode t)
    {
        String s = "";
        if(t == null)
            return "";
        s += postorderTraverse(t.getLeft()) + "";
        s += postorderTraverse(t.getRight()) + " ";
        s += t.getValue() + "";
        return s;
    }

    private double computeTerm(String s, double a, double b){
        if(s.equals("+"))
            return a + b;
        if(s.equals("-"))
            return a - b;
        if(s.equals("*"))
            return a * b;
        if(s.equals("/"))
            return a / b;
        return 0;
    }

    private boolean isOperator(String s){
        if("+-/*".indexOf(s) > -1)
            return true;
        return false;
    }

    public double evaluateTree(){
        return evaluateTree(root);
    }

    private double evaluateTree(TreeNode t){
        if(t == null)
            return 0;
        if(t.getRight() == null)
            return Double.parseDouble(t.getValue().toString());
        if(isOperator(t.getValue().toString()))
            return computeTerm(t.getValue().toString(), evaluateTree(t.getLeft()), evaluateTree(t.getRight()));
        return 0;
    }

    public String preorderTraverse()
    {
        return preorderTraverse(root);
    }
    public String inorderTraverse()
    {
        return inorderTraverse(root);
    }

}
/*******************
Driver for a binary expression tree class.
Input: a postfix string, each token separated by a space.
**********************/
public class BXT_Driver {
    public static void main(String[] args) {
        ArrayList<String> postExp = new ArrayList<String>();
        postExp.add("14 -5 / ");
        postExp.add("20 3 -4 + * ");
        postExp.add("2 3 + 5 / 4 5 - *");

        for (String postfix : postExp) {
            System.out.println("Postfix Exp: " + postfix);
            BXT tree = new BXT();
            tree.buildTree(postfix);
            System.out.println("BXT: ");
            System.out.println(tree.display());
            System.out.print("Infix order:  ");
            System.out.println(tree.inorderTraverse());
            System.out.print("Prefix order:  ");
            System.out.println(tree.preorderTraverse());
            System.out.print("Evaluates to " + tree.evaluateTree());
            System.out.println("\n------------------------");

        }
    }
}

/***************************************
 Postfix Exp: 14 -5 / 
 BXT: 
 	-5
 /
 	14
 Infix order:  14 / -5 
 Prefix order:  / 14 -5 
 Evaluates to -2.8
 ------------------------
 Postfix Exp: 20 3 -4 + * 
 BXT: 
 		-4
 	+
 		3
 *
 	20
 Infix order:  20 * 3 + -4 
 Prefix order:  * 20 + 3 -4 
 Evaluates to -20.0
 ------------------------
 Postfix Exp: 2 3 + 5 / 4 5 - *
 BXT: 
 		5
 	-
 		4
 *
 		5
 	/
 			3
 		+
 			2
 Infix order:  2 + 3 / 5 * 4 - 5 
 Prefix order:  * / + 2 3 5 - 4 5 
 Evaluates to -1.0
 ------------------------
 */