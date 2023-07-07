import java.util.Comparator;
import java.util.*;

public class Practice5 {
    static class Student implements Comparable<Student>{
            int rank;
            String name;
            public Student(String name, int rank){
                this.name = name;
                this.rank = rank;
            }

            @Override
            public int compareTo(Student s2){
                return this.rank - s2.rank;
            }
    }
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // pq.add(12); //O(logn)
        // pq.add(56);
        // pq.add(3);
        // pq.add(13);
        // pq.add(21);


        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("a", 12));
        pq.add(new Student("b", 2));
        pq.add(new Student("c", 7));
        pq.add(new Student("d", 1));
        while(!pq.isEmpty()){
            System.out.print(pq.peek().rank+" "); //O(1)
            pq.remove();//O(logn)
        }
    }
}
