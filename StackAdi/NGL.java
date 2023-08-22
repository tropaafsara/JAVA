import java.util.HashMap;
import java.util.Stack;

public class NGL {
    public static int[] nextGreaterElement(int arr[] ){
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        int[] v = new int[n];
        
        for(int i=n-1;i>=0;i--){
            if(s.isEmpty()){
                v[i] = -1;
            }
            else if(s.peek()>arr[i]){
                v[i] = s.peek();
            }
            else if(s.peek()<=arr[i]){
                while(!s.isEmpty() && s.peek()<=arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    v[i] = -1;
                }else{
                    v[i] = s.peek();
                }
            }
            s.push(arr[i]);
        }
        return v;
    }
    //nextGreaterElement I
    public static int[] nextGreaterElementI(int[] n1, int[] n2){
        int[] res = nextGreaterElement(n2);
        int[] v = new int[n1.length];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<res.length;i++){
            hm.put(n2[i], res[i]);
        }
        for(int i=0; i<n1.length;i++){
            v[i] = hm.get(n1[i]);
        }
        return v;

    }
    //nextGreaterElement II
    public static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] v = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            if(s.isEmpty()){
                v[i%n] = -1;
            }
            else if(s.peek()>arr[i%n]){
                v[i%n] = s.peek();
            }
            else if(s.peek()<=arr[i%n]){
                while(!s.isEmpty() && s.peek()<=arr[i%n]){
                    s.pop();
                }
                if(s.isEmpty()){
                v[i%n] = -1;
                } else{
                    v[i%n] = s.peek();
                }  
            }
            s.push(arr[i%n]);
        }
        return v;
    }
    //nextGreaterElement III
    public static int nextGreaterElementIII(int n){
        String str = Integer.toString(n);//convert integer to string
        char[] arr = str.toCharArray();
        int i = arr.length-2;
        while( i>=0 && arr[i]>=arr[i+1]){
            i--;
        }
        if(i==-1){
            return -1;
        }
        int k = arr.length-1;
        while(arr[i]>=arr[k]){
            k--;
        }
        //swap i & k
        char temp = arr[i];
        arr[i] = arr[k];
        arr[k]= temp;

        //concatenate from 0 to i index
        String res="";
        for(int j=0;j<=i;j++){
            res+=arr[j];
        }

        //concatenate from  i+1 to k'th index
        for(int j=arr.length-1;j>i;j--){
            res+=arr[j];
        }
        return Integer.parseInt(res);
        
    }
    
    public static void main(String[] args) {
        // int arr[] = {1,3,0,0,1,2,4};
        // int[] v = nextGreaterElement(arr);
        int[] n1 = {4,1,2};
        int[] n2 = {1,3,4,2};
        // int[] v = nextGreaterElementI(n1, n2);
        // for(int i=0;i<v.length;i++){
        //     System.out.print(v[i]+" ");
        // }

        // int n = 12;
        // int s = nextGreaterElementIII(n);
        // System.out.println(s);

        
        

    }
}
