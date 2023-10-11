import java.util.LinkedList;
import java.util.Queue;

public class MorePractice {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh)+1;
    }
    //count nodes
    public static int countNode(Node root){
        if(root==null){
            return 0;
        }
        int lc = countNode(root.left);
        int rc = countNode(root.right);
        return (lc+rc+1);
    }

    
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(countNode(root));
       
        

    }
}
