public class EasyLeetCode {
    //643. Maximum Average Subarray I
    public static double findMaxAverage(int[] nums, int k) {
        int i=0;
        int j=0;
        double max = Integer.MIN_VALUE;
        double sum=0;
        while(j<nums.length){
            sum+=nums[j];
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                max = Math.max(sum/k, max);
                sum-=nums[i];
                i++;
                j++;
            }
        }
        return max;
    }
    //2760. Longest Even Odd Subarray With Threshold
    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int l,r;
        if(nums[0]%2==0){
            l=0;
            r=0;
        }else{
            l=1;
            r=1;
        }
        while(l<nums.length-1){
            if(nums[l]%2!=nums[l+1]%2 && nums[l]<=threshold){
                l++;
            }
        }
        int length = l-r+1;
        return length;
    }
    public static void main(String[] args) {
        // int[] nums = {1,12,-5,-6,50,3};
        // int k=4;
        // System.out.println(findMaxAverage(nums, k));

        int[] nums = {2,3,4,5};
        int k =4;
        System.out.println(longestAlternatingSubarray(nums, k));
    }
}
