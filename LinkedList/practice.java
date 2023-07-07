public class practice {
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
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        //create new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head =tail=newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void addLast(int data){
        //create new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head =tail=newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void print(){
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
    public void add(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;

        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        //i = idx-1; temp->prev
        newNode.next = temp.next;
        temp.next = newNode;


    }

    public Node findMid(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null || fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //find mid
        Node midNode = findMid(head);

        //reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;
        //check left & right
        while(right != null){
            if(right.data != left.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public static void main(String[] args) {
        practice ll = new practice();
        // // ll.print();
        // ll.addFirst(1);
        // // ll.print();
        // ll.addFirst(2);
        // // ll.print();
        // ll.addLast(3);
        // ll.addLast(5);
        // ll.add(2,9);
        // ll.print();
        // System.out.println(ll.size);
        
        // ll.print();


        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);
        System.out.println(ll.checkPalindrome());

    }
}
