import java.util.Scanner;

public class LuckyDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        if(n%4==0 ||n%7==0 || n%47==0){
         System.out.println("YES");
        }else{
            while(n>0){
            if(n%10==4 || n%10==7){
                n=n/10;
                if(n==4||n==7){
                    System.out.println("YES");
                }
            }else{
                System.out.println("NO");
                break;
            }
            }
            
        }
    }
}
