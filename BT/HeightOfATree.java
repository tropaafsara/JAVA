public class HeightOfATree {
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

    public static int height(Node root){
        if(root ==  null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh)+1;
    }
    
    public static int countNode(Node root){ //O(n)
        if(root ==  null){
            return 0;
        }
        int lc = countNode(root.left);
        int rc = countNode(root.right);
        return (lc+rc+1);
    }
    public static int countSum(Node root){ //O(n)
        if(root ==  null){
            return 0;
        }
        int lc = countSum(root.left);
        int rc = countSum(root.right);
        return (lc+rc+root.data);
    }
    public static int diameter2(Node root){//0(n^2)
        if(root==null){
            return 0;
        }

        int leftDiam = diameter2(root.left);
        int rightDiam = diameter2(root.right);
        int leftHt = diameter2(root.left);
        int rightHt = diameter2(root.right);

        int selfDiam = leftHt+rightHt+1;

        return Math.max(selfDiam, Math.max(rightDiam, leftDiam));
    }

    //making a single recursive call and computing diameter and height simultaneously.
    static class Info{
        int diam;
        int ht;
        public Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }
    public static Info diameter(Node root){//O(n)
        if(root==null){
            return new Info(0, 0);
        }
        Info  leftInfo = diameter(root.left);
        Info  rightInfo = diameter(root.right);
        int diam = Math.max(Math.max(leftInfo.diam,rightInfo.diam),(leftInfo.ht+rightInfo.ht+1));
        int ht = Math.max(leftInfo.ht, rightInfo.ht)+1;
        return new Info(diam, ht);
    }
    public static boolean isIdentical(Node node, Node subRoot){
        if(node==null && subRoot == null){
            return true;
        }else if(node==null || subRoot == null || node.data!=subRoot.data){
            return false;
        }

        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }

        return true;

    }
    public static boolean isSubtree(Node root, Node subRoot){//true
        if(root==null){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
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
    // System.out.println(countNode(root));
    // System.out.println(countSum(root));

    // System.out.println(diameter(root).diam);

    //    2    
    //   / \ 
    //  4   5 
    Node subRoot = new Node(2);
    subRoot.left = new Node(4);
    subRoot.right = new Node(5);

    System.out.println(isSubtree(root, subRoot));



    }
}
