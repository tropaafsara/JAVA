public class MaxProdSubArray {
    public static int maxProdSubArray(int[] nums){
        if (nums.length == 0) {
            return 0;
        }
        int mp=Integer.MIN_VALUE;
        int prod= 1;
        for(int i=0;i<nums.length;i++){
            prod*=nums[i];
            mp=Math.max(prod, mp);
            if(prod==0){
                prod=1;
            }
        }
         prod= 1;
        for(int i=nums.length-1;i>=0;i--){
            prod*=nums[i];
            mp=Math.max(prod, mp);
            if(prod==0){
                prod=1;
            }
        }
        return mp;

    }
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProdSubArray(nums));
    }
}
