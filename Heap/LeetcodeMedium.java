import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetcodeMedium {
    //1167. Minimum Cost to Connect Sticks
    public static int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();//sorts in ascending order automatically
        for(int i=0;i<sticks.length;i++){
            pq.add(sticks[i]);
        }
        int cost=0;
        while(pq.size()>1){
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost+=min1+min2;
            pq.add(min1+min2);
        }
        return cost;
    }
    //215. Kth Largest Element in an Array
    public static int findKthLargest(int[] nums, int k) {//O(nlogk)
        PriorityQueue<Integer> pq = new PriorityQueue<>();//ascending/min heap
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
                if(pq.size()>k){
                    pq.remove();
                }
            
        }
        return pq.peek();
    }
    public static int findKthSmallest(int[][] matrix, int k) {//O(n*m*logk)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());//descending/max heap
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                pq.add(matrix[i][j]);
                if(pq.size()>k){
                    pq.remove();
                }
            }
        }
        return pq.peek();
    }
    //2208. Minimum Operations to Halve Array Sum
    public static int halveArray(int[] nums) {
        int count =0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());//descending->max heap
        double sum = 0;
        for(int i=0;i< nums.length;i++){
            sum+=nums[i];
            pq.add((double)nums[i]);
        }
        while(sum>sum/2){
            count++;
            double val = pq.remove();
            val= val/2;
            sum = sum - val;
            pq.add(val);
        }
        return count;
        
    }
    public static void main(String[] args) {
        int[] nums = {5,19,8,1};
        System.out.println(halveArray(nums));
    }
}
