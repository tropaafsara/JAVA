import java.util.PriorityQueue;

public class ConnectNRopes {
    public static void main(String[] args) {
        int ropes[] = {3,2,4,1};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<ropes.length;i++){
            pq.add(ropes[i]);
        }

        int cost = 0;
        while(pq.size()>1){
            int min = pq.remove();//first min
            int min2 = pq.remove(); //2ns min

            cost+= min+min2;
            pq.add(min+min2);
        }

        System.out.println(cost);
    }
}
