import java.util.ArrayList;

public class KthLevel {
    static class Node{
        int data ;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void kthLevel(Node root, int k, int level){
        // if(root==null){
        //     return;
        // }
        if(k==level){
            System.out.print(root.data+" ");
            return;
        }
        kthLevel(root.left, k, level+1);//after it's execution
        kthLevel(root.right, k, level+1);//it will execute
    }
    
    public static void main(String[] args) {
    //      1
    //     / \
    //    2    3
    //   / \  / \
    //  4   5 6  7

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    int k=2;
    kthLevel(root, k, 1);
    ArrayList<Integer> arr = new ArrayList<>();
    arr.a
    }
}
