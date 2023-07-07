import java.util.Stack;

public class QueueUsingStacks {
    static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        //if s1 empty then full queue is empty
        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        //add - O(n)
        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            //if s1 empty
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue empty");
                return -1;
            }
            //else
            return s1.pop();
        }
        //peek ( to see elements )
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue empty");
                return -1;
            }
            return s1.peek();
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
