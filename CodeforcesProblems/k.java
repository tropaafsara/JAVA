import java.util.*;

public class k {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of monsters
        int k = sc.nextInt(); // damage which Monocarp's ability deals.
        int[] arr = new int[n]; // initial health points of monsters.
        PriorityQueue<Pair<Integer, Integer>> monsters = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            int currPower = arr[i] % k;
            if (currPower == 0 && !monsters.isEmpty()) {
                arr[i] = k;
            } else {
                arr[i] = currPower;
            }
            if (!monsters.isEmpty()) {
                monsters.add(new Pair<>(arr[i], -i));
            }
        }
    }
}
