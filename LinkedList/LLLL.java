public class LLLL {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
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
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next= head;
        head = newNode;
    }
    public static void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next= newNode;
        tail = newNode;
    }
    public static void prinLL(){
        if(head==null){
            System.out.println("Linked list is empty");
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
        int i=0;
        Node temp = head;
        while(i<idx-1){
            temp = temp.next;//next node (temp.next) will be temp
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }
    public static void removeFirst(){
        if(size==0){
            System.out.println("Linekd list is empty");
        }else if(size==1){
            int val = head.data;
            head=tail=null; 
            size=0;
            System.out.println(val);
        }
        int val = head.data;
        head = head.next;
        size--;
        System.out.println(val);
    }
    public static void removeLast(){
        if(size==0){
            System.out.println("linekd list is empty");
        }
        else if(size==1){
            int val = head.data;
            head = tail = null;
            size =0;
            System.out.println(val);
        }
        
        Node prev = head;
        int i=0;
        while(i<size-2){
            prev = prev.next;
            i++;
        }
        int val = prev.next.data;
        prev.next=null;
        tail = prev;
        size--;
        System.out.println(val+" was removed");
    }
    public static void main(String[] args) {
        LLLL ll = new LLLL();
        addFirst(5);
        addLast(6);
        prinLL();
        addFirst(9);
        prinLL();
        addMiddle(1, 8);
        prinLL();
        removeFirst();
        prinLL();
        removeLast();
        prinLL();
        System.out.println("size = "+ll.size);
    }
}
