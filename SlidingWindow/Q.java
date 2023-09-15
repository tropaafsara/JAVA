import java.util.Scanner;

public class Q {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            // int n = sc.nextInt();
            // String s = sc.next();
            // if(n>=3){
            //     for (int i = 0; i < n; i++) {
            // if (s.charAt(i) == '0') {
            //     System.out.print(0);
            // } else {
            //     System.out.print(1);
            //     for (int j = i + 1; j < n; j++) {
            //         System.out.print(0);
            //     }
            //     break;
            //     }
            // }
            // }
            int N = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            String s = sc.nextLine();
            boolean flag = false;
            char[] sArray = s.toCharArray();

            for (int i = 0; i < N; ++i) {
                if (sArray[i] == '0' || flag) {
                    sArray[i] = '0';
                } else {
                    sArray[i] = '1';
                    flag = true;
                }
            }
            
            System.out.println(new String(sArray));

        }
    }
}
