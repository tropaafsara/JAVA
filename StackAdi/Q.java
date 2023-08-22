import java.util.Queue;
import java.util.Stack;

public class Q {
    //reverse a stack method->1 
    public static String reverse1(String str){
        Stack<Character> s = new Stack<>();
        String str2 = "";
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            s.push(ch);
        }
        while(!s.isEmpty()){
            str2+=s.peek();
            s.pop();
        }
        return str2;
    }
    //reverse a stack method->2
    public static String reverse2(String str){
        Stack<Character> s = new Stack<>();
        String str2 = "";
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            s.push(ch);
        }
        while(!s.isEmpty()){
            str2+=s.peek();
            s.pop();
        }
        return str2;
    }
    //push at bottom
    public static void pushAtBottom(Stack<Integer> s, int val){
        if(s.empty()){
            s.push(val);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, val);
        s.push(top);
    }
    //reverse a stack.
    public static void reverseStack(Stack<Integer> s){
        if(s.size()==1){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    //sort stack using recursion
    public static void insert(Stack<Integer> s, int val){
        if(s.empty() || s.peek()<=val){
            s.push(val);
            return;
        }
        int top = s.pop();
        insert(s, val);
        s.push(top);
        return;
    }
    public static void sort(Stack<Integer> s){
        if(s.size()==1){
            return;
        }
        int top = s.pop();
        sort(s);
        insert(s,top);
    }

    //reverse a full queue using recursion
    public static void reverseQueue(Queue<Integer> q){
        if(q.size()==1){
            return;
        }
        int top = q.remove();
        reverseQueue(q);
        q.add(top);
    }

    //reverse first k elements of queue using recursion
    public static void reverseQueueK(Queue<Integer> q, int k){
        if(q.size()==q.size()-k){
            return;
        }
        int top = q.remove();
        reverseQueue(q);
        q.add(top);
    }
    public static void main(String[] args) {
        // String str = "GeeksforGeeks";
        // String s = reverse2(str);
        // System.out.println(s);

        Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // s.push(5);
        // s.push(6);
        // for(int i=0;i<6;i++){
        //     int top = s.peek();
        //     System.out.print(top+" ");
        //     s.pop();
        // }
        // System.out.println();
        // reverseStack(s);



        s.push(5);
        s.push(1);
        s.push(0);
        s.push(2);
        sort(s);

        for(int i=0;i<4;i++){
            int top = s.peek();
            System.out.print(top+" ");
            s.pop();
        }
        
    }
}
