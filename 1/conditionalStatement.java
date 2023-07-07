import java.util.Scanner;

public class conditionalStatement {
    public static void main(String[] args) {
        /* Scanner sc = new Scanner(System.in);
        int income = sc.nextInt();
        int tax;
        if(income<50){
            tax =0;
        }
        else if(income>=50 && income<10){
            tax= (int)(income * 0.2);
        }
        else{
            tax = (int)(income *0.3); //integer income will convert into double, double n double multiply is souble and typecast into integer
        }
        System.out.println(tax); */


        //ternary operator
        int marks = 67;
        String report = marks >=33 ? "PASS" : "FAIL";
        System.out.println(report);


    }
}
