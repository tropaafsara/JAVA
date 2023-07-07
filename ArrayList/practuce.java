import java.util.*;
public class practuce {
    public static int maxArea(int[] height) {
        
        int max = 0;
        int lp=0;
        int rp=height.length-1;
        while(lp<rp){
            int ht = Math.min(height[lp],height[rp]);
            int width = rp-lp;
            int curr = ht*width;
            max = Math.max(curr,max);
            if(height[lp]<height[rp]){
                lp++;
            }else{
                rp--;
            }

        }
        return max;
    }
    public static int[] twoSum(int[] numbers, int target) {
        int lp=0;
        int rp= numbers.length-1;

        while(lp<rp){
          int sum =  numbers[lp]+numbers[rp];
          if(sum==target){
            break;
          }
          if(sum>target){
            rp--;
          }else{
            lp++;
          }
        }
        return new int[] {lp, rp};
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        // int[] height = {1,8,6,2,5,4,8,3,7};
        // System.out.println(maxArea(height));
        int[] numbers = {2,7,11,15};
        System.out.println(twoSum(numbers, 9));
    }
}
