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
    static int sum=0;
    public static void Klevel( Node root, int level, int k){
        if(root==null){
            return;
        }
        
        if(level == k){
            // System.out.print(root.data+" ");
            sum+=root.data;
            System.out.print(sum+" ");

        }
        Klevel(root.left, level+1, k);
        Klevel(root.right, level+1, k);
        
        
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
    Klevel(root, 1, 2);
    }
}
