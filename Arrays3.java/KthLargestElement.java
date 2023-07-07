import java.util.Arrays;

public class KthLargestElement {
    public static void kthLargestElement(int[] nums, int k){
        Arrays.sort(nums);//O(n log n)
        System.out.println(nums[nums.length-k]);
        
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        
        kthLargestElement(nums,2);

    }
}
