import java.util.Stack;

public class MaxAreaOfHistogram {
    //nearest smaller element to left
    public static int[] nearestSmallerElementLeft(int[] arr, int n){//0(n)
        Stack<Integer> s = new Stack<>();
        int[] v = new int[n];
        for(int i=0;i<n;i++){
            if(s.isEmpty()){
                v[i]=-1;
            }else if(!s.isEmpty() && arr[s.peek()]<arr[i]){
                v[i] = s.peek();
            }else if(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    v[i]=-1;
                }else{
                    v[i] = s.peek();
                }
            }
            s.push(i);
        }
        return v;
    }
    //nearest smaller Element right
    public static int[] nearestSmallerElementRight(int[] arr, int n){//0(n)
        Stack<Integer> s = new Stack<>();
        int[] v = new int[n];
        for(int i=n-1;i>=0;i--){
            if(s.isEmpty()){
                v[i]=i+1;
            }else if(!s.isEmpty() && arr[s.peek()]<arr[i]){
                v[i] = s.peek();
            }else if(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    v[i]=n;
                }else{
                    v[i] = s.peek();
                }
            }
            s.push(i);
        }
        return v;
    }
    
    public static int maxAreaOfHistogram(int[] stocks, int n){//0(n)
        int[] nsr = nearestSmallerElementRight(stocks, n);
        int[] nsl =  nearestSmallerElementLeft(stocks, n);
        
        
        System.out.print("nsl = ");
        for (int i = 0; i < nsl.length; i++) {
            System.out.print(nsl[i] + " ");
        }
        System.out.println();
        System.out.print("nsr = ");
        for (int i = 0; i < nsr.length; i++) {
            System.out.print(nsr[i] + " ");
        }
        System.out.println();
        int[] width = new int[n];
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            width[i] = (nsr[i] - nsl[i] -1)*stocks[i];
            maxArea = Math.max(width[i], maxArea);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        //max area of histogram
        // int[] stocks = {6,2,5,4,5,1,6};
        int[] stocks = {2,1,5,6,2,3};
        int v = maxAreaOfHistogram(stocks, stocks.length);
        System.out.println(v);
    }
}
