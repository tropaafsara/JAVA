import java.util.PriorityQueue;

public class NearestCar {
    //Student class implements interface (Comparable<Student>)
    static class Pair implements Comparable<Pair>{
        int x, y,dist,idx;
        public Pair(int x, int y, int dist,int idx){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.idx = idx;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist-p2.dist;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int pts[][]= {{3,3},{5,-1},{-2,4}};
        int k=2;
        for(int i =0;i<pts.length;i++){
            int dist = pts[i][0]*pts[i][0]+pts[i][1]*pts[i][1];
            pq.add(new Pair(pts[i][0], pts[i][1], dist,i));
        }
        for(int i=0;i<k;i++){
            System.out.println("C"+pq.peek().idx);
            pq.remove();
        }
    }
}
