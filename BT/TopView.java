import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

public class TopView {
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
    static class Info{
        int hd;
        Node node;
        public Info(Node node,int hd){
            this.hd = hd;
            this.node = node;
        }
    }

    public static void topview(Node root){
        int max=0;
        int min=0;
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        q.add(new Info(root, 0));
        q.add(null);
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
                //add this extra line for bottom-view
                // if(map.containsKey(curr.hd)){
                //     map.put(curr.hd, curr.node);
                // }
                if(curr.node.left!=null){
                    q.add(new Info(curr.node.left,curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right!=null){
                    q.add(new Info(curr.node.right,curr.hd+1));
                    max = Math.max(max,curr.hd+1);
                }
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
    }
    public static void leftView(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.remove();
            
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(curr.data+" ");
                if(curr.left!=null){
                    q.add(curr.left);
                }else{
                    q.add(curr.right);
                }
            }
        }
    }
    
    public static void main(String[] args) {
    //      1
    //     / \
    //    2    3
    //   / \  / \
    //  4   5 6  7

    // Node root = new Node(1);
    // root.left = new Node(2);
    // root.right = new Node(3);
    // root.left.left = new Node(4);
    // root.left.right = new Node(5);
    // root.right.left = new Node(6);
    // root.right.right = new Node(7);
    // // topview(root);
    // leftView(root);

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.right = new Node(5);
    root.right.right = new Node(4);
    rightView(root);



    }
}
