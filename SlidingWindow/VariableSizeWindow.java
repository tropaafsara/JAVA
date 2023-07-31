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
    

    // Longest subarray with sum divisible by K
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
            // else if(!map.containsKey(prefixSum)){
            //     map.put(prefixSum,i);
            // }else{
            //     int currentLength = i - map.get(prefixSum);
            //     count++;
            // }

            if(map.containsKey(prefixSum)){
                count+=map.get(prefixSum);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;

    }

    //Longest K unique characters substring
    public static int longestkSubstr(String s, int k) {
        int i=0;
        int j=0;
        // StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        String str="";
        int freq=0;
        // int max = Integer.MIN_VALUE;
        int max = -1;
        while(j<s.length()){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch, 0)+1);
            if(map.size()<k){
                j++;
            }

            if(map.size()==k){
                max = Math.max(max, j-i+1);
                j++;
            }   
            else if(map.size()>k){
                while(map.size()>k){
                    Character ch2 = s.charAt(i);
                    map.put(ch2, map.get(ch2)-1);
                    if(map.get(ch2)==0){
                        map.remove(ch2);
                    }
                    i++;
                }
                j++;
            }
        }
        return max;
    }
   
    public static void main(String[] args) {
        // int arr[] = {10, 5, 2, 7, 1, 9};
        // int k = 15;
        // System.out.println(lenOfLongSubarr(arr, k));



        // int arr[] = {2, 7, 6, 1, 4, 5};
        // int k = 3;
        // System.out.println(longSubarrWthSumDivByK(arr, k));



        // int arr[] = {6,-1,-3,4,-2,2,4,6,-12,-7};
        // System.out.println(zeroFilledSubarray(arr));

        String s = "aabacbebebe";
        int K = 3;
        System.out.println(longestkSubstr(s, K));
    }
}
