import java.util.*;
public class SumOfLevelOrders {
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
        //level order traversal
        public static int levelOrder(Node root,int k ){ //kth level sum
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            int sum = 0;
            int level = 0;
            while(!q.isEmpty()){
                
                
                Node currNode = q.remove();
                if(currNode!=null){
                    //add current node data to sum
                    if(level == k){
                        sum+=currNode.data;
                    }
                    // System.out.print(currNode.data+" ");
                    
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                    
                }else{
                    // System.out.println(sum);
                    // sum =0;
                    System.out.println();
                    if(q.isEmpty()){//after removing null queue is empty
                        break;
                    }else{
                        q.add(null);
                    }
                    level++;
                }
            }
            return sum;
            
        }
        //level order traversal
        public static int maxLevelSum(Node root){ //kth level sum
            Queue<Node> q = new LinkedList<>();
            List<Long> list = new ArrayList<>();
            q.add(root);
            q.add(null);
            int sum = 0;
            int level = 1;
            int maxLevel = 1;
            int max = Integer.MIN_VALUE;
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode!=null){
                    sum+=currNode.data;
                    
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                    
                }else{
                    // System.out.println(sum);
                    // System.out.println(level);
                   
                    if(sum>max){
                        max = sum;
                        maxLevel = level;
                    }
                    System.out.println();
                    if(q.isEmpty()){//after removing null queue is empty
                        break;
                    }else{
                        q.add(null);
                        sum =0;
                        level++;
                    }
                    
                    
                }
            }
            return maxLevel;
            
        }
    }
    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        //sum of each level node value
        // System.out.println(tree.levelOrder(root,2));
        System.out.println(tree.maxLevelSum(root));

    }
}
