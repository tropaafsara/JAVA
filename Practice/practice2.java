import java.util.Scanner;

public class practice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* int n= sc.nextInt();
        int i, even, odd, sumOfEven=0, sumOfOdd=0;
        for(i=0;i<n-1;i++){
            
            if(n%2==0){
                sumOfEven += n;
            }
            else{
                sumOfOdd +=n;
            }
        }
        System.out.println(sumOfEven);
        System.out.println(sumOfOdd);
    } */

    /* int number, choice, evenSum=0, oddSum =0;
    do {
        System.out.println("Enter the number");
        number  = sc.nextInt();
        if(number%2==0){
            evenSum+=number;
        }else{
            oddSum+=number;
        }
        System.out.println("Do you want to continue? If yes press '1' or if then press '0");
        choice = sc.nextInt();

    }while(choice==1);
    System.out.println("Sum of Even Numbers: "+evenSum);
    System.out.println("Sum of Odd Numbers: "+oddSum);
    } */


    //3. Find factorial of any number ------------------------------
    //6!=6*5*4*3*2*1
    int n= sc.nextInt();
    int i, r=1;
    
    for(i=n;i>0;i--){
        r = r*i;
    }
    System.out.println(r);

}
}
