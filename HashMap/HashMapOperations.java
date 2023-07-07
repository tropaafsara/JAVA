import java.util.HashMap;

public class HashMapOperations {
    public static void main(String[] args) {
        //create hashmap
        HashMap<String, Integer> hm = new HashMap<>();

        //insert -> O(1)
        hm.put("India", 150);
        hm.put("China", 50);
        hm.put("Kolkata", 100);

        System.out.println(hm);

        //Get -> O(1)
        int pop = hm.get("India"); // value of india will be stored in pop
        System.out.println(pop);

        //ContainsKey -> O(1)
        //checks if any key exists in map or not
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Indionasia"));

        //Remove -> O(1)
        //removes the key and returns the value
        System.out.println(hm.remove("India")); // removes & returns the value
        System.out.println(hm);

        //size
        System.out.println(hm.size());

        //isEmpty
        hm.clear(); // hashmap will be empty
        System.out.println(hm.isEmpty());

    }
}
