public class QueueUsingLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Queue{
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty(){
            return head == null & tail == null;
        }
        //add in tail
        public static void add(int data){ 
            Node newNode = new Node(data);
            //add element for first time, front & rear will point to same element
            if(head == null){
                //add element for first time, head & tail will point to same new node
                head = tail = newNode;
                return;
            }
            //if we already have elements
            tail.next = newNode;
            tail = newNode;
            
        }

        //remove from head
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue empty");
                return -1;
            }
            int front = head.data;
            //single element
            if(tail == head){
                tail = head = null;
            }else{
                head = head.next;//then prev head will be removed automatically
            }
            return front;
            
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue empty");
                return -1;
            }
            // return arr[0];
            return head.data;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
            q.add(1);
            q.add(2);
            q.add(3);
    
            while(!q.isEmpty()){
                System.out.println(q.peek());
                q.remove();
            }
    }
}
