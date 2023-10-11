import java.util.PriorityQueue;

public class CampusBikes {
    static class Pair implements Comparable<Pair>{
        int w, b,dist,idx;
        public Pair(int w, int b, int dist){
            this.w = w;
            this.b = b;
            this.dist = dist;
            this.idx = idx;
        }
        @Override
        public int compareTo(Pair p1, Pair p2){
            if(p1.dist==p2.dist){
                if(p1.w == p2.w){
                    return p1.b-p2.b;
                }
                return p1.w-p2.w;
            }else{
                return p1.dist-p2.dist;
            }
        }
    }
    public static int calcDist(int[]w, int[]b){
        return Math.abs(w[0]-b[0]) + Math.abs(w[1]-b[1]);
    }
    public static int[] assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<workers.length;i++){
            for(int j=0;j<bikes.length;j++){
                int dist = calcDist(workers[i], bikes[j]);
                pq.add(new Pair(i, j, dist));
            }
        }
    }
    public static void main(String[] args) {
        int[][] workers = {{0,0},{2,1}}; 
        int[][] bikes = {{1,2},{3,3}}; 
        PriorityQueue<Pair> pq = new PriorityQueue<>();
    }
}
