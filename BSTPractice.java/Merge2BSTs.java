import java.util.ArrayList;

public class Merge2BSTs {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.right = this.left = null;
        }
    }
    public static void getInorder(Node root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    public static Node craeteBST(ArrayList<Integer> arr, int s, int e){
        if(s>e){
            return null;
        }
        int mid = (s+e)/2;
        Node root = new Node(arr.get(mid));
        root.left = craeteBST(arr, s, mid-1);
        root.right = craeteBST(arr, mid+1, e);
        return root;
    }
    public static Node mergeBST(Node root1, Node root2){
        //step-1 -> sort first BST
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);
        //step-2 -> sort second BST
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        //merge
        int i=0;
        int j=0;

        ArrayList<Integer> finalList = new ArrayList<>();

        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)<=arr2.get(j)){
                finalList.add(arr1.get(i));
            }else{
                finalList.add(arr2.get(j));
            }
        }
        while(i<arr1.size()){
            finalList.add(arr1.get(i));
        }
        while(j<arr1.size()){
            finalList.add(arr2.get(j));
        }


        //convert the merged sorted array to Balanced BST
        return craeteBST(finalList, 0, finalList.size()-1);
    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        // 2
        // / \
        // 1 4
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);
        //  9
        // / \
        // 3 12
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);



    //      3
    //     / \
    //    1   9
    //     \  / \
    //      2 4 12
    //      final BST 
    

    Node root = mergeBST(root1, root2);
    preorder(root);
    
    }
}
