public class HeightOfATree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root){
        if(root ==  null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh)+1;
    }
    public static int count(Node root){ //O(n)
        if(root==null){ 
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount+rightCount+1;
    }
    public static int sum(Node root){ //O(n)
        if(root==null){
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum+rightSum+root.data;
    }
    public static int diameter2(Node root){ //O(n^2)
        if(root==null){
            return 0;
        }
        int leftDiam = diameter2(root.left);
        int rightDiam = diameter2(root.right);
        int leftH = height(root.left);
        int rightH = height(root.right);
        int selfDiam = leftH+rightH;
        return Math.max(selfDiam,Math.max(rightDiam,leftDiam));
    }
    static class Info{
        int diam;
        int ht;
        public Info(int diam,int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }
    public static Info diameter(Node root){
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);
        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht+rightInfo.ht);
        int ht = Math.max(leftInfo.ht,rightInfo.ht);
        return new Info(diam,ht);
    }

    public static boolean isIdentical(Node node, Node subRoot){//here node is that node where subroot matches
        //check null conditions
        if(node==null && subRoot==null){
            return true;
        }
        if(node == null || subRoot==null || node.data != subRoot.data){
            return false;
        }

        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        //if all of the conditionsare false then return true
        return true; 
    }
    
    public static boolean isSubtree(Node root, Node subRoot){
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){//check with root
            if(isIdentical(root, subRoot)){
                return true;
            }
        }

        //check with left subtree & right subtree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
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
        // System.out.println(height(root));
        // System.out.println(count(root));
        // System.out.println(sum(root));


    //    2    
    //   / \ 
    //  4   5 
    Node subRoot = new Node(2);
    subRoot.left = new Node(4);
    subRoot.right = new Node(5);
        System.out.println(isSubtree(root, subRoot));
    }
}
