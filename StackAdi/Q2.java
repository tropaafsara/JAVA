import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q2 {

    public static int checkRedundancy(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch==')'){
                char top = s.peek();
                s.pop();
                int flag =1;
                while(!s.isEmpty() && top!='('){
                    if(top=='+'||top=='-'||top=='*'||top=='/'){
                        flag =0;
                    }
                    top = s.peek();
                    s.pop();
                } 

                if(flag==1){
                    return 1;
                }

            }else{
                s.push(ch);
            }
        }
        return 0;
        
    }
    //
    static long mod = (long) 1e9 + 7;

    static long factorial(int a) {
        long ans = 1;
        for (int i = 1; i <= a; i++) {
            ans = (ans % mod * i % mod) % mod;
        }
        return ans % mod;
    }

    static long parity(int a, int b) {
        if (a == 0)
            return factorial(b);
        return factorial(a);
    }
    static long solve(int a, int b) {
        long res = 1;
        res = (res * factorial(a)) % mod;
        res = (res * factorial(b)) % mod;
        return res;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int evenNumber = 0;
            int oddNumber = 0;
            int[] arr = new int[a];
            for (int i = 0; i < a; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] % 2 == 0)
                    evenNumber++;
                else
                    oddNumber++;
            }
            if (b == 0) {
                if (evenNumber > 0 && oddNumber > 0) {
                    System.out.println(0);
                    continue;
                } else {
                    long ans = parity(evenNumber, oddNumber);
                    System.out.println(ans);
                }
            } else {
                if (Math.abs(evenNumber - oddNumber) > 1) {
                    System.out.println(0);
                    continue;
                }
                if (Math.abs(evenNumber - oddNumber) == 0) {
                    long p = solve(evenNumber, oddNumber);
                    // p = (p * 2) % mod;
                    System.out.println((p * 2) % mod);
                } else {
                    long result = solve(evenNumber, oddNumber);
                    System.out.println(result);
                }
            }
        }
    }
}
