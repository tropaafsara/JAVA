import java.util.Scanner;

public class C {
    static char solveeeeee(String s, int pos) {
        int n = s.length();
        int len = n*(n+1)/2;
        int i=0;
        while (i <n && pos > 0) {
            int nextChars = len -(i + 1) * (n - i) / 2; 
            if (pos <= nextChars) {
                return s.charAt(i);
            }
            pos-= nextChars;
            i++;
        }
        return '\0';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            String s = sc.next();
            int pos = sc.nextInt();

            char result = solveeeeee(s, pos);
            System.out.println();
            System.out.print(result);
        }
    }
}
