import java.util.LinkedList;

public class lll {
    public static class Node{
        int data;
        Node next;
        //create node
        public  Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public static void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        
        if(head==null){//if linked list is empty
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }
    public static void addLast(int data){
        Node newNode = new Node(data);
        size++;
        
        if(head==null){//if linked list is empty
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }
    public static void printLL(){
        if(head==null){
            System.out.println("Linked List is empty");
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public static void addMiddle(int idx, int data){
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;
        while(i<idx-1){//we'll get prev
            temp=temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public static void removeFirst(){
        if(size==0){
            System.out.println("Linekd list is empty");
        }else if(size==1){
            int val = head.data;
            head = tail = null;
            System.out.println(val);
        }
        int val = head.data;
        head = head.next;
        size--;
        System.out.println(val);
    } 
    public static void removelast(int data){
        if(size==0){
            System.out.println("Linked List is  empty");
        }else if(size==1){
            int val = head.data;
            head = tail = null;
            size=0;
            System.out.println(val);

        }
        Node prev = head;
        int i=0;
        while(i<size-2){
            prev = prev.next;
            i++;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        System.out.println(val);
    }
    public static int itrSearch(int k){
        Node temp = head;
        for(int i=0; i<size;i++){
            if(temp.data == k){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }
    //3 variables, 4 steps
    public static void reverse(){
        Node prev = null;
        Node curr = tail = head;
        while(curr!=null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String[] args) {
        lll ll = new lll();
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addLast(8);
        // ll.printLL();
        // ll.removeFirst();
        // ll.printLL();


        ll.addFirst(9);
        ll.addFirst(8);
        ll.addFirst(2);
        ll.addFirst(5);
        ll.addFirst(3);
        printLL();
        reverse();
        printLL();
        // System.out.println(ll.itrSearch(9));
        // System.out.println("size = "+ll.size);
    }
}
