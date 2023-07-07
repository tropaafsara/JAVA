import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pratice3 {
    private static boolean canKillWeeds(int n, int m, int k, List<Integer> days){
        int lastDay = days.get(n - 1); // Day on which the last weed shows up
        // int maxSprays = m - lastDay;// Maximum number of sprays that can be done after the last weed shows up
        // int minDays = Integer.MAX_VALUE; // Minimum number of days required to kill all the weeds
        // for (int i = 0; i < n; i++) {
        //     int day = days.get(i);
        //     if (day > k) {
        //         minDays = Math.min(minDays, day - k);
        //     }
        // }

        // return minDays <= maxSprays;

        if((m+1)>=(lastDay+k)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        List<Integer> days = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int i =0; i<testCase;i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            
            for (int j = 0; j < n; j++) {
                days.add(sc.nextInt()); // Days on which new weeds show up
            }
            String result = canKillWeeds(n, m, k, days) ? "Yes" : "No";
            System.out.println(result);
        }
        
    }
}
