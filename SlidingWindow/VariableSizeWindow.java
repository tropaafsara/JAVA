import java.util.HashMap;

public class VariableSizeWindow {
    // public static int lenOfSmallSubarr(int arr[], int k){
    //     int i=0;
    //     int j=0;
    //     int sum=0;
    //     int min =Integer.MAX_VALUE;
    //     while(j<arr.length){
    //         sum+=arr[j];
    //         while(sum>=k){
    //             min = Math.min(min,j-i+1);
    //             sum-=arr[i];
    //             i++;
    //         }
    //         j++;
    //     }
    //     return min == Integer.MAX_VALUE?0:min;
    // } 
    // public static int lenOfLongSubarr(int arr[], int k){
    //     int i=0;
    //     int j=0;
    //     int sum=0;
    //     int min =Integer.MIN_VALUE;
    //     while(j<arr.length){
    //         sum+=arr[j];
    //         while(sum>=k){
    //             min = Math.max(min,j-i+1);
    //             sum-=arr[i];
    //             i++;
    //         }
    //         j++;
    //     }
    //     return min == Integer.MIN_VALUE?0:min;
    // } 



    //handles negative test cases as well
    public static int lenOfLongSubarr(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum=0;
        int maxLength=0;
        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];

            if(prefixSum==k){
                maxLength=i+1;
            }

            if(!map.containsKey(prefixSum)){
                map.put(prefixSum,i);
            }

            if(map.containsKey(prefixSum-k)){
                int currentLength = i - map.get(prefixSum-k);
                 maxLength = Math.max(maxLength, currentLength);
            }

            
        }
        return maxLength;

    }

    //Longest subarray with sum divisible by K
    public static int longSubarrWthSumDivByK(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum=0;
        int maxLength=0;
        
        for(int i=0;i<arr.length;i++){
            // prefixSum = (prefixSum+arr[i])%k;
            prefixSum = (prefixSum+arr[i]);

            
            // int mod = ((prefixSum % k) + k) % k; // to handle negative test cases

            int mod = (prefixSum % k);

            if(mod==0){
                maxLength=i+1;
            }
            else if(!map.containsKey(mod)){
                map.put(mod,i);
            }else{
                int currentLength = i - map.get(mod);
                 maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;

    }
    //Zero Sum Subarrays
    public static int zeroFilledSubarray(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum=0;
        int count =0;
        
        for(int i=0;i<arr.length;i++){
            // prefixSum = (prefixSum+arr[i])%k;
            prefixSum = (prefixSum+arr[i]);

            if(prefixSum==0){
                count++;
            }
            else if(!map.containsKey(prefixSum)){
                map.put(prefixSum,i);
            }else{
                int currentLength = i - map.get(prefixSum);
                count+=currentLength;
            }
        }
        return count;

    }
   
    public static void main(String[] args) {
        // int arr[] = {10, 5, 2, 7, 1, 9};
        // int arr[] = {0,1,2,3,4,5,6,7,8,9};
        // int k = 3;
        // System.out.println(lenOfLongSubarr(arr, k));



        // int arr[] = {2, 7, 6, 1, 4, 5};
        // int k = 3;
        // System.out.println(longSubarrWthSumDivByK(arr, k));



        int arr[] = {6,-1,-3,4,-2,2,4,6,-12,-7};
        System.out.println(zeroFilledSubarray(arr));
    }
}
