import java.util.*;
public class PrintLevelsOfLevelOders {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // create binary tree
    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    //level order traversal
    public static void maxLevelSum(Node root){ //kth level sum
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 1;
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode!=null){
                System.out.print(currNode.data+" ");
                
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
                
            }else{
                System.out.print(",    level= " +level);
                System.out.println();
                if(q.isEmpty()){//after removing null queue is empty
                    break;
                }else{
                    q.add(null);
                 
                    level++;
                }
                
                
            }
        }
        
        
    }
}
    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        tree.maxLevelSum(root);
    }
}
