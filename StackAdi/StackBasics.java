import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackBasics {
        
    //Stack Permutations

   public static int isStackPermutation(int n, int[] ip, int[] op) {
        // code here
        Stack<Integer> s = new Stack<>();
        int j=0;
        // int i=0;
        for(int i=0;i<n;i++){
            s.push(ip[i]);
            while(j<n && !s.isEmpty() && s.peek()==op[j] ){
                s.pop();
                j++;
            }
        }
        return s.isEmpty()?1:0;
    }
    public static void main(String[] args) {
        int[] ip = {1,2,3};
        int[] op = {2,1,3} ;
       int res = isStackPermutation(ip.length, ip, op);
       System.out.println(res);
    }
}
