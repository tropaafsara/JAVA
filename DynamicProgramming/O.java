import java.util.Scanner;

public class O {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int N = scanner.nextInt(); // Number of enemies
            int H = scanner.nextInt(); // Chef's initial strength
            int[] A = new int[N]; // Array to store enemy strengths

            int maxEnemy = 0;

            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
                maxEnemy = Math.max(maxEnemy, A[i]);
            }

            if (H >= maxEnemy) {
                System.out.println(0);
                continue;
            }
            int left = 1;
            int right = maxEnemy; // Maximum possible resistance value
            int result = -1;

            while (left <= right) {
                int mid = (left + right) / 2;

                boolean canDefeatAll = true;
                int remainingStrength = H;
                for (int i = 0; i < N; i++) {
                    if (A[i] <= remainingStrength) {
                        remainingStrength -= A[i];
                    } else {
                        remainingStrength += mid - A[i]; // Chef's strength increases after the battle
                        if (remainingStrength <= 0) {
                            canDefeatAll = false;
                            break;
                        }
                    }
                }
                if (canDefeatAll) {
                    result = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            System.out.println(result);
        }
        
    }
}
