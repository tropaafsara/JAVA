import java.util.Comparator;
import java.util.PriorityQueue;

public class Carfleet {
    static class Car implements Comparable<Car>{
        int position;
        int speed;
        public Car(int position, int speed){
            this.position = position;
            this.speed = speed;
        }
        @Override
        public int compareTo(Car c){
            return this.position-c.position;
        }
    }
    public static int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Car> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<position.length;i++){
            pq.add(new Car(position[i], speed[i]));
        }
        double time =0;
        int fleet =0;
        while(!pq.isEmpty()){
            Car c = pq.remove();
            double carTime = (target-c.position)*1.0/c.speed;
            if(carTime>=time){
                time = carTime;
                fleet++;
            }
        }
        return fleet;
    }
    /* for testcase target=10, pos={6,8} & speed={3,2}, here (10-8)/2=0 which already reaches target so fleet 1.
     * for testcase target=12, pos={10,8} & speed={2,4}, here both becomes 0. but fleet is 1. 
     */
    public static void main(String[] args) {
        int[] pos = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        int target = 10;
        System.out.println(carFleet(target, pos, speed));
    }
}
