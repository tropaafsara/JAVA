public class LinkedListRevision {
    public static class Node{
        int data;
        Node next;

        //creating a node
        public Node(int data){
            this.data=data;
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
        //if list is empty
        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }
    public void addLast(int data){
        //create new node
        Node newNode = new Node(data);
        size++;
        //if list is empty
        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }
    public void print(){
        if(head == null){
            System.out.println("Linked list is empty");
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public void add(int idx, int data){
        
        if(idx==0){
            addFirst(data);
            return;
        }
        //create a new node
        Node newNode = new Node(data);
        size++;

        //keep head in temp
        Node temp = head;

        //find prev node from idx to add
        int i=0;
        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public int removeFirst(){
        if(size==0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
            head = tail = null;
            size =0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size ==0){
            System.out.println("LL is empty");
        return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
             head = tail = null;
             size =0;
            return val;
        }  
        Node prev = head;
        for(int i=0;i<size-2;i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }
    public int itrSrch(int key){
        int i=1;
        Node temp=head;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public void reverse(){ //itr   TC ->O(n)
        Node prev =null;
        Node curr = tail = head;
        Node next;
        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public void deleteNthNodeFromEnd(int n){
        //size calculation
        int sz=0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            sz++;
        }

        //delete    
        if(n==sz){
            head = head.next;//remove First -> null
            return;
        }
        int i =1;
        Node prev = head;
        while(i<sz-n){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    //slow-fast approach
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next !=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPlaindrome(){
        //find mid
        Node mid = findMid(head);

        //reverse 2nd half
        Node prev = null;
        Node curr = mid;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //right left initialization
        Node left = head;
        Node right = prev;

        //check left & right half for palindrome
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;

    }

    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow =slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    public static void removeCycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycleExists = false;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow =slow.next;
            if(fast==slow){
                cycleExists = true;
                break;
            }
        }
        if(cycleExists=false){
            return;
        }

        //find meeting point
        slow = head;
        Node prev = null;//last node of first
        while(slow!=fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;  
    }

    public void zigzag(){
        //find mid
        Node mid = findMid(head);

        //reverse 2nd half
        Node prev = null;
        Node curr = mid.next;
        mid.next = null;    
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next= prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        //alternate merging
        while(left!=null && right!=null){
            //zigzag
            nextL= left.next;
            left.next = right;
            nextR= right.next;
            right.next = nextL;

            //update;
            left = nextL;
            right = nextR;
        }

    }
    public static void main(String[] args) {
        LinkedListRevision llr1 = new LinkedListRevision();
        LinkedListRevision llr2 = new LinkedListRevision();
        llr1.addFirst(4);
        llr1.addFirst(5);
        llr1.addLast(1);
        llr1.addLast(2);
        llr1.addLast(3);
        // llr.add(1, 8);
        // llr.removeFirst();
        // llr.removeLast();
        llr1.print();
        // llr.reverse();
        // llr.deleteNthNodeFromEnd(2);
        // System.out.println(llr.isPlaindrome());
        
        // System.out.println("This size of the linked list: "+size);
        // System.out.println(llr.itrSrch(8));

    }
}
