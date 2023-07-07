import java.util.*;;
public class practice {
    public static int singleNumber(int[] nums ){
        int ans =0;
        for(int i=0; i<nums.length;i++){
            ans^=nums[i];
        }
        return ans;
    }
    public static int missingNumber(int[] nums) {
        int res = nums.length;//5
        for(int i=0; i<nums.length; i++){
            res ^= i;       //5^0=5, 1^1=0, 3^2=1, 1^3=2
            res ^= nums[i]; //5^4=1, 0^3=3, 1^0=1, 
    }
        return res;
    }

    public static int numberOfSteps(int num) {
        int count=0;
        while(num!=0){
            if(num%2==0){
                num=num/2;
                count++;
            }else{
                num=num-1;
                count++;
            }
        }
        return count;
    }
    public static int xorOperation(int n, int start) {
        int res=0;
        for(int i=0;i<n;i++){
            res^= start; //0^0, 0^2, 
            start = start+2;
        }
        return res;
    }
    public static boolean divideArray(int[] nums) {
        
            Arrays.sort(nums);
            for(int i=0; i<nums.length;i+=2){
                if(nums[i]!=nums[i+1]){
                    return false;
                }
            }
            return true;
    }
    
    public static void main(String[] args) {
        // int[] nums = new int[]{2,2,1,1,4};
        // System.out.println(singleNumber(nums));

        // int[] nums = new int[]{4,3,0,2,1};
        // System.out.println(missingNumber(nums));
        // System.out.println((1^3));

        // int num=14;
        // System.out.println(numberOfSteps(num));
        
        // int n=5;
        // int start =0;
        // System.out.println(xorOperation(n, start));

        int[] nums = new int[]{3,2,3,2,2};
        System.out.println(divideArray(nums));
        
    }
}
