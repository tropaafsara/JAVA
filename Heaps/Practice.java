public class Practice {
    public static int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]>0){
                pos++;
            }else if(nums[i]<0){
                neg++;
            }
        }
       int ans = Math.max(pos,neg);
       return ans;
    }

    
    public static void main(String[] args) {
            // int[] nums = {-2,-1,-1,1,2,3};
            // System.out.println(maximumCount(nums));


            


    }
}
