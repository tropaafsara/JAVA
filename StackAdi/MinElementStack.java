import java.util.Stack;

public class MinElementStack {
     //with extra space
     public static Stack<Integer> s ;
     public static Stack<Integer> ss ;
     
     public static void push(int val) {
         s.push(val);
         if(ss.isEmpty() || ss.peek()>=val){
             ss.push(val);
         }
        
     }
     
     public static void pop() {
         int ans = s.peek();
         s.pop();
         if(ss.peek()==ans){
             ss.pop();
         }
     }
     
     public static int top() {
         return s.peek();
     }
     
     public static int getMin() {
         if(ss.isEmpty()){
             return -1;
         }
         return ss.peek();
     }


     //stack,array,list-> O(n)
     //without extra space -> O(1) -> means using variable

       //with extra space
    public static Stack<Integer> s ;
    public static int minEle ;

    public MinStack1() {
        s = new Stack<>();
    }
    
    public void push1(int val) {
        if(s.size()==0){
            s.push(val);
            minEle = val;
        }else{
            if(val>=minEle){
                s.push(val);
            }
            else if(val<minEle){
                s.push(2*val-minEle);
                minEle = val;
            }
        }
       
    }
    
    public void pop1() {
        if(s.size()==0){
            return;
        }else{
            if(s.peek()>=minEle){
                s.pop();
            }
            else if(s.peek()<minEle){
                minEle = 2*minEle -s.peek();
                s.pop();
            }
        }
    }
    
    public int top1() {
        if(s.isEmpty()){
            return -1;
        }else{
            if(s.peek()>=minEle){
                return s.peek();
            }
            else if(s.peek()< minEle){
                return minEle;
            }
        }
        
    }
    
    public int getMin1() {
        if(s.isEmpty()){
            return -1;
        }
        return minEle;
    }
    public static void main(String[] args) {
        int[] arr = {18,19,29,15,16};
        for(int i=0;i<arr.length;i++){
           push(arr[i]);
        }

    }
}
