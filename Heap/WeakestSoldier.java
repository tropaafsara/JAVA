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
    public static void main(String[] args) {
        int[][] arr = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        solve(arr, 2);
    }
}
