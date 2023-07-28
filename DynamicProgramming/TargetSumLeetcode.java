public class TargetSumLeetcode {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int x : nums)
            sum += x;
        if(((sum - target) % 2 == 1) || (target > sum))
            return 0;
        
        int n = nums.length;
        int val= (sum - target)/2;
        int[][] t = new int[n + 1][val + 1];
        t[0][0] = 1;
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < val + 1; j++) {
                if(nums[i - 1] <= j)
                    t[i][j] = t[i-1][j] + t[i - 1][j - nums[i - 1]];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        printdp(t);
        return t[n][val];
    }
    public static void printdp(int[][] t){
        for(int i=0;i<t.length;i++){
            for(int j=0;j<t[0].length;j++){
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target =3;
        System.out.println(findTargetSumWays(nums, target));
    }
}
