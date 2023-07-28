import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    static class Node{
        int data;
        Node left;
        Node right;
         
        Node(int data){
            this.data = data;
            //by default left & right subtree is null
        }
    }
    public static Node insert(Node root, int val){//returns root
        //____________#1________________
        if(root == null){
            root = new Node(val); //  if root null then create new node & insert value to that node and make it root.
            return root;
        }
        //____________#2________________
        if(root.data>val){
            //insert at left subtree
            root.left = insert(root.left, val); //add value/node to left subtree & return pointer of left subtree
            
        }
        //____________#3________________
        else{
            //insert at right subtree
            root.right = insert(root.right, val);
        }
        return root;  // updated root node 
    }


    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static boolean search(Node root, int key){//O(H)
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data>key){
            //search left subtree
            return search(root.left, key);
        }else{
            //search right subtree
            return search(root.right, key);
        }
    }


    public static Node delete(Node root, int val){
        if(root.data<val){
            root.right = delete(root.right, val);//after delete changed right subtree will be stored in root.right pointer
        }
        else if(root.data>val){
            root.left = delete(root.left, val);
        }
        else{
            //case-1 - leaf node
            if(root.left ==null && root.right == null){
                return null; 
            }
            //case-2 - single node
            if(root.left==null){
                return root.right; // when we return the childnode parent node will be deleted
            }
            else if(root.right==null){
                return root.left;
            }
            //case-3 - 2 nodes
            //find inorder successor (leftmost node in right subtree)
            Node is = findInorderSuccessor(root.right); // search inorder successor from right subtree
            root.data = is.data; // replace val with inorder successor value
            root.right = delete(root.right, is.data); // from right subtree root will delete inorder successor
        }
        return root;
    }
    //utility aka. helper function  
    public static Node findInorderSuccessor(Node root){//here the root cannot be null cz we have handled it in 74 no line
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }


    
    public static void printInRange(Node root, int k1, int k2){
        
        if(root == null){
            return ;
        }
        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left,k1,k2);
            System.out.print(root.data+" ");
            printInRange(root.right,k1,k2);
        }
        else if(root.data>k1){
            printInRange(root.left,k1,k2);
        }
        else{
            printInRange(root.right,k1,k2);
        }
        
    }
    // public static int printInRange1(Node root, int k1, int k2){
        
    //     if(root == null){
    //         return 0;
    //     }
    //     int sum = 0;
    //     if(root.data>=k1 && root.data<=k2){
    //         // printInRange(root.left,k1,k2);
    //         sum+=root.data;
    //         // printInRange(root.right,k1,k2);
            
    //     }
    //     if(root.data>k1){
    //         sum += printInRange1(root.left,k1,k2);
    //     }
    //     if(root.data<k2){
    //         sum+=printInRange1(root.right,k1,k2);
    //     }
    //     return sum;
        
    // }
    public static int printInRange1(Node root, int k1, int k2){
        
        if(root == null){
            return 0;
        }
        if(root.data>=k1 && root.data<=k2){
            return root.data+printInRange1(root.left,k1,k2)+printInRange1(root.right,k1,k2);  
        }
        else if(root.data>k1){
            return printInRange1(root.left,k1,k2);
        }
        else{ //(root.data<k1)
            return printInRange1(root.right,k1,k2);
        }
        
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
        if(root.left == null && root.right == null){
            printPath(path); // reached leaf node , print path
        }
        root2leaf(root.left, path);
        root2leaf(root.right, path);
        path.remove(path.size()-1); // remove current node from path
    }

    // public static List<List<Integer>> pathSum(Node root, int targetSum) {
    //     List<List<Integer>> ans=new ArrayList();
    //     List<Integer> li=new ArrayList();
    //     root2leafSum(root,targetSum,ans,li);
    //    return ans;
    // }
    // public static void root2leafSum(Node root, int sum, List<Integer> path, List<List<Integer>> ans){
    //     if(root == null){
    //         return;
    //     }
    //     path.add(root.data);
    //     if(root.left == null && root.right == null){
    //        sum-=root.data;
    //        if(sum==0){

    //        }
    //     }
    //     root2leafSum(root.left,sum-root.data, path,ans);
    //     root2leafSum(root.right, sum-root.data,path,ans);
    //     path.remove(path.size()-1); // remove current node from path

    // }

    //find inorder traversal and if it is sorted then valid BST 
    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }
        if(min!= null && root.data<=min.data){//min.data = max of left subtree
            return false;
        }
        else if(max!= null && root.data>=max.data){ // max.data = min of right subtree
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
    public static void main(String[] args) {
        // int values[] = {5,1,3,4,2,7};
        // int values[] = {8,5,3,1,4,6,10,11,14};
        int values[] = {1,1,1};
        // int values[] = {10,5,15,3,7,18};
        Node root = null;
        //build BST
        for(int i=0; i<values.length;i++){
            root = insert(root, values[i]);
        }

        inorder(root); 
        System.out.println();

        // root = delete(root, 1);
        // inorder(root);

        // printInRange(root, 7, 15);
        // System.out.println();
        // System.out.println(printInRange1(root, 7, 15));

        // root2leaf(root, new ArrayList<>());



        if(isValidBST(root, null, null)){
            System.out.println("valid");
        }else{
            System.out.println("not valid");
        }
        
    }
}
