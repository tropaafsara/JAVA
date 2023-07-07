import java.util.*;
public class PQforObjects {
    static class Student implements Comparable<Student>{// comparable is an interface, Student class can compare it's object
        String name;
        int rank;
        Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }
        //Overriding = child class implements the function of parent class

        @Override 

        public int  compareTo(Student s2){
            return this.rank - s2.rank;
        }

    }
    public static void main(String[] args) {
        // PriorityQueue<Student> pq = new PriorityQueue<>();
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new Student("A", 4));
        pq.add(new Student("B", 5));
        pq.add(new Student("C", 2));
        pq.add(new Student("D", 12));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+"->"+pq.peek().rank);
            pq.remove();
        }
    }
}
