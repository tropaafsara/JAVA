import java.util.LinkedList;

public class Practice7 {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size; //by default size=0
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void print(){
        if(head==null){
            System.out.println("Linked list is empty");
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.print(" null");
        System.out.println();
    }
    public void add(int idx, int data){
        if(idx==0){
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
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public static int removeFirst(){
        if(size==0){
            return 0;
        }else if(size==1){
            int val = head.data;
            head=tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;

    }
    public static int removeLast(){
        if(size==0){
            return 0;
        }else if(size==1){
            int val = tail.data;
            head = tail= null;
            size--;
            return val;
        }
        Node prev = head;
        for(int i=0;i<size-2;i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail=prev;
        size--;
        return val;

    }
    public static int itrSearch(int key){
        Node temp = head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public static int helper(int key, Node head){
        if(head.data==key){
            return 0;
        }
        int idx = helper(key, head.next);
        return idx+1;
        
    }
    public static int recursiveSearch(int key){
        return helper(key,head);
    }
    //reverse
    public static void reverse(Node head){
        Node prev = null;
            Node curr = head;
            Node next;
            while(curr!=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
    }
    //is palindrome
    public static Node findNode(Node head){
         Node slow = head;
         Node fast = head;
         while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
         }
         return slow;
    }
    public static boolean isPalindrome(Node head){
        if(head==null || head.next==null){
            return true;
        }

        //find mid
        Node mid = findNode(head);

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

        //check left and right for palindrome
        Node left = head;
        Node right = prev;
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
            slow= slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    public static void removeCycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                cycle = true;
                break;
            }
        }
        if(cycle==false){
            return;
        }
        //find last node
        slow = head;
        Node prev = null;
        while(fast!=slow){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }
    public static void zigzag(){
        //find mid
        Node slow = head;
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
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        //alternate merge
        while(left!=null && right!=null){
            //4 steps 
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            //2 steps to update
            left = nextL;
            right = nextR;
        }
    }

    public static void main(String[] args) {
        // Practice7 ll = new Practice7();
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addLast(9);
        // ll.addFirst(4);
        // ll.addLast(8);
        // // 4->3->2->1->9->8
        // // ll.add(1, 10);
        // ll.print();
        // System.out.println(size);
        // System.out.println(itrSearch(1));


        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(0);
        ll.addFirst(9);
        System.out.println(ll.get(1));
        
    }
}
