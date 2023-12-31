import java.util.ArrayList;

public class Practice {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;   
        }
    }
    public static Node insert(Node root,int val){
        if(root==null){
            return new Node(val);
        }
        if(root.data>val){
            root.left = insert(root.left, val);
        }
        if(root.data<val){
            root.right = insert(root.right, val);
        }
        return root;


    }
    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root = null;
        for(int i=0;i<values.length;i++){
             root = insert(root,values[i]);
        }
    }
}
