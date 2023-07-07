import java.text.NumberFormat.Style;
import java.util.*;
// package Practice;

public class practice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1.---------------------------------
        /* int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int avg = (a+b+c)/3;
        System.out.println(avg); */

//2.---------------------------------
        /* int a = sc.nextInt();
        int b = sc.nextInt();
        float area = a*b;
        System.out.println(area); */
//3.---------------------------------
        /* float cost_of_pencil = sc.nextFloat();
        float cost_of_pen = sc.nextFloat();
        float cost_of_eraser = sc.nextFloat();
        float totalCost = (cost_of_eraser+cost_of_pen+cost_of_pencil);
        System.out.println(totalCost);
        //add 18% tax
        float newTotal = totalCost+(0.18f*totalCost);
        System.out.println(newTotal); */
        

        short s = 512;
        byte b = 4;
        char c ='a';
        int i = 1000;
        float f = 3.14f;
        double d = 99.9954;
        double result = (f*b)+(i%c)-(d*s);
        System.out.println(result);


    }
    
}
