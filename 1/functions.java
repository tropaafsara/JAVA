import java.util.*;

public class functions {
    public static void printHelloWorld() {
        System.out.println("HELLO WORLD");
        System.out.println("HELLO WORLD");
        System.out.println("HELLO WORLD");
        
    }
    public static int calcSum(int n1, int n2){ //n1 & n2 = parameters
        
        int s = n1+n2;
        return s;
    }
    public static void main(String[] args) {
        // printHelloWorld();
        Scanner sc = new Scanner (System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum  = calcSum(a,b);//a & b = arguments
        System.out.println(sum);
    }
}
