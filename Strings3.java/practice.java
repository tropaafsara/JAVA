import java.util.Scanner;

public class practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int res = Math.abs((a*b)-(a+b));
        System.out.println(res);
    }
}
