import java.util.LinkedList;

public class LL {
    public static class Node{
        int data;
        Node next;

        //creating a node
        public Node(int data){
            this.data = data;
            this.next = null;
        } 
    }
    public static Node head;
    public static Node tail;
    public static int size ; //by default size=0;

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
        if(idx ==0){
            addFirst(data);
            return;
        }
        //create new node
        Node newNode = new Node(data);
        size++;

        //
        Node temp = head;
        int i =0;
        //add
        while(i<idx-1){
            temp = temp.next;//update temp with i
            i++;
        }
        //i=idx-1; temp->prev
        newNode.next = temp.next; //new node will point to next node
        temp.next = newNode; //temp.next will point to new node

        
    } 

    public int removeFirst(){ //it won't take any parameter bcz we already have head
    if(size==0){
        System.out.println("LL is empty");
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
        //prev : i= size-2
        Node prev = head;
        for(int i=0; i<size-2;i++){
            prev = prev.next;

        } 
        int val = prev.next.data; // tail data
        prev.next = null;
        tail = prev;
        size--;
        return val;

    }

    public int itrSearch(int key){ //O(n)
        int i=0;
        Node temp = head;
        while(temp!= null){
            
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key){
        if(head ==null){
            return -1;
        }
        if(head.data ==key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key){
        return helper(head, key);
    }

    public void reverse(){ //O(n)
        Node prev = null; //cz the value before head is null
        Node curr = tail = head;
        Node next;
        while(curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
        }
        head = prev;
    }

    public void deleteNthFromEnd(int n){//nth node from end = (size-n+1)th node from start
        //calculate size
        int sz=0;
        Node temp=head;
        while(temp!=null){
            temp = temp.next;
            sz++;
        }


        //remove First
        if(n==sz){
            head = head.next;
            return;
        }

        //sz-n
        int i=1;
        int iToFind = sz-n;
        Node prev = head;
        while(i<iToFind){
            prev = prev.next;
            i++;

        }
        prev.next = prev.next.next;
        return;
    }
    //Slow-Fast approach
    public Node findMid(Node head){ //helper
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next!=null ){
            slow =slow.next; //+1
            fast =fast.next.next; //+2
        }
        return slow; //slow = midNode
    }
    public boolean checkPalindrome(){
        if(head == null || head.next==null){
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
            curr.next= prev;
            prev = curr;
            curr=next;
        }

        //right left initialization
        Node right = prev; //right half head
        Node left = head;
        //check left & right half for palindrome
        while(right!=null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public static boolean isCycle(){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next!=null){
            slow = slow.next;//+1
            fast = fast.next.next;//+2
            if(slow == fast){
                return true;//cycle exists
            }
        }
        return false;//cycle doesn't exist

    }
    public static void removeCycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }

        //find meeting point
        slow = head;
        Node prev = null;//last node
        while(fast != slow){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        //remove cycle -> last.next = null;
        prev.next = null;
    }
    public static Node detectCycle() {
        //detect cycle
        Node slow = head;
        Node fast = head;
        
        
        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                slow = head;
                while(slow!=fast){
                    slow = slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
       
    }

    public static void zigzag(){
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
        LL ll = new LL();
        // ll.print();
        // ll.addFirst(2);
        // // ll.print();
        // ll.addFirst(1);
        // // ll.print();
        // ll.addLast(4);
        // ll.addLast(5);
        // ll.add(2,3);
        // ll.print(); //1->2->3->4->5
        // // ll.reverse();
        // // ll.print();
        // ll.deleteNthFromEnd(2);
        // ll.print();
        // System.out.println(ll.size);//size was print in TC-> O(1) bcz we initilized size as static & no loop
        
        // ll.removeFirst();
        // ll.print();
        // ll.removeLast();
        // ll.print();
        // System.out.println(ll.size);


        // System.out.println(ll.itrSearch(5));
        // System.out.println(ll.itrSearch(10));
        // System.out.println(ll.recSearch(5));
        // System.out.println(ll.recSearch(10));

        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(2);
        // // ll.addLast(1);
        // System.out.println(ll.checkPalindrome());


        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        // head = new Node(3);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(0);
        // head.next.next = new Node(-4);
        // head.next.next.next = temp;
        // System.out.println(detectCycle());

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        System.out.println(ll);
        
        ll.zigzag();
        ll.print();
        
    }
}
