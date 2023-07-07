import java.util.*;

public class j {
public static boolean isCompatible(String donor, String recipient) {
        if (donor.equals("A")) {
            return recipient.equals("A") || recipient.equals("AB");
        } else if (donor.equals("B")) {
            return recipient.equals("B") || recipient.equals("AB");
        } else if (donor.equals("AB")) {
            return recipient.equals("AB");
        } else if (donor.equals("O")) {
            return recipient.equals("A") || recipient.equals("B")|| recipient.equals("AB")|| recipient.equals("O");
        }

        return false;
    }

    private static int findMaxChainLength(int n, String[] bloodTypes) {
        int maxChainLength = 0;
        int[] chainLengths = new int[n];

        for (int i = 0; i < n; i++) {
            chainLengths[i] = 1;

            for (int j = 0; j < i; j++) {
                if (isCompatible(bloodTypes[j], bloodTypes[i]) && chainLengths[j] + 1 > chainLengths[i]) {
                    chainLengths[i] = chainLengths[j] + 1;
                }
            }

            maxChainLength = Math.max(maxChainLength, chainLengths[i]);
        }

        return maxChainLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        for(int i=0; i<number;i++){
            int n = scanner.nextInt();
            scanner.nextLine();
            String bloodTypesInput = scanner.nextLine();

            String[] bloodTypes = bloodTypesInput.split(" ");
            
            int maxChainLength = findMaxChainLength(n, bloodTypes);
            System.out.println(maxChainLength);
            
        }
        
        
    }
}
