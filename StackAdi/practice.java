import java.util.ArrayList;
import java.util.Stack;
 //stock span (similar to nearest greater element to left)
public class practice {
    public static int[] stockspan(int[] arr, int n){
        Stack<Integer> s = new Stack<>();
        int[] v = new int[n];
        for(int i=0;i<n;i++){
            if(s.isEmpty()){
                v[i] = i+1;
            }else if(!s.isEmpty() && arr[s.peek()]>arr[i]){
                v[i] = i-s.peek();
            }else if(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                while(!s.isEmpty() && arr[s.peek()]<=arr[i] ){
                    s.pop();
                }
                if(s.isEmpty()){
                    v[i] = i+1;
                }else{
                    v[i] = i-s.peek();
                }
            }

            s.push(i);
        }
        return v;

    }
    public static int[] nsl(int[] arr, int n){
        Stack<Integer> s = new Stack<>();
        int[] v = new int[n];
        for(int i=0;i<n;i++){
            if(s.isEmpty()){
                v[i] = i+1;
            }else if(!s.isEmpty() && arr[s.peek()]<arr[i]){
                v[i] = i-s.peek();
            }else if(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                while(!s.isEmpty() && arr[s.peek()]>=arr[i] ){
                    s.pop();
                }
                if(s.isEmpty()){
                    v[i] = i+1;
                }else{
                    v[i] = i-s.peek();
                }
            }

            s.push(i);
        }
        return v;

    }
    public static int[] nsr(int[] arr, int n){
        Stack<Integer> s = new Stack<>();
        int[] v = new int[n];
        for(int i=n-1;i>=0;i--){
            if(s.isEmpty()){
                v[i] = n-i;
            }else if(!s.isEmpty() && arr[s.peek()]<arr[i]){
                v[i] = s.peek()-i;
            }else if(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                while(!s.isEmpty() && arr[s.peek()]>=arr[i] ){
                    s.pop();
                }
                if(s.isEmpty()){
                    v[i] = n-i;
                }else{
                    v[i] = s.peek()-i;
                }
            }

            s.push(i);
        }
        return v;

    }
    public static int maxAreaHisto(int[] arr , int n){
        int[] v1 = nsl(arr,n);
        int[] v2 = nsr(arr,n);
        System.out.print("nsl = ");
        for (int i = 0; i < v1.length; i++) {
            System.out.print(v1[i] + " ");
        }
        System.out.println();
        System.out.print("nsr = ");
        for (int i = 0; i < v2.length; i++) {
            System.out.print(v2[i] + " ");
        }
        System.out.println();
        int res =0;
        for(int i=0;i<n;i++){
            res = Math.max((v1[i]+v2[i]-1)*arr[i], res);
        }
        return res;
        
        
        
    }
    public static void main(String[] args) {
        // int[] arr = {100,80,60,70,60,75,85};
        // int[] v = stockspan(arr, arr.length);
        // for (int i = 0; i < v.length; i++) {
        //     System.out.print(v[i] + " ");
        // }
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        int v = maxAreaHisto(arr, arr.length);
        System.out.println(v);
        

    }
}
