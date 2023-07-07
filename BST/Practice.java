import java.util.ArrayList;

public class Practice {
    static class Node { // not public class
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            // by default left & right subtree is null
        }
    }

    public static Node insert(Node root, int val) {// returns root
        // ____________#1________________
        if (root == null) {
            root = new Node(val); // if root null then create new node & insert value to that node and make it
                                  // root.
            return root;
        }
        // ____________#2________________
        if (root.data > val) {
            // insert at left subtree
            root.left = insert(root.left, val); // add value/node to left subtree & return pointer of left subtree

        }
        // ____________#3________________
        else {
            // insert at right subtree
            root.right = insert(root.right, val);
        }
        return root; // updated root node
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void printRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            System.out.print(root.data + " ");
            printRange(root.left, k1, k2);
            printRange(root.right, k1, k2);
        }
        if (root.data < k1) {
            printRange(root.right, k1, k2);
        }
        if (root.data > k2) {
            printRange(root.left, k1, k2);
        }
    }

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }

    }
    public static Node findInorderSuccessor(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    public static Node delete(Node root, int val) {
        if (root.data > val) {
            root.left = delete(root.left, val);
        } else if (root.data < val) {
            root.right = delete(root.right, val);
        } else {
            // case-1 -> leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // case-2 -> single node
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }

            // case-3 -> both node
            //find inorder successor (left most node in right subtree)
            Node is = findInorderSuccessor(root.right);
            //replace to be deleted value with inorder successor
            root.data = is.data;
            //delete inorder successor node
            root.right = delete(root.right, is.data);
        }
        return root;

    }
    
    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("NULL");
    }
    public static void root2leaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            printPath(path);
        }
        root2leaf(root.left, path);
        root2leaf(root.right, path);
        path.remove(path.size()-1);

    }
    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        // build BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();
        // printRange(root, 7, 15);
        // System.out.println(search(root, 1));
        
        // root = delete(root, 1);
        // inorder(root);

        root2leaf(root, new ArrayList<>());
    }
}
