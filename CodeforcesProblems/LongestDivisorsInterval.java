import java.util.Scanner;

public class LongestDivisorsInterval {//sliding window -> variable size window
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-->0){
            long n= sc.nextLong();
            long m = 0;
            long count = 0;
            for(long i=1;i<1000000;i++){
                 count=0; 
                long a=i; 
                while(n%a++==0){
                    count++;
                    
                }
                m=Math.max(m,count); 
            }
            System.out.println(m);

        }
    }
}
