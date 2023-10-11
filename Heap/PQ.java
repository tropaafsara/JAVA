import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {
    public static void main(String[] args) {
        //ascending order
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);//0(long)
        pq.add(4);
        pq.add(1);
        pq.add(7);
        /* Smaller number has the highest priority */
        while(!pq.isEmpty()){
            System.out.print(pq.peek()+" ");
            pq.remove();//O(1)
        }
        System.out.println();


        //ascending order
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        pq2.add(3);//0(long)
        pq2.add(4);
        pq2.add(1);
        pq2.add(7);
        /* Bigger number has the highest priority */
        while(!pq2.isEmpty()){
            System.out.print(pq2.peek()+" ");
            pq2.remove();//O(logn)
        }
    }
}
