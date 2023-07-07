import java.util.*;

public class LoopsInHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 150);
        hm.put("China", 50);
        hm.put("Kolkata", 100);
        hm.put("US", 180);
        hm.put("Dhaka", 500);
        hm.put("Ukraine", 1000);
        hm.put("Italy", 180);

        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println(k+" = "+hm.get(k));

        }
    }
}
