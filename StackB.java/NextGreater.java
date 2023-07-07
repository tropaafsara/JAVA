import java.util.*;
public class NextGreater {
    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for(int i= arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){//s.peek() = top element of stack
                s.pop();
            
            }
            if(s.isEmpty()){
                nextGreater[i]=-1;
            }else{
                nextGreater[i] = arr[s.peek()];
            }

            s.push(i);//push index in stack not value 
        }

        for(int i=0;i<nextGreater.length;i++){
            System.out.print(nextGreater[i]+" ");
        }
        System.out.println();
}
}

//next greater right
//next greater left
//next smaller right
//next smaller left
