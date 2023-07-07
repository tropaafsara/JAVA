import java.util.*;
public class practice {
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

        //preorder traversal : root->left->right
        public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
            
        }
        //inorder traversal : left->root->right
        public static void inorder(Node root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
            
        }
        //postorder traversal : left->right->root
        public static void postorder(Node root){
            if(root == null){
                return;
            }
            preorder(root.left);
            preorder(root.right);
            System.out.print(root.data+" ");
            
        }
        //level order traversal
        public static void levelOrder(Node root ){
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            int sum = 0;
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
                    System.out.println();
                    if(q.isEmpty()){//after removing null queue is empty
                        break;
                    }else{
                        q.add(null);
                    }
                }
                
            }
            
            
        }
    }

        public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        // tree.preorder(root);
        // System.out.println();
        // tree.inorder(root);
        // System.out.println();
        // tree.postorder(root);
        tree.levelOrder(root);
    }
}
