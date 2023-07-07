import java.util.*;
public class KthLargestSum {
    static class Node {
        long data;
        Node left;
        Node right;

        Node(long data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

        //level order traversal
        public static long kthLargestSum(Node root,int k ){ //kth level sum
            Queue<Node> q = new LinkedList<>();
            List<Long> list = new ArrayList<>();
            q.add(root);
            q.add(null);
            long sum = 0;
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode!=null){
                    sum += currNode.data;

                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                    
                }else{
                    // System.out.println(sum);
                    list.add(sum);
                    
                    System.out.println();
                    if(q.isEmpty()){//after removing null queue is empty
                        break;
                    }else{
                        q.add(null);
                        sum=0;
                    }
                }
            }
            // System.out.println(list);
            Collections.sort(list); // sorts list in ascending order
            System.out.println(list);
            //now print kth largest element from the list;
            // System.out.println(list.get(list.size()-1));//prints the largest element from the list
            if(k>list.size()){
                return -1;
            }else{
                return list.get(list.size()-k);//prints the largest element from the list
            }
            
        }

    public static void main(String[] args) {
    //      1
    //     / \
    //    2    3    
    //   / \  / \
    //  4   5 6  7
    
    Node root = new Node(1);
    root.left = new Node(200);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
        System.out.println(kthLargestSum(root,2));
    }
}
