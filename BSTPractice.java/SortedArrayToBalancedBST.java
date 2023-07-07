public class SortedArrayToBalancedBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;   
            this.right = this.left = null;
        }
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node createBST(int arr[], int s, int e){
        if(s>e){//base case
            return null;
        }
        int mid = (s+e)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, s, mid-1);//send half to left subtree
        root.right = createBST(arr, mid+1, e); //send half to right subtree
        return root;
    }
    public static void main(String[] args) {
        int arr[] = {3,5,6,8,10,11,12};
        Node root = createBST(arr, 0, arr.length-1);
        preorder(root);
     }
}
