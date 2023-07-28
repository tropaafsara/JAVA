import java.util.Stack;

public class Arrays {
    public static int longestSubarray(int[] arr, int threshold){
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0 && arr[arr.length-1]<=threshold){
                return (arr.length-1-i);
                
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // int[] arr = {2,3,4,5};
        // int threshold = 4 ;
        // System.out.println(longestSubarray(arr, threshold));

        
    }
}
