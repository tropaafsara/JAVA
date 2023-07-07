import java.util.*;
public class Practice2 {
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
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1; // calculate height here
    }
    public static int count(Node root){
        if(root==null){
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount+rightCount+1; // calculate count here
    }
    public static int sum(Node root){
        if(root==null){
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum= sum(root.right);
        return leftSum+rightSum+root.data; // calculate count here
    }
    public static boolean isIdentical(Node node, Node subRoot){
        if(node == null && subRoot == null){
            return true;
        }
        if(node == null || subRoot == null || node.data!= subRoot.data){
            return false;
        }
        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;
        
    }
    public static boolean subtree(Node root, Node subRoot){
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }
        //else
        return subtree(root.left, subRoot) || subtree(root.right, subRoot);
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

    System.out.println(height(root));
    System.out.println(count(root));
    System.out.println(sum(root));


    //    2    
    //   / \ 
    //  4   5 
    Node subRoot = new Node(2);
    subRoot.left = new Node(4);
    subRoot.right = new Node(5);

    System.out.println(subtree(root, subRoot));
    }
}
