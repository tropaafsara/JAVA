import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class bt {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    static class BinaryTree{
        static int idx =-1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }
    //preorder == root->left->right

    public static void preorder(Node root){
        if(root==null){ 
            return;//backtrack
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        //after return code starts from here
        preorder(root.right);
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data+" ");
        inorder(root.right);
    }
    public static void levelOrder(Node root){//O(2*n)->O(n)  [element has entered in a queue and was removed from the queue]
        Queue<Node> q = new LinkedList<>();
        int height=0;
        int countNode =0;
        q.add(root);
        // countNode++;//node calculation
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode==null){
                System.out.println();
                // height++;//height calculation
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                    // countNode++;//node calculation
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                    // countNode++;//node calculation
                }
            }
        }
        System.out.println("height of a tree = "+ height);
        System.out.println("Nodes of a tree = "+ countNode);

    }
    public static void inverseLevelOrder(Node root){//O(2*n)->O(n)  [element has entered in a queue and was removed from the queue]
        Queue<Node> q = new LinkedList<>();
        int height=0;
        int countNode =0;
        q.add(root);
        // countNode++;//node calculation
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode==null){
                System.out.println();
                // height++;//height calculation
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                    // countNode++;//node calculation
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                    // countNode++;//node calculation
                }
            }
        }
        System.out.println("height of a tree = "+ height);
        System.out.println("Nodes of a tree = "+ countNode);

    }
    
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        // preorder(root);
        // levelOrder(root);
        inverseLevelOrder(root);

    }
}
