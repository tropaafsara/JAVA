import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class K {
    static class Pair implements Comparable<Pair>{
        int count;
        int idx;
        public Pair(int c, int i){
            this.count = c;
            this.idx = i;
        }
        @Override
        public int compareTo(Pair i2){
            if(this.count==i2.count){
                return this.idx-i2.idx;
            }else{
                return this.count-i2.count;
            }
        }
    }
    
    public static void solve(int[][] arr,int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            int ans = 0;
            for(int j=0;j<arr[0].length;j++){
                ans+=arr[i][j]==1?1:0;
            }
            pq.add(new Pair(ans, i));
        }
        for(int i=0;i<k;i++){
            System.out.println(pq.peek().idx);
            pq.remove();
        }

    }
    public static int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums);
        // return nums[nums.length-k];

        PriorityQueue<Integer> pq = new PriorityQueue<>();//min heap
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
                if(pq.size()>k){
                    pq.remove();
                }
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        int[][] arr = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        // solve(arr, 2);

        int[] nums = {3,2,1,5,6,4};
        int k=2;
        System.out.println(findKthLargest(nums,k));
    } 
    }


