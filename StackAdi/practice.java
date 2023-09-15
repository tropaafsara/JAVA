import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
public class practice {
    public static int[] solve(int[] arr, int n){
        Stack<Integer> s = new Stack<>();
        int[] v = new int[n];
        for(int i=2*n-1;i>=0;i--){
            if(s.isEmpty()){
                v[i%n] =  -1;
            }
            else if(!s.isEmpty() && s.peek()>arr[i%n]){  
                v[i%n] = s.peek();
            }else if(!s.isEmpty() && s.peek()<=arr[i%n]){
                while(!s.isEmpty() && s.peek()<=arr[i%n]){
                    s.pop();
                }
                v[i%n]=s.isEmpty()?-1:s.peek();
            }
            s.push(arr[i%n]);
        }
        return v;
    }
    public static void main(String[] args) {
        int[] num2 = {1,2,1};
        int[] v = solve(num2, num2.length);
        for(int i=0;i<v.length;i++){
            System.out.print(v[i]+" ");
        }

        

    }
}
