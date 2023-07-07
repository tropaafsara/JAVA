public class EvenNoOfDigits {
    //brute force
    public static int findNumbers(int[] nums) { //O(n2)
        String[] str = new String[nums.length];

        //convert number into string
        for(int i=0; i<nums.length;i++){
            str[i] = Integer.toString(nums[i]);
        }

        int count = 0;
        for(int j=0; j<nums.length;j++){
            if(str[j].length()%2==0){
                count++;
            }
        }
        return count;
}
//optimized
    public static int findNumbers1(int[] nums) { //O(n)
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if((int)Math.log10(nums[i])%2!=0)
                count++;
		}
        return count;
}
    public static void main(String[] args) {
        int[] nums = {555,901,482,1771};
        // System.out.println(findNumbers(nums));
        System.out.println(findNumbers1(nums));
    }
}
