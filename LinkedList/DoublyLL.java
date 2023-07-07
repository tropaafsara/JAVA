public class DoublyLL {
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //add
    public void addFirst(int data){
            Node newNode = new Node(data);  
            if(head == null){
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
    }
    //print
    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //remove First
    public int removeFirst(){
        if(head ==null){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        return val;

    }
    public static void reverseDoublyLL(){
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            //single line change
            curr.prev = next;
            //
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();
        reverseDoublyLL();
        dll.print();
    }
}
