import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Strings {
    private static int findMinRunways(int[] arrivals, int[] departures) {
        HashMap<Integer, Integer> runwayOccupancy = new HashMap<>();
        for (int i = 0; i < arrivals.length; i++) {
            int arrival = arrivals[i];
            int departure = departures[i];

            // Increment count for arrival minute
            int arrivalCount = runwayOccupancy.getOrDefault(arrival, 0);
            runwayOccupancy.put(arrival, arrivalCount + 1);

            // increment count for departure minute
            int departureCount = runwayOccupancy.getOrDefault(departure, 0);
            runwayOccupancy.put(departure, departureCount + 1);
        }
        int maxOccupancy=(Collections.max(runwayOccupancy.values())); 

        return maxOccupancy;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int j=0;j<t;j++){
            int n = sc.nextInt(); // number of airplanes
            int[] arrivals = new int[n];
            int[] departures = new int[n];

            // Read arrival times
            for (int i = 0; i < n; i++) {
                arrivals[i] = sc.nextInt();
            }

            // Read departure times
            for (int i = 0; i < n; i++) {
                departures[i] = sc.nextInt();
            }

            int minRunways = findMinRunways(arrivals, departures);
            System.out.println(minRunways);

        }
    }
}
