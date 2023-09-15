import java.util.Queue;

public class CircularQueue {
    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        static int front;
        Queue(int n){
            arr= new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty(){
            return rear==-1 && front==-1;//queue empty (true)
        }
        public static boolean isFull(){
            return (rear+1)%size == front;//rear want to go ahead but in the next index front is there.
        }

        public static void add(int val){
            if(isFull()){
                return; //queue is full
            }
            //add 1st element 
            if(front ==-1){
                front =0;
            }
            rear=(rear+1)%size;
            arr[rear] = val;
        }

        public static int remove(){
            if(isEmpty()){
                return -1;
            }
            int result = arr[front];
            
            //remove last element
            if(rear==front){
                rear = front =-1;
            }else{
                front = (front+1)%size;
            }
            return result;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return arr[front]; //front
        }
    }

    //Circular tour
    //since it's a circular tour, if we move 2n distance if the distance not got circular tour wont exist
        public static int tour(int petrol[], int distance[]){
            int required = 0;
            int extra = 0;
            int front =0;
            for(int i=0;i<petrol.length;i++){
                extra+=petrol[i]-distance[i];
                if(extra<0){
                    required+=extra;
                    front = (i+1)%petrol.length;
                    extra = 0;
                }
            }
            if(required+extra<0){
                return -1;
            }
            return front;
        }
    public static void main(String[] args) {
        // Queue q = new Queue(3);
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // System.out.println(q.remove());
        // q.add(4);
        // System.out.println(q.remove());
        // q.add(5);
        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }
           
        int petrol[] = {4,4,1,5,1};
        int distance[] = {5,1,2,3,4};
        int res = tour(petrol, distance);
        System.out.println(res);


    }
}
