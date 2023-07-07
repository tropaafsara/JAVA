import java.util.ArrayList;
import java.util.Stack;

public class StackBasics {
    
    static class Stack{
        //stack using array list
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty(){//if list size 0 then it's empty
            return list.size()==0;
        }

        public static void push(int data){
            list.add(data);//data is added at top of the stack
        }

        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);//implement top  //list.get -> TC-O(1)
            list.remove(list.size()-1);//remove top
            return top;//return top
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }

    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
