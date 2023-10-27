import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class WeakestSoldier {
    static class Row implements Comparable<Row>{
        int count;
        int idx;
        public Row(int count, int idx){
            this.count = count;
            this.idx = idx;
        }
        @Override
        public int compareTo(Row r2){
            /* If count same then on the basis of index else count */
            if(this.count==r2.count){
                return this.idx-r2.idx;
            }else{
                return this.count-r2.count;
            }
        }
    }
    public static void solve(int[][] arr,int k){
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            int count = 0;
            for(int j=0;j<arr[0].length;j++){
                count+=arr[i][j]==1?1:0;
            }
            pq.add(new Row(count, i));
        }
        while(pq.size()!=k){
            System.out.println("R"+pq.remove().idx);
        }
    }
    static class Pair implements Comparable<Pair>{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Pair p2){
            if(this.x==p2.x){
                return this.y-p2.y;
            }else{
                return this.x-p2.x;
            }
        }
    }

    public static void mergeIntervals(int[][]intervals){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        List<Pair> list = new ArrayList<>();
        for (int[] n : intervals) {
            pq.add(new Pair(n[0], n[1]));
        }
        while(!pq.isEmpty()){
            Pair n = pq.poll();
            while(!pq.isEmpty() && n.y>=pq.peek().x){
                n.y = Math.max(n.y, pq.poll().y);   
            }
            list.add(n);
        }
        while(!list.isEmpty()){
            System.out.print(list.get(0).x+" ");
            System.out.print(list.get(0).y);
            list.remove(0);
            System.out.println();
        }

    }
    public static void main(String[] args) {
        int[][] arr = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        // solve(arr, 2);
        int[] n = {2,7,4,1,8,1};
        // System.out.println(lastStoneWeight(n));
        int[][] i = {{1,3},{2,6},{8,10},{15,18}};
        mergeIntervals(i);
    }
}
