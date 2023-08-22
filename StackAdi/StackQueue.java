import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class StackQueue {
    public static Queue<Integer> q1 = new LinkedList<Integer>();
    public static Queue<Integer> q2 = new LinkedList<Integer>();
    public static Stack<Integer> s1 = new Stack<>();
    public static Stack<Integer> s2 = new Stack<>();

    //implement stack using 2 queue
    public static void push(int val){
        q2.add(val);
        
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }

        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }

    }
    public static int pop(){
        if(q1.isEmpty()){
            return -1;
        }
        int top = q1.peek();
        q1.remove();
        return top;

    }

    //implement queue using 2 stacks
    public static void push1(int val){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(val);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    } 
    public static int pop1(){
        if(s1.isEmpty()){
            return -1;
        }
        int top = s1.peek();
        s1.pop();
        return top;

    }
    public static void main(String[] args) {


    }
}
