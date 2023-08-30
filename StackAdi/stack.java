import java.util.Stack;

public class stack {
    //Next Greater Element right
    public static long[] nextLargerElement(long[] arr, int n){ //0(n)
        Stack<Long> s = new Stack<>();
        long[] v = new long[n];
        for(int i=n-1;i>=0;i--){
            if(s.isEmpty()){
                v[i]=-1;
            }else if(!s.isEmpty() && s.peek()>arr[i]){
                v[i] = s.peek();
            }else if(!s.isEmpty() && s.peek()<=arr[i]){
                while(!s.isEmpty() && s.peek()<=arr[i]){//weird condition
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
    //Next Greater Element left -> just change the loop in backward
    public static long[] nextLargerElementLeft(long[] arr, int n){//0(n)
        Stack<Long> s = new Stack<>();
        long[] v = new long[n];
        for(int i=0;i<n;i++){
            if(s.isEmpty()){
                v[i]=-1;
            }else if(!s.isEmpty() && s.peek()>arr[i]){
                v[i] = s.peek();
            }else if(!s.isEmpty() && s.peek()<=arr[i]){
                while(!s.isEmpty() && s.peek()<=arr[i]){
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
    //nearest smaller element to left
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
    //nearest smaller Element right
    public static long[] nearestSmallerElementRight(long[] arr, int n){//0(n)
        Stack<Long> s = new Stack<>();
        long[] v = new long[n];
        for(int i=n-1;i>=0;i--){
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

    //stock span (similar to nearest greater element to left)
    public static int[] stockspan(int[] stocks, int n){//0(n)
        Stack<Integer> s = new Stack<>();
        int[] v = new int[n];
        for(int i=0;i<n;i++){
            if(s.isEmpty()){
                v[i]=i+1;
            }else if(!s.isEmpty() && stocks[s.peek()]>stocks[i]){
                v[i] = i-s.peek();
            }else if(!s.isEmpty() && stocks[s.peek()]<=stocks[i]){
                while(!s.isEmpty() && stocks[s.peek()]<=stocks[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    v[i]=i+1;
                }else{
                    v[i] = i-s.peek();
                }
            }
            s.push(i);
        }
        return v;
    }

    //739. Daily Temperatures
    //next greater right
    public static int[] nextGreaterRight(int[] temperatures, int n){
        Stack<Integer> s = new Stack<>();
        int[] v = new int[n];
        for(int i=n-1;i>=0;i--){
            if(s.isEmpty()){
                v[i]=0;
            }else if(!s.isEmpty() && temperatures[s.peek()]>temperatures[i]){
                v[i] = i-s.peek();
            }else if(!s.isEmpty() && temperatures[s.peek()]<=temperatures[i]){
                while(!s.isEmpty() && temperatures[s.peek()]<=temperatures[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    v[i]=0;
                }else{
                    v[i] = i-s.peek();
                }
            }
            s.push(i);
        }
        return v;
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] v = nextGreaterRight(temperatures, temperatures.length);
        return v;
    }
    public static void main(String[] args) {
        //Next Greater Element
        // long[] arr = {1,3, 2, 4};
        // long[] v = nextLargerElement(arr, arr.length);
        // for (int i = 0; i < v.length; i++) {
        //     System.out.print(v[i] + " ");
        // }
        


        // Next Greater Element left
        // long[] arr = {1,3, 2, 4};
        // long[] v = nextLargerElementLeft(arr, arr.length);
        // for (int i = 0; i < v.length; i++) {
        //     System.out.print(v[i] + " ");
        // }
        


        // nearest smaller element to left
        // long[] arr = {4,5,2,10,8};
        // long[] v = nearestSmallerElementLeft(arr, arr.length);
       


        //nearest smaller element to right
        // long[] arr = {4,5,2,10,8};
        // long[] v = nearestSmallerElementRight(arr, arr.length);
        


        //stock span
        // int[] stocks = {100,80,60,70,60,75,85};
        // int[] v = stockspan(stocks, stocks.length);
        // for (int i = 0; i < v.length; i++) {
        //     System.out.print(v[i] + " ");
        // }

       
        int[] temperatures = {73,74,75,71,69,72,76,73};
        dailyTemperatures(temperatures);
        
        
  
    }
}
