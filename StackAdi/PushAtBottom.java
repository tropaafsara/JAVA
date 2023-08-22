import java.util.Stack;

public class PushAtBottom {

//gfg
    /* public static void pushAtBottom(Stack<Integer> s, int val){
        if(s.isEmpty()){
            s.push(val);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, val);
        s.push(top);
    }
    public Stack<Integer> insertAtBottom(Stack<Integer> s, int X) {
        pushAtBottom(s,X);
        return s;
    } */




    public static void pushAtBottom(Stack<Integer> s, int val){
        if(s.isEmpty()){
            s.push(val);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, val);
        s.push(top);
    }



    //delete stack 
    public static void deleteMiddle(Stack<Integer> s, int val){
        if(s.size()==((val+1)/2)){
        // if(s.size()==(val/2)+1){
                s.pop();
                return;
             }
        int top = s.pop();
        deleteMiddle(s, val);
        s.push(top);
    }
    public static Stack<Integer> print(Stack<Integer> s, int val) {
        deleteMiddle(s, val);
        return s;
    }
    public static void main(String[] args) {
        // Stack<Integer> s = new Stack<>();
        // int val = 5;
        // pushAtBottom(s,val);

        //delete middle value from stack
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        // System.out.println("stack size = " +s.size());

        // Stack<Integer> res = print(s,s.size());
        // System.out.println("stack size = " +res.size());
        // for(int i=0;i<5;i++){
        //     int top = s.peek();
        //     System.out.print(top+" ");
        //     s.pop();
        // }

        //find middle element of stack


        
    }
}
