import java.util.Scanner;

public class PetyaAndStrings {
    public static int comapare(String s1, String s2){
        for(int i=0;i<s1.length();i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1>c2){
                return 1;
            }
            if(c1<c2){
                return -1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next().toLowerCase();
        String s2 = sc.next().toLowerCase();


        int res = comapare(s1,s2);
        System.out.println(res);
    }
}
