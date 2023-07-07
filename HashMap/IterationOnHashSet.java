import java.util.*;

public class IterationOnHashSet {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bnagluru");
        System.out.println(cities);

        // Iterator it = cities.iterator();
        // while(it.hasNext()){
        //     System.out.println(it.next());
        // }

        // for (String city : cities) {
        //     System.out.println(city);
        // }


        //ordered
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Noida");
        lhs.add("Bnagluru");
        System.out.println(lhs);
        // lhs.remove("Delhi");
        // System.out.println(lhs);

        //sorted in ascending order
        //NULL values are not allowed
        //O(logn)
        //less optimized than hashset & linked hashset
        TreeSet<String> ts =  new TreeSet<>();
        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Noida");
        ts.add("Bnagluru");
        System.out.println(ts);

    }
}
