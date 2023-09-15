import java.util.Stack;

public class NSL {
    public static long[] nearestSmallerElementLeft(long[] arr, int n){//0(n)
        Stack<Long> s = new Stack<>();
        long[] v = new long[n];
        for(int i=0;i<n;i++){
            if(s.isEmpty()){
                v[i]=-1;
            }else if(!s.isEmpty() && s.peek()<arr[i]){
                v[i] = s.peek();
            }else if(!s.isEmpty() && s.peek()>=arr[i]){
                while(!s.isEmpty() && s.peek()>=arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    v[i]=-1;
                }else{
                    v[i] = s.peek();
                }
            }
            s.push(arr[i]);
        }
        return v;
    }
    public static void main(String[] args) {
        // nearest smaller element to left
        long[] arr = {6,5,3,74,2,1};
        long[] v = nearestSmallerElementLeft(arr, arr.length);
        for(int i=0;i<v.length;i++){
            System.out.print(v[i]+" ");
        }
    }
}
