public class ValidBST {
    static class Node{
        int data;
        Node left;
        Node right;
         
        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data>val){
            root.left = insert(root.left, val); 
        }
        else{
            root.right = insert(root.right, val);
        }
        return root;  
    }
    
    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }
        if(max!=null && root.data>=max.data){
            return false;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }
        return isValidBST(root.left, root , max) && isValidBST(root.right, root, min);

    }
    public static void main(String[] args) {
        // int values[] = {8,5,3,1,4,6,10,11,14};
        int values[] = {1,1,1};
        Node root = null;
        //build BST
        for(int i=0; i<values.length;i++){
            root = insert(root, values[i]);
        }

        if(isValidBST(root, null, null)){
            System.out.println("valid");
        }else{
            System.out.println("not valid");
        }
        
    }
}
