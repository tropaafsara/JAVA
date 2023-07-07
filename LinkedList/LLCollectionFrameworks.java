import java.util.*;
public class LLCollectionFrameworks {
    public static class Node{
        int data;
        Node next;

        //craeting a node
        public Node(int data){
            this.data = data;
            this.next = null;
        } 
    }
    public static Node head;

    public static void print(Node head){
        if(head == null){
            System.out.println("Linked List is empty");
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    
    public  void zigzag(Node head){
        //find mid
        Node slow =head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        //alternate merge
        while(left!= null && right!=null){
            //zigzag
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            //update
            left = nextL;
            right = nextR;
        }

    }
    public static void main(String[] args) {
        // LinkedList<Integer> ll = new LinkedList<>();
        LinkedList ll = new LinkedList();
        //add
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addFirst(0);
        // System.out.println(ll);
        // ll.removeLast();
        // ll.removeFirst();
        // System.out.println(ll);


        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        System.out.println(ll);
        ll.print();
        ll.zigzag();
       
    }
}
