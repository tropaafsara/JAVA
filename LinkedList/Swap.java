public class Swap {
    public class Node{
        int data;
        Node next;  
        Node(int data){
            this.data=data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public void push(int data){
        Node newNode = new Node(data);
        if(head==null){
            head =tail=newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }
    public void print(){
        if(head == null){
            System.out.println("Linked List is empty");
        }
        Node temp = head;
        while(temp!= null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public void swapNodes(int x, int y){
        if(x==y){
            return;
        }
        Node prevX = null;
        Node currX = head;
        while(currX!=null && currX.data!=x){           
            prevX= currX;
            currX = currX.next;
        }
        Node prevY = null;
        Node currY = head;
        while(currY!=null && currY.data!=y){           
            prevY= currY;
            currY = currY.next;
        }
        if(currX==null || currY==null){
            return;
        }
        if(prevX!=null){
            prevX.next = currY;
        }else{
            head = currY;
        }
        if(prevY!=null){
            prevY.next = currX;
        }else{
            head = currX;
        }

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
        
    }

    public void swap(int k){
        Node curr = head;
        int cnt =0;
        Node beg = head;
        Node end = head;
        while(curr!=null){
            curr = curr.next;
            cnt++;
            
        }
         //find node from beg to k
        for(int i=1;i<k;i++){
            beg = beg.next;
        }
        //find node from end to k
        for(int i=0; i<cnt-k;i++){
            end = end.next;
        }

        //swap
        int temp = beg.data;
        beg.data = end.data;
        end.data = temp;
        return;
    }
    public void oddEven(){
        Node oddHead = head;
        Node evenHead = head.next;
        Node evenStart = evenHead;
        while(oddHead!=null && oddHead.next!=null && evenHead !=null && evenHead!=null){
            oddHead.next = oddHead.next.next;
            evenHead.next = evenHead.next.next;
            oddHead = oddHead.next;
            evenHead = evenHead.next;
        }
        oddHead.next = evenStart;
        return;
    }
    public static void main(String[] args) {
        Swap list = new Swap();
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);
        list.print();
        // list.swap(2);
        // list.print();
        list.oddEven();
        list.print();

    }
}
