public class FixedSizeLeetCodeMid {

    //1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int i=0, j=0;
        int prefixSum = 0;
        int ans = 0;
        while(j<n){
            prefixSum+=arr[j];
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                if(prefixSum/k>=threshold){
                    ans++;
                }
                prefixSum-=arr[i];
                i++;
                j++;
            }
        }
        return ans;
    }
    //1248. Count Number of Nice Subarrays
    public static int numberOfSubarrays(int[] nums, int k) {
        
        int sum = 0;
        int i=0;
        int j=0;
        int ans = 0;
        for(int l=0;l<nums.length;l++){
            nums[l] = (nums[l]%2==0) ? 0 :1;
        }
        while(j<nums.length){
            sum+=nums[j];
            if(sum<k){
                j++;
            }else if(sum==k){
                ans++;
                while(nums[i]!=1){
                    ans++;
                    i++;
                }
                // i++;
                j++;
                
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        // int[] arr = {2,2,2,2,5,5,5,8};
        // int k=3;
        // int threshold = 4;
        // System.out.println(numOfSubarrays(arr, k, threshold));

        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k=2;
        System.out.println(numberOfSubarrays(nums,k));
    }
}
