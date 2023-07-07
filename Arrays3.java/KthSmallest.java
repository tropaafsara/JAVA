import java.util.Arrays;

public class KthSmallest {
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        Arrays.sort(arr);
        return arr[k-1];
        
    }
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        System.out.println(kthSmallest(arr, 0,arr.length-1,3));
        
    }
}
