import java.util.*;
public class NextGreaterCircular {
    public static void main(String[] args) {
        int nums[] = {6,8,0,1,3};
        Stack<Integer> s = new Stack<>();
        int n = nums.length ;
        int nextGreater[] = new int[n];
        for(int i=0;i<2*n-1;i++){
            while(!s.isEmpty() && s.peek()<=nums[i%n]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i] = -1;
            }else{
                nextGreater[i] = s.peek();
            }
            s.push(nums[i%n]);
        }

        for(int i=0;i<nextGreater.length;i++){
            System.out.print(nextGreater[i]+" ");
        }
        System.out.println();
    }
    
}
